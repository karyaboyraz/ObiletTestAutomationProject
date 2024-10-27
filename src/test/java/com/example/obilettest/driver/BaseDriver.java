package com.example.obilettest.driver;

import com.example.obilettest.Methods.ConfigReader;
import com.example.obilettest.Methods.UserDataGenerator;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * BaseDriver class manages the setup and teardown of WebDriver instances for each test scenario.
 */
public class BaseDriver {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDriver.class);

    /**
     * Runs before each scenario. Initializes the WebDriver and navigates to the base URL.
     */
    @BeforeScenario
    public void setUp() {
        // Generate user data
        generateUserData();

        // Initialize WebDriver
        DriverFactory.initializeDriver();

        // Get WebDriver instance
        WebDriver driver = DriverFactory.getDriver();

        // Navigate to the base URL
        String baseUrl = ConfigReader.getProperty("TEST_URL");
        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new IllegalStateException("Base URL is not specified in the configuration file.");
        }
        driver.get(baseUrl);
    }

    /**
     * Runs after each scenario. Quits the WebDriver.
     */
    @AfterScenario
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    /**
     * Generates user data and writes it to a CSV file.
     */
    private void generateUserData() {
        try {
            UserDataGenerator generator = new UserDataGenerator();
            generator.generateUserCSV();
        } catch (IOException e) {
            LOGGER.error("Error occurred while generating user data.", e);
            throw new RuntimeException("Failed to generate user data.", e);
        }
    }
}