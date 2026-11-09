package opencsv;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * - Application class demonstrating OpenCSV and Gson integration to convert CSV data to JSON and parse JSON back into Java objects.
 * Use Case     : UC3 - CSV to JSON and JSON to Java Objects using Gson
 * Author       : Hemang
 * Date         : 21-10-2026
 */
public class OpenCSVAndGsonTester {

    // Paths for input CSV and destination JSON files
    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/users.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "./src/main/resources/users.json";

    public static void main(String[] args) {
        try {
            // 1. Read CSV file into List of CSVUser objects
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();

            // 2. Convert CSVUser list to JSON string using Gson
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);

            // 3. Write JSON string to users.json file
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            System.out.println("Successfully written CSV data to JSON file: " + SAMPLE_JSON_FILE_PATH);

            // 4. Read JSON file back into Java Objects
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);

            // Print read JSON objects to console
            System.out.println("\nParsed CSVUser objects from JSON file:");
            for (CSVUser user : csvUserList) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
