package com.example.obilettest.Methods;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * UserDataGenerator is a utility class that generates user data and writes it to a CSV file.
 */
public class UserDataGenerator {

    private static final String DEFAULT_CSV_FILE_NAME = "randomUserData.csv";
    private static final String DEFAULT_FAKER_LOCALE = ConfigReader.getProperty("TEST_DATA_LANGUAGE");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String[] CITIES_WITH_AIRPORTS = {
            "İstanbul", "Ankara", "İzmir", "Antalya", "Adana", "Trabzon",
            "Dalaman", "Gaziantep", "Bursa", "Konya", "Kayseri", "Diyarbakır",
            "Samsun", "Hatay", "Erzurum", "Mardin"
    };
    private final com.github.javafaker.Faker faker;

    /**
     * Constructs a UserDataGenerator with a Faker instance initialized with the default locale.
     */
    public UserDataGenerator() {
        this.faker = new com.github.javafaker.Faker(new Locale.Builder().setLanguage(DEFAULT_FAKER_LOCALE).setRegion(DEFAULT_FAKER_LOCALE).build());
    }

    /**
     * Main method to generate user data and write it to a CSV file.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            UserDataGenerator generator = new UserDataGenerator();
            generator.generateUserCSV();
            System.out.println("User Data Created Successfully");
        } catch (IOException e) {
            System.err.println("An error was : " + e.getMessage());
        }
    }

    /**
     * Generates a map containing user data.
     *
     * @return a map with user data
     */
    public Map<String, String> generateUser() {
        Map<String, String> user = new LinkedHashMap<>();
        String name = faker.name().firstName();
        String surname = faker.name().lastName();

        String origin = getRandomCityWithAirport();
        String destination;
        do {
            destination = getRandomCityWithAirport();
        } while (destination.equals(origin));

        LocalDate departureDate = LocalDate.now().plusDays(faker.number().numberBetween(1, 10));
        LocalDate returnDate = departureDate.plusDays(faker.number().numberBetween(1, 10));

        user.put("RandomName", name);
        user.put("RandomSurname", surname);
        user.put("RandomEmail", generateRandomEmail(name, surname));
        user.put("RandomPassword", faker.internet().password());
        user.put("RandomOrigin", origin);
        user.put("RandomDestination", destination);
        user.put("RandomDepartureDate", DATE_FORMAT.format(departureDate));
        user.put("RandomReturnDate", DATE_FORMAT.format(returnDate));

        return user;
    }

    /**
     * Retrieves a random city with an airport from the predefined list.
     *
     * @return a random city with an airport
     */
    private String getRandomCityWithAirport() {
        return faker.options().option(CITIES_WITH_AIRPORTS);
    }

    /**
     * Removes Turkish characters from the input string.
     *
     * @param input the input string
     * @return the input string with Turkish characters replaced
     */
    private String removeTurkishCharacters(String input) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('ç', 'c');
        charMap.put('ğ', 'g');
        charMap.put('ı', 'i');
        charMap.put('ö', 'o');
        charMap.put('ş', 's');
        charMap.put('ü', 'u');
        charMap.put('Ç', 'C');
        charMap.put('Ğ', 'G');
        charMap.put('İ', 'I');
        charMap.put('Ö', 'O');
        charMap.put('Ş', 'S');
        charMap.put('Ü', 'U');

        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            sb.append(charMap.getOrDefault(c, c));
        }
        return sb.toString();
    }

    /**
     * Generates a random email address using the given name and surname.
     *
     * @param name the user's first name
     * @param surname the user's last name
     * @return a random email address
     */
    private String generateRandomEmail(String name, String surname) {
        name = removeTurkishCharacters(name.toLowerCase(Locale.ROOT));
        surname = removeTurkishCharacters(surname.toLowerCase(Locale.ROOT));
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        return name + "." + surname + "." + uniqueId + "@gmail.com";
    }

    /**
     * Generates user data and writes it to a CSV file.
     *
     * @throws IOException if an I/O error occurs
     */
    public void generateUserCSV() throws IOException {
        List<Map<String, String>> users = new ArrayList<>();
        int userCount = Integer.parseInt(ConfigReader.getProperty("TEST_USER"));
        for (int i = 0; i < userCount; i++) {
            users.add(generateUser());
        }

        try (FileWriter writer = new FileWriter(DEFAULT_CSV_FILE_NAME)) {
            if (!users.isEmpty()) {
                writer.append(String.join(",", users.get(0).keySet())).append("\n");
                for (Map<String, String> user : users) {
                    writer.append(String.join(",", user.values())).append("\n");
                }
            }
        }
    }
}