package opencsv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * - Application class demonstrating writing Java objects to a CSV file using OpenCSV StatefulBeanToCsvBuilder.
 * Use Case     : UC2 - Write Java Objects to CSV File
 * Author       : Hemang
 * Date         : 21-10-2026
 */
public class OpenCSVWriter {

    // Relative path for destination CSV file
    private static final String STRING_ARRAY_SAMPLE = "./src/main/resources/users-write.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        // Open BufferedWriter to write destination file
        try (Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE))) {

            // Build StatefulBeanToCsv object mapping CSVUser class
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder<CSVUser>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            // Populate sample CSVUser list
            List<CSVUser> myUsers = new ArrayList<>();
            myUsers.add(new CSVUser("Sundar Pichai", "sundar.pichai@gmail.com", "+1-1111111111", "United States"));
            myUsers.add(new CSVUser("Satya Nadella", "satya.nadella@outlook.com", "+1-2222222222", "United States"));

            // Write user list to CSV file
            beanToCsv.write(myUsers);
            System.out.println("Data successfully written to " + STRING_ARRAY_SAMPLE);
        }
    }
}
