package pl.wojcik.airlinereservationsystem.model.dataGenerator;

import com.opencsv.CSVReader;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GeneratorCommonUtils {

    static String AIRCRAFT_PATH = "csv/aircrafts.csv";
    static String FLIGHT_PATH = "csv/flights.csv";
    static String PASSENGER_PATH = "csv/passengers.csv";

    public static List<String[]> getRowList(String path) throws Exception {

        Reader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource(path).toURI()));

        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = csvReader.readAll();

        reader.close();
        csvReader.close();

        return list;
    }
}
