package main.file.writer;

import main.data.cin7.Cin7;
import main.data.xero.Xero;
import main.data.cin7.Cin7GBR;
import main.data.xero.XeroGBR;
import main.data.matches.MatchGBR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MatchWriter_Cin7_Xero {
    //<editor-fold desc="Properties">
    private ArrayList<MatchGBR> matchedData;
    private ArrayList<MatchGBR> matchedDataIncorrect;

    private ArrayList<Cin7GBR> cinSinglesData;
    private ArrayList<XeroGBR> xeroSinglesData;

    private int cinSinglesWriteCount;
    private int xeroSinglesWriteCount;
    //</editor-fold desc

    //<editor-fold desc="Constructor">
    public MatchWriter_Cin7_Xero() {}
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void writeMatches(String dir) throws IOException {

        // Ensure directory exists!
        File dirmaker = new File(dir);
        File parentDirmaker = dirmaker.getParentFile();
        if(parentDirmaker != null && !parentDirmaker.exists()) {
            parentDirmaker.mkdirs();
        }

        // Instantiate Buffered writer.
        BufferedWriter matchWriter = new BufferedWriter(new FileWriter(dir));

        // Header
        matchWriter.write(MatchGBR.getHeader());
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

    public void writeGroupedCinSingles(String dir) throws IOException {
        // Ensure directory exists!
        File dirmaker = new File(dir);
        File parentDirmaker = dirmaker.getParentFile();
        if(parentDirmaker != null && !parentDirmaker.exists()) {
            parentDirmaker.mkdirs();
        }

        BufferedWriter cinGroupWriter = new BufferedWriter(new FileWriter(dir));

        // Header
        cinGroupWriter.write(Cin7GBR.getHeader());
        cinGroupWriter.newLine();

        // Contents

        // Write by reference group.
        for(int i = 0; i < cinSinglesData.size(); ++i) {
            cinGroupWriter.write(cinSinglesData.get(i).buildCSVLine());
            cinGroupWriter.newLine();
        }

        cinGroupWriter.flush();
        cinGroupWriter.close();
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

    public void writeUngroupedCinSingles(String dir) throws IOException {
        // Ensure directory exists!
        File dirmaker = new File(dir);
        File parentDirmaker = dirmaker.getParentFile();
        if(parentDirmaker != null && !parentDirmaker.exists()) {
            parentDirmaker.mkdirs();
        }

        BufferedWriter cinSinglesWriter = new BufferedWriter(new FileWriter(dir));

        cinSinglesWriteCount = 0;

        // Header
        cinSinglesWriter.write(Cin7.getHeader());
        cinSinglesWriter.newLine();

        // Contents
        for(int i = 0; i < cinSinglesData.size(); ++i) { // Group loop.
            for(int j = 0; j < cinSinglesData.get(i).getMembers().size(); ++j) {
                cinSinglesWriter.write(cinSinglesData.get(i).getMembers().get(j).buildCSVLine());
                cinSinglesWriter.newLine();

                cinSinglesWriteCount++;
            }
        }

        cinSinglesWriter.flush();
        cinSinglesWriter.close();
    }

    public void writeUngroupedXeroSingles(String dir) throws IOException {
        // Ensure directory exists!
        File dirmaker = new File(dir);
        File parentDirmaker = dirmaker.getParentFile();
        if(parentDirmaker != null && !parentDirmaker.exists()) {
            parentDirmaker.mkdirs();
        }

        BufferedWriter xeroSinglesWriter = new BufferedWriter(new FileWriter(dir));

        xeroSinglesWriteCount = 0;

        // Header
        xeroSinglesWriter.write(Xero.getHeader());
        xeroSinglesWriter.newLine();

        // Contents
        for(int i = 0; i < xeroSinglesData.size(); ++i) {
            for(int j = 0; j < xeroSinglesData.get(i).getMembers().size(); ++j) {
                xeroSinglesWriter.write(xeroSinglesData.get(i).getMembers().get(j).buildCSVLine());
                xeroSinglesWriter.newLine();

                xeroSinglesWriteCount++;
            }
        }

        xeroSinglesWriter.flush();
        xeroSinglesWriter.close();
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public ArrayList<MatchGBR> getMatchedData() {
        return matchedData;
    }

    public void setMatchedData(ArrayList<MatchGBR> matchedData) {
        this.matchedData = matchedData;
    }

    public ArrayList<MatchGBR> getMatchedDataIncorrect() {
        return matchedDataIncorrect;
    }

    public void setMatchedDataIncorrect(ArrayList<MatchGBR> matchedDataIncorrect) {
        this.matchedDataIncorrect = matchedDataIncorrect;
    }

    public ArrayList<Cin7GBR> getCinSinglesData() {
        return cinSinglesData;
    }

    public void setCinSinglesData(ArrayList<Cin7GBR> cinSinglesData) {
        this.cinSinglesData = cinSinglesData;
    }

    public ArrayList<XeroGBR> getXeroSinglesData() {
        return xeroSinglesData;
    }

    public void setXeroSinglesData(ArrayList<XeroGBR> xeroSinglesData) {
        this.xeroSinglesData = xeroSinglesData;
    }

    public int getCinSinglesWriteCount() {
        return cinSinglesWriteCount;
    }

    public int getXeroSinglesWriteCount() {
        return xeroSinglesWriteCount;
    }
    //</editor-fold>
}
