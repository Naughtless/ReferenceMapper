package main.file.reader.format;

import main.data.xero.XeroGBR;
import main.file.reader.CSVReader;

import java.io.IOException;
import java.util.ArrayList;

public class XeroGBRReader extends CSVReader {
    private ArrayList<XeroGBR> contents;

    public XeroGBRReader(String fileName) throws IOException {
        super(fileName);
    }

    public void processResults() {
        contents = new ArrayList<>();

        for(int i = 0; i < getReadResults().size(); ++i) {
            if(i > 0) {
                contents.add(new XeroGBR(
                        getReadResults().get(i)[0],
                        getReadResults().get(i)[1],
                        getReadResults().get(i)[2],
                        getReadResults().get(i)[3],
                        getReadResults().get(i)[4],
                        getReadResults().get(i)[5],
                        getReadResults().get(i)[6]
                ));
            }
        }
    }

    public void printEntry(int i) {
        System.out.println(contents.get(i));
    }

    //<editor-fold desc="Getters & Setters">
    public ArrayList<XeroGBR> getContents() {
        return contents;
    }

    public void setContents(ArrayList<XeroGBR> contents) {
        this.contents = contents;
    }
    //</editor-fold>
}
