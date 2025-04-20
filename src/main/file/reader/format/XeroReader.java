/*
Notes
-----
Xero format:
- dunno yet.............
 */
package main.file.reader.format;

import main.data.xero.Xero;
import main.file.reader.CSVReader;

import java.io.IOException;
import java.util.ArrayList;

public class XeroReader extends CSVReader {
    //<editor-fold desc="Properties">
    private ArrayList<Xero> contents;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public XeroReader(String fileName) throws IOException {
        super(fileName);
    }
    //</editor-fold>

    //<editor fold desc="Methods">
    public void processResults() {
        contents = new ArrayList<>();

        for(int i = 0; i < getReadResults().size(); ++i) {
            if(i > 0) {
                contents.add(new Xero(
                        getReadResults().get(i)[0],
                        getReadResults().get(i)[1],
                        getReadResults().get(i)[2],
                        getReadResults().get(i)[3],
                        getReadResults().get(i)[4],
                        getReadResults().get(i)[5],
                        getReadResults().get(i)[6],
                        getReadResults().get(i)[7],
                        getReadResults().get(i)[8],
                        getReadResults().get(i)[9],
                        getReadResults().get(i)[10]
                ));
            }
        }
    }

    public void printEntry(int i) {
        System.out.println(contents.get(i));
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public ArrayList<Xero> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Xero> contents) {
        this.contents = contents;
    }
    //</editor-fold>
}
