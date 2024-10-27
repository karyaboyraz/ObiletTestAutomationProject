package com.example.obilettest.driver;

import com.example.obilettest.Methods.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DriverFactory is a utility class that manages WebDriver instances.
 * It creates and provides WebDriver instances in a thread-safe manner.
 */
public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
        // Private constructor prevents instantiation of this class
    }

    /**
     * Initializes the WebDriver instance for the current thread.
     */
    public static void initializeDriver() {
        if (driver.get() == null) {
            synchronized (DriverFactory.class) {
                if (driver.get() == null) {
                    String browser = ConfigReader.getProperty("BROWSER", "chrome");
                    WebDriver webDriver;

                    switch (browser.toLowerCase()) {
                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            ChromeOptions chromeOptions = new ChromeOptions();
                            chromeOptions.addArguments(
                                    "--disable-notifications",
                                    "--disable-popup-blocking",
                                    "--start-maximized",
                                    "--disable-translate",
                                    "test-type",
                                    "--disable-blink-features=AutomationControlled"
                            );

                            // Remove info bars and automation layers
                            chromeOptions.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
                            chromeOptions.setExperimentalOption("useAutomationExtension", false);

                            // Set preferences to disable various prompts
                            Map<String, Object> prefs = new HashMap<>();
                            prefs.put("profile.default_content_setting_values.notifications", 2);
                            prefs.put("profile.default_content_setting_values.geolocation", 2);
                            prefs.put("credentials_enable_service", false);
                            prefs.put("profile.password_manager_enabled", false);
                            chromeOptions.setExperimentalOption("prefs", prefs);

                            webDriver = new ChromeDriver(chromeOptions);
                            break;
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            webDriver = new FirefoxDriver();
                            break;
                        case "edge":
                            WebDriverManager.edgedriver().setup();
                            webDriver = new EdgeDriver();
                            break;
                        case "safari":
                            WebDriverManager.getInstance(SafariDriver.class).setup();
                            webDriver = new SafariDriver();
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported browser: " + browser);
                    }

                    driver.set(webDriver);
                }
            }
        }
    }

    /**
     * Returns the WebDriver instance for the current thread.
     *
     * @return the WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    /**
     * Quits and cleans up the WebDriver instance for the current thread.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}