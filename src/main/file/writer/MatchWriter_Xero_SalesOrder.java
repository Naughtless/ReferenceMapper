package main.file.writer;

import main.data.salesorder.SalesOrder;
import main.data.xero.XeroGBR;
import main.data.matches.MatchXSO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MatchWriter_Xero_SalesOrder {
    //<editor-fold desc="Properties">
    private ArrayList<MatchXSO> matchedData;
    private ArrayList<MatchXSO> matchedDataIncorrect;

    private ArrayList<XeroGBR> xeroSinglesData;
    private ArrayList<SalesOrder> soSinglesData;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public MatchWriter_Xero_SalesOrder() {}
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void writeMatches(String dir) throws IOException {
        // Ensure directory exists!
        File dirmaker = new File(dir);
        File parentDirmaker = dirmaker.getParentFile();
        if(parentDirmaker != null && !parentDirmaker.exists()) {
            parentDirmaker.mkdirs();
        }

        BufferedWriter matchWriter = new BufferedWriter(new FileWriter(dir));

        // Header
        matchWriter.write(MatchXSO.getHeader());
        matchWriter.newLine();

        // Contents: Matched Data w/ Correct Sales Number
        for(int i = 0; i < matchedData.size(); ++i) {
            matchWriter.write(matchedData.get(i).buildCSVLine());
            matchWriter.newLine();
        }

        // Contents: Matched Data w/ INCORRECT
        for(int i = 0; i < matchedDataIncorrect.size(); ++i) {
            matchWriter.write(matchedDataIncorrect.get(i).buildCSVLine());
            matchWriter.newLine();
        }

        matchWriter.flush();
        matchWriter.close();
    }

    public void writeGroupedXeroSingles(String dir) throws IOException {
        // Ensure directory exists!
        File dirmaker = new File(dir);
        File parentDirmaker = dirmaker.getParentFile();
        if(parentDirmaker != null && !parentDirmaker.exists()) {
            parentDirmaker.mkdirs();
        }

        BufferedWriter xeroGroupWriter = new BufferedWriter(new FileWriter(dir));

        // Header
        xeroGroupWriter.write(XeroGBR.getHeader());
        xeroGroupWriter.newLine();

        // Contents
        for(int i = 0; i < xeroSinglesData.size(); ++i) {
            xeroGroupWriter.write(xeroSinglesData.get(i).buildCSVLine());
            xeroGroupWriter.newLine();
        }

        xeroGroupWriter.flush();
        xeroGroupWriter.close();
    }

//    public void writeSalesOrderSingles(String dir) throws IOException {
//        BufferedWriter salesOrderWriter = new BufferedWriter(new FileWriter(dir));
//
//        // Header
//        salesOrderWriter.write(SalesOrder.getHeader());
//        salesOrderWriter.newLine();
//
//        // Contents
//        for(int i = 0; i < soSinglesData.size(); ++i) {
//            salesOrderWriter.write(soSinglesData.get(i).buildCSVLine());
//            salesOrderWriter.newLine();
//        }
//
//        salesOrderWriter.flush();
//        salesOrderWriter.close();
//    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public ArrayList<MatchXSO> getMatchedData() {
        return matchedData;
    }

    public void setMatchedData(ArrayList<MatchXSO> matchedData) {
        this.matchedData = matchedData;
    }

    public ArrayList<MatchXSO> getMatchedDataIncorrect() {
        return matchedDataIncorrect;
    }

    public void setMatchedDataIncorrect(ArrayList<MatchXSO> matchedDataIncorrect) {
        this.matchedDataIncorrect = matchedDataIncorrect;
    }

    public ArrayList<XeroGBR> getXeroSinglesData() {
        return xeroSinglesData;
    }

    public void setXeroSinglesData(ArrayList<XeroGBR> xeroSinglesData) {
        this.xeroSinglesData = xeroSinglesData;
    }

    public ArrayList<SalesOrder> getSoSinglesData() {
        return soSinglesData;
    }

    public void setSoSinglesData(ArrayList<SalesOrder> soSinglesData) {
        this.soSinglesData = soSinglesData;
    }
    //</editor-fold>
}
