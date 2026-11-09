package opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Description:
 * - Main class to read and parse CSV records directly into POJO objects using OpenCSV CsvToBeanBuilder.
 * Use Case     : UC1 - Parse CSV File to POJO Beans using OpenCSV
 * Author       : Hemang
 * Date         : 21-10-2026
 */

public class OpenCSVReadAndParseToBean {

    // Define relative path for input CSV file
    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/users.csv";

    public static void main(String[] args) throws IOException {

        // Open BufferedReader to read the CSV file
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))) {

            // Build CsvToBean object mapped to CSVUser class
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // Create iterator to process records line-by-line
            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            // Iterate over CSV records and display details
            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name: " + csvUser.getName());
                System.out.println("Email: " + csvUser.getEmail());
                System.out.println("PhoneNo: " + csvUser.getPhoneNo());
                System.out.println("Country: " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
    }
}
