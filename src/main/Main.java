package main;

import main.console.Ansi;
import main.file.grouper.Cin7ReferenceGrouper;
import main.file.grouper.XeroReferenceGrouper;
import main.file.matcher.Matcher_Xero_SalesOrder;
import main.file.reader.format.Cin7Reader;
import main.file.matcher.Matcher_Cin7GBR_XeroGBR;
import main.file.reader.format.SalesOrderReader;
import main.file.reader.format.XeroGBRReader;
import main.file.reader.format.XeroReader;
import main.file.writer.MatchWriter_Cin7_Xero;
import main.file.writer.MatchWriter_Xero_SalesOrder;
import main.console.M;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String LIST_SEPARATOR = "|";

    public static void main(String[] args) {
        //<editor-fold desc="Welcome Message">
        System.out.println(Ansi.GREEN + "HELLO!" + Ansi.RESET);
//        System.out.println(Ansi.YELLOW  + "IMPORTANT NOTES:" + Ansi.RESET);
//        System.out.println("1. Make sure the result files (files in the 'results' folder) are not open. The script needs exclusive access to the files in order to write.");
//        System.out.println("2. Make sure the input files are sterilized.");
//        System.out.println("   - Sterilize line breaks.");
//        System.out.println("     * CTRL + H to open 'Find and Replace'.");
//        System.out.println("     * CTRL + J in the 'Find what' field to type in the line break hidden character.");
//        System.out.println("     * SPACEBAR in the 'Replace with' field to type in the SPACE character.");
//        System.out.println("     * Click on 'Replace All'.");
//        System.out.println("   - Clean up the headers.");
//        System.out.println("3. Export the source files (Cin7, Xero, or Sales Order) to CSV and put them in the 'sources' folder.");
//
//        MH.br();
        //</editor-fold>

        // Instantiate user-input reader.
        BufferedReader uReader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("---------- ---------- ---------- ---------- ----------");
            System.out.println(Ansi.BOLD + "What would you like to do?" + Ansi.RESET);
            System.out.println(Ansi.CYAN + "[" + Ansi.RED + Ansi.BOLD + "1" + Ansi.RESET + Ansi.CYAN + "] Crossmap Cin7 & Xero.");
            System.out.println(Ansi.CYAN + "[" + Ansi.RED + Ansi.BOLD + "2" + Ansi.RESET + Ansi.CYAN + "] Crossmap Xero-Singles & SalesOrder.");
            M.input("Make a choice...");

            String selectionInput = "0";

            try{
                selectionInput = uReader.readLine();
            }
            catch(IOException iox) {
                M.error(iox, "Something has gone very wrong whilst attempting to read user input.");
            }


            switch(selectionInput) {
                case "1":
                    compareCin7WithXero(uReader);
                    break;
                case "2":
                    compareXeroWithSalesOrder(uReader);
                    break;
                default:
                    M.warning("That is an invalid choice!");
            }
        }
    }

    public static void compareCin7WithXero(BufferedReader uReader) {
        //<editor-fold desc="Files Detection">
        File directory = new File("sources\\");

        File[] files = directory.listFiles(file -> file.isFile());
        M.info("Source files detected:");
        for(int i = 0; i < files.length; i++) {
            System.out.println(Ansi.MAGENTA + "[" + (i+1) + "] " + Ansi.RESET + files[i].getName());
        }
        //</editor-fold>

        Cin7Reader cinReader;
        XeroReader xeroReader;

        //<editor-fold desc="Read Source Files">
        // Read CIN SOURCE
        while(true) {
            M.input("Specify " + Ansi.RED + "Cin7" + Ansi.YELLOW + " source file!");

            String cinSource = "";
            try {
                cinSource = "sources\\" + files[Integer.parseInt(uReader.readLine())-1].getName();
                M.br();
            }
            catch(IOException iox) {
                M.error(iox, "Something has gone very wrong whilst attempting to read user input.");
            }

            try {
                M.info("Reading file \"" + cinSource + "\"...");

                cinReader = new Cin7Reader(cinSource);
                cinReader.readFile();
                cinReader.processResults();

                M.info("DONE!");
                M.br();

                break;
            }
            catch(IOException ignored) {
                M.warning("File reading failed!");
                M.info("Make sure the file name is typed correctly, case sensitive.");
                M.info("Try again!");
                M.br();
                continue;
            }
        }

        // Read XERO SOURCE
        while(true) {
            M.input("Specify " + Ansi.RED + "Xero" + Ansi.YELLOW + " source file!");

            String xeroSource = "";
            try {
                xeroSource = "sources\\" + files[Integer.parseInt(uReader.readLine())-1].getName();
                M.br();
            }
            catch(IOException iox) {
                M.error(iox, "Something has gone very wrong whilst attempting to read user input.");
            }

            try {
                M.info("Reading file \"" + xeroSource + "\"...");

                xeroReader = new XeroReader(xeroSource);
                xeroReader.readFile();
                xeroReader.processResults();

                M.info("DONE!");
                M.br();

                break;
            }
            catch(IOException e1) {
                M.warning("File reading failed!");
                M.info("Make sure the file name is typed correctly, case sensitive.");
                M.info("Try again!");
                M.br();
                continue;
            }
        }
        //</editor-fold>

        //<editor-fold desc="Group by Reference & Calculate 'Sales'">
        Cin7ReferenceGrouper cinGrouper = new Cin7ReferenceGrouper(cinReader.getContents());
        cinGrouper.group();
        cinGrouper.calculate();

        XeroReferenceGrouper xeroGrouper = new XeroReferenceGrouper(xeroReader.getContents());
        xeroGrouper.group();
        xeroGrouper.calculate();
        //</editor-fold>

        //<editor-fold desc="Matching">
//        MH.info("Processing data...");

        Matcher_Cin7GBR_XeroGBR matcher = new Matcher_Cin7GBR_XeroGBR(cinGrouper.getGroupedData(), xeroGrouper.getGroupedData());
        matcher.processResults();

//        MH.info("DONE!");
//        MH.br();
        //</editor-fold>

        //<editor-fold desc="Writing">
        M.info("Writing results...");

        // Instantiate writer.
        MatchWriter_Cin7_Xero writer = new MatchWriter_Cin7_Xero();

        // Matched data.
        writer.setMatchedData(matcher.getSalesMatch());
        writer.setMatchedDataIncorrect(matcher.getSalesMatchDiscrepant());

        // Singles data.
        writer.setCinSinglesData(matcher.getCinSingles());
        writer.setXeroSinglesData(matcher.getXeroSingles());

        // Attempt to write.
        while(true) {
            try{
                writer.writeMatches("results\\Cin7 & Xero\\matches.csv");

                writer.writeGroupedCinSingles("results\\Cin7 & Xero\\cin7_grouped_singles.csv");
                writer.writeGroupedXeroSingles("results\\Cin7 & Xero\\xero_grouped_singles.csv");

                writer.writeUngroupedCinSingles("results\\Cin7 & Xero\\cin7_ungrouped_singles.csv");
                writer.writeUngroupedXeroSingles("results\\Cin7 & Xero\\xero_ungrouped_singles.csv");

                break;
            }
            catch(IOException iox) {
                M.error(iox, "Failed to write to files. Please close all result files, then try again.");
            }
        }

        M.info("DONE!");
        M.br();

        M.info(
                "Cin7 source size : "
                + Ansi.DARK_YELLOW + cinReader.getContents().size()
                + Ansi.CYAN + " into "
                + Ansi.DARK_YELLOW + matcher.getCinSource().size()
                + Ansi.MAGENTA + " reference groups"

        );
        M.info(
                "Xero source size : "
                + Ansi.DARK_YELLOW + xeroReader.getContents().size()
                + Ansi.CYAN + " into "
                + Ansi.DARK_YELLOW + matcher.getXeroSource().size()
                + Ansi.MAGENTA + " reference groups"
        );
        M.br();

        M.info(
                "Matches found : "
                        + Ansi.DARK_YELLOW +  matcher.getSalesMatch().size()
                        + Ansi.GREEN + " (sales match)" + Ansi.CYAN + " + "
                        + Ansi.DARK_YELLOW + matcher.getSalesMatchDiscrepant().size()
                        + Ansi.RED + " (sales mismatch)"
                        + Ansi.WHITE + " (" + (matcher.getSalesMatch().size() + matcher.getSalesMatchDiscrepant().size()) + " total)"
        );
        M.br();

        M.info(
                "Cin7 without match : "
                + Ansi.DARK_YELLOW +  writer.getCinSinglesWriteCount()
                + Ansi.CYAN + " or "
                + Ansi.DARK_YELLOW + matcher.getCinSingles().size()
                + Ansi.MAGENTA + " reference groups"
        );
        M.info(
                "Xero without match : "
                + Ansi.DARK_YELLOW +  writer.getXeroSinglesWriteCount()
                + Ansi.CYAN + " or "
                + Ansi.DARK_YELLOW + matcher.getXeroSingles().size()
                + Ansi.MAGENTA + " reference groups"
        );
        M.br();

//        M.info("# of Cin7 left without match (UNGROUPED): " + Ansi.DARK_YELLOW + writer.getCinSinglesWriteCount());
//        M.info("# of Xero left without match (UNGROUPED): " + Ansi.DARK_YELLOW + writer.getXeroSinglesWriteCount());

        M.info("Results can be found in the " + Ansi.DARK_YELLOW + "./results/Cin7 & Xero/" + Ansi.CYAN + " folder.");
        M.br();
        //</editor-fold>
    }

    public static void compareXeroWithSalesOrder(BufferedReader uReader) {
        //<editor-fold desc="Files Detection">
        File directory = new File("sources\\");

        File[] files = directory.listFiles(file -> file.isFile());
        M.info("Source files detected:");
        for(int i = 0; i < files.length; i++) {
            System.out.println(Ansi.MAGENTA + "[" + (i+1) + "] " + Ansi.RESET + files[i].getName());
        }
        //</editor-fold>

        XeroGBRReader xeroReader;
        SalesOrderReader soReader;

        //<editor-fold desc="Read Source Files">
        // Read Xero Source
        while(true) {
            M.input("Specify " + Ansi.RED + "Xero Singles" + Ansi.YELLOW + " source file!");

            String xeroSource = "";
            try {
                xeroSource = "sources\\" + files[Integer.parseInt(uReader.readLine())-1].getName();
                M.br();
            }
            catch(IOException iox) {
                M.error(iox, "Something has gone very wrong whilst attempting to read user input.");
            }

            try {
                M.info("Reading file \"" + xeroSource + "\"...");

                xeroReader = new XeroGBRReader(xeroSource);
                xeroReader.readFile();
                xeroReader.processResults();

                M.info("DONE!");
                M.br();

                break;
            }
            catch(IOException ignored) {
                M.warning("File reading failed!");
                M.info("Make sure the file name is typed correctly, case sensitive.");
                M.info("Try again!");
                M.br();
                continue;
            }
        }

        // Read SalesOrder Source
        while(true) {
            M.input("Specify " + Ansi.RED + "SalesOrder" + Ansi.YELLOW + " source file!");

            String soSource = "";
            try {
                soSource = "sources\\" + files[Integer.parseInt(uReader.readLine())-1].getName();
                M.br();
            }
            catch(IOException iox) {
                M.error(iox, "Something has gone very wrong whilst attempting to read user input.");
            }

            try {
                M.info("Reading file \"" + soSource + "\"...");

                soReader = new SalesOrderReader(soSource);
                soReader.readFile();
                soReader.processResults();

                M.info("DONE!");
                M.br();

                break;
            }
            catch(IOException e1) {
                M.warning("File reading failed!");
                M.info("Make sure the file name is typed correctly, case sensitive.");
                M.info("Try again!");
                M.br();
                continue;
            }
        }
        //</editor-fold>

        //<editor-fold desc="Matching">
        Matcher_Xero_SalesOrder matcher = new Matcher_Xero_SalesOrder(xeroReader.getContents(), soReader.getContents());
        matcher.processResults();
        //</editor-fold>

        //<editor-fold desc="Writing">
        M.info("Writing results...");

        // Instantiate writer.
        MatchWriter_Xero_SalesOrder writer = new MatchWriter_Xero_SalesOrder();

        // Matched data.
        writer.setMatchedData(matcher.getSalesMatch());
        writer.setMatchedDataIncorrect(matcher.getSalesMatchDiscrepant());

        // Singles data.
        writer.setXeroSinglesData(matcher.getXeroSingles());
        writer.setSoSinglesData(matcher.getSoSingles());

        // Attempt to write.
        while(true) {
            try {
                writer.writeMatches("results\\Xero & SalesOrder\\matches.csv");

                writer.writeGroupedXeroSingles("results\\Xero & SalesOrder\\xero_singles_singles.csv");
//                writer.writeSalesOrderSingles("results\\Xero & SalesOrder\\salesOrder_singles.csv");

                break;
            }
            catch(IOException iox) {
                M.error(iox, "Failed to write to files. Please close all result files, then try again.");
            }
        }

        M.info("DONE!");
        M.br();

        M.info("Xero-Singles data size: " + Ansi.DARK_YELLOW + xeroReader.getContents().size());
        M.info("SalesOrder data size: " + Ansi.DARK_YELLOW + soReader.getContents().size());
        M.br();

        M.info(
                "Matches found: "
                        + Ansi.DARK_YELLOW +  matcher.getSalesMatch().size()
                        + Ansi.GREEN + " (matching sales)" + Ansi.CYAN + " + "
                        + Ansi.DARK_YELLOW + matcher.getSalesMatchDiscrepant().size()
                        + Ansi.RED + " (mismatched sales)"
                        + Ansi.WHITE + " (" + (matcher.getSalesMatch().size() + matcher.getSalesMatchDiscrepant().size()) + " total)"
        );
        M.br();

        M.info("Xero-Singles without match: " + Ansi.DARK_YELLOW +  matcher.getXeroSingles().size());
//        MH.info("# of SalesOrder left without match: " + Ansi.DARK_YELLOW +  matcher.getSoSingles().size());
        M.br();

        M.info("Results can be found in the " + Ansi.DARK_YELLOW + "./results/Xero & SalesOrder/" + Ansi.CYAN + " folder.");
        M.br();
        //</editor-fold>
    }
}