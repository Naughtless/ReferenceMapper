package main.file.reader.format;

import main.data.salesorder.SalesOrder;
import main.file.reader.CSVReader;

import java.io.IOException;
import java.util.ArrayList;

public class SalesOrderReader extends CSVReader {
    ArrayList<SalesOrder> contents;

    public SalesOrderReader(String fileName) throws IOException {
        super(fileName);
    }

    public void processResults() {
        contents = new ArrayList<>();

        for(int i = 0; i < getReadResults().size(); ++i) {
            if(i > 0) {
                //DEBUG
//                System.out.println("DEBUG: Line #" + i + " has a length of " + getReadResults().get(i).length);
                if(getReadResults().get(i).length == 20) {
                    contents.add(new SalesOrder(
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
                else {
                    contents.add(new SalesOrder(
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
                            ""
                    ));
                }
            }
        }
    }

    public void printEntry(int i) {
        System.out.println(contents.get(i));
    }

    //<editor-fold desc="Getters & Setters">
    public ArrayList<SalesOrder> getContents() {
        return contents;
    }

    public void setContents(ArrayList<SalesOrder> contents) {
        this.contents = contents;
    }
    //</editor-fold>
}
