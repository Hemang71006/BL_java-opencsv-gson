# BL_java-opencsv-gson

## Description
This repository contains a comprehensive Java-based implementation designed to demonstrate end-to-end processing of structured data using open-source libraries: **OpenCSV** and Google **Gson**.

The application showcases effective bean-binding techniques, serializing Java POJO instances into CSV formats, parsing CSV entries into strongly typed Java entities, converting flat CSV data structures into JSON payloads, and deserializing JSON text back into native Java arrays and collections.

Key functionality integrated within this project:
- **CSV Parsing to POJO:** Line-by-line reading and mapping of header-based CSV records using `CsvToBeanBuilder`.
- **CSV Data Generation:** Object-to-CSV generation with custom formatting and bean serialization via `StatefulBeanToCsvBuilder`.
- **JSON Serialization & Deserialization:** Integrating Gson to process CSV-mapped collections, serialize data structures to `users.json`, and rebuild object graphs using `gson.fromJson()`.
- **Clean Architecture & Versioning:** Enforcing separation between project documentation on `main` and complete source code implementations across `develop` and feature branches.

---

## Branch Strategy & Workflow
- **`main`**: Dedicated exclusively to project documentation (`README.md`).
- **`develop`**: Central integration branch containing source code and resources.
- **`feature/csv-reader`**: UC 1 - Read CSV and map to POJO beans (`CSVUser`).
- **`feature/csv-writer`**: UC 2 - Write POJO lists to CSV files.
- **`feature/csv-gson-json`**: UC 3 - OpenCSV and Gson integration for JSON parsing and serialization.

---

## Technology Stack & Dependencies
- **Language:** Java 11
- **Build System:** Maven
- **Dependencies:**
  - `com.opencsv:opencsv:4.0`
  - `com.google.code.gson:gson:2.8.9`

---

## Implemented Use Cases

### UC 1: Read CSV File & Map to POJO (`feature/csv-reader`)
- Defined `CSVUser` POJO with `@CsvBindByName` annotations.
- Used `CsvToBeanBuilder` to read `users.csv` line-by-line and populate Java objects.

### UC 2: Write Java Objects to CSV (`feature/csv-writer`)
- Used `StatefulBeanToCsvBuilder` with `CSVWriter.NO_QUOTE_CHARACTER`.
- Dynamically generated `users-write.csv` from Java list elements.

### UC 3: CSV to JSON & JSON Deserialization using Gson (`feature/csv-gson-json`)
- Parsed CSV rows to Java objects using OpenCSV.
- Serialized Java objects into JSON using Gson and wrote output to `users.json`.
- Deserialized `users.json` content back into Java object arrays using `gson.fromJson()`.

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


- **Author:** Hemang
- **Date:** 21-10-2026