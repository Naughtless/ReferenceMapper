package main.file.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    //<editor-fold desc="Properties">
    private BufferedReader reader;
    private ArrayList<String[]> readResults;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public CSVReader(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        readResults = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void readFile() throws IOException {
        String line;
        int debugCounter = 0;
        while((line = reader.readLine()) != null) {
            String fixedLine = line.replace("\n", "");
            fixedLine = fixedLine.replace("\r", "");
            fixedLine = fixedLine.replace(System.lineSeparator(), "");

            fixedLine = fixedLine + "|x";

            //DEBUG
//            System.out.println("LINE #" + debugCounter + " : " + fixedLine);
            debugCounter++;

            readResults.add(fixedLine.split("\\|"));
        }
    }
    //</editor-fold>

    //<editor-fold desc="Setters & Getters">
    public BufferedReader getReader() {
        return reader;
    }
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
    public ArrayList<String[]> getReadResults() {
        return readResults;
    }
    public void setReadResults(ArrayList<String[]> readResults) {
        this.readResults = readResults;
    }
    //</editor-fold>
}
