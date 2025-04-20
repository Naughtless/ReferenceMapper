/*
Notes
-----
Cin7 format:
- First line is not header and should be discarded.
- Second line is header.
- Last line is "Grand Total" and should be discarded.
 */

package main.file.reader.format;

import main.data.cin7.Cin7;
import main.file.reader.CSVReader;

import java.io.IOException;
import java.util.ArrayList;

public class Cin7Reader extends CSVReader {
    //<editor-fold desc="Properties">
    private ArrayList<Cin7> contents;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public Cin7Reader(String fileName) throws IOException {
        super(fileName);
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void processResults() {
        contents = new ArrayList<>();

        for(int i = 0; i < getReadResults().size(); ++i) {
            if(i > 0) {
                contents.add(new Cin7(
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
                        getReadResults().get(i)[10],
                        getReadResults().get(i)[11],
                        getReadResults().get(i)[12],
                        getReadResults().get(i)[13],
                        getReadResults().get(i)[14],
                        getReadResults().get(i)[15],
                        getReadResults().get(i)[16],
                        getReadResults().get(i)[17],
                        getReadResults().get(i)[18],
                        getReadResults().get(i)[19]
                ));
            }
        }

    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public ArrayList<Cin7> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Cin7> contents) {
        this.contents = contents;
    }
    //</editor-fold>
}
