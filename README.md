Here is the updated Markdown for your `README.md` with `README.md` included in the project structure and explicitly labeled with `[main]`.

Copy and paste this directly:

```markdown
# BL_java-opencsv-gson

## Description
This repository contains Java implementations demonstrating the usage of open-source libraries **OpenCSV** and **Gson** to read, write, and parse structured CSV and JSON data into Java POJO objects.

---

## Project Structure
```text
BL_java-opencsv-gson/
│
├── README.md                           [main branch]
│
└── [develop branch]
    ├── .gitignore
    ├── pom.xml
    └── src/
        └── main/
            ├── java/
            │   └── opencsv/
            │       ├── CSVUser.java
            │       ├── OpenCSVReadAndParseToBean.java
            │       ├── OpenCSVWriter.java
            │       └── OpenCSVAndGsonTester.java
            └── resources/
                ├── users.csv
                ├── users-write.csv
                └── users.json

```

---

## Branch Strategy & Workflow

* **`main`**: Dedicated exclusively to project documentation (`README.md`).
* **`develop`**: Central integration branch containing source code and resources.
* **`feature/csv-reader`**: UC 1 - Read CSV and map to POJO beans (`CSVUser`).
* **`feature/csv-writer`**: UC 2 - Write POJO lists to CSV files.
* **`feature/csv-gson-json`**: UC 3 - OpenCSV and Gson integration for JSON parsing and serialization.

---

## Technology Stack & Dependencies

* **Language:** Java 11
* **Build System:** Maven
* **Dependencies:**
* `com.opencsv:opencsv:4.0`
* `com.google.code.gson:gson:2.8.9`



---

## Implemented Use Cases

### UC 1: Read CSV File & Map to POJO (`feature/csv-reader`)

* Defined `CSVUser` POJO with `@CsvBindByName` annotations.
* Used `CsvToBeanBuilder` to read `users.csv` line-by-line and populate Java objects.

### UC 2: Write Java Objects to CSV (`feature/csv-writer`)

* Used `StatefulBeanToCsvBuilder` with `CSVWriter.NO_QUOTE_CHARACTER`.
* Dynamically generated `users-write.csv` from Java list elements.

### UC 3: CSV to JSON & JSON Deserialization using Gson (`feature/csv-gson-json`)

* Parsed CSV rows to Java objects using OpenCSV.
* Serialized Java objects into JSON using Gson and wrote output to `users.json`.
* Deserialized `users.json` content back into Java object arrays using `gson.fromJson()`.

---

## Author Details

* **Developer:** Hemang
* **Date:** 21-10-2026

```

```