package main.file.matcher;

import main.data.cin7.Cin7GBR;
import main.data.xero.XeroGBR;
import main.data.cin7.comparator.Cin7GBRComparator;
import main.data.xero.comparator.XeroGBRComparator;
import main.data.matches.MatchGBR;

import java.util.ArrayList;

public class Matcher_Cin7GBR_XeroGBR {
    //<editor-fold desc="Properties">
    private ArrayList<Cin7GBR> cinSource;
    private ArrayList<XeroGBR> xeroSource;

    private ArrayList<MatchGBR> salesMatch;
    private ArrayList<MatchGBR> salesMatchDiscrepant;

    private ArrayList<Cin7GBR> cinSingles;
    private ArrayList<XeroGBR> xeroSingles;

    // Just to find xeroSingles.
    private ArrayList<XeroGBR> xeroMatches;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public Matcher_Cin7GBR_XeroGBR() {}

    public Matcher_Cin7GBR_XeroGBR(ArrayList<Cin7GBR> cinSource, ArrayList<XeroGBR> xeroSource) {
        this.cinSource = cinSource;
        this.xeroSource = xeroSource;

        this.cinSource.sort(new Cin7GBRComparator());
        this.xeroSource.sort(new XeroGBRComparator());

        salesMatch = new ArrayList<>();
        salesMatchDiscrepant = new ArrayList<>();

        cinSingles = new ArrayList<>();
        xeroSingles = new ArrayList<>();

        xeroMatches = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void processResults() {
        // Populate Matches.
        for(int i = 0; i < cinSource.size(); ++i) {
            String currentReference = cinSource.get(i).getCustomerPO();

            if(currentReference.contains("Purchase order: ")) {
                currentReference = currentReference.replaceAll("Purchase order: ", "");
                currentReference = currentReference.trim();
            }

            int xeroSearchResult = binarySearchXeroGBR(xeroSource, currentReference);

            // If found a matching reference.
            if(xeroSearchResult != -1) {
                // Instantiate new GroupByReference object.
                MatchGBR newMatch = new MatchGBR(cinSource.get(i), xeroSource.get(xeroSearchResult));

                // Populate the 'differentiator' array, so we can find the singles.
                xeroMatches.add(xeroSource.get(xeroSearchResult));

                // If sales numbers match.
                if(cinSource.get(i).getSales().equals(xeroSource.get(xeroSearchResult).getBal())) {
                    salesMatch.add(newMatch);
                }

                // If sales numbers did not match.
                else {
                    salesMatchDiscrepant.add(newMatch);
                }
            }

            // If matching reference not found.
            else {
                cinSingles.add(cinSource.get(i));
            }
        }

        // Populate Xero Singles (couldn't be done simultaneously unfortunately).
        for(XeroGBR x: xeroSource) {
            if(!xeroMatches.contains(x)) {
                xeroSingles.add(x);
            }
        }
    }

    public int binarySearchXeroGBR(ArrayList<XeroGBR> source, String targetReference) {
        int result = -1;

        int lowIndex = 0;
        int highIndex = source.size() - 1;
        int midIndex;

        while (lowIndex <= highIndex) {
            midIndex = lowIndex + ((highIndex - lowIndex) / 2);

            String reference = source.get(midIndex).getReference();

            if(reference.contains("Purchase order: ")) {
                reference = reference.replaceAll("Purchase order: ", "");
                reference = reference.trim();
            }

            int strCompareValue = targetReference.compareTo(reference);

            if(strCompareValue < 0) { // Desired result in the LEFT RANGE.
                highIndex = midIndex - 1;
            }
            else if (strCompareValue > 0) { // Desired result in the RIGHT RANGE.
                lowIndex = midIndex + 1;
            }
            else { // FOUND DESIRED RESULT.
                result = midIndex;
                break;
            }
        }

        return result;
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public ArrayList<Cin7GBR> getCinSource() {
        return cinSource;
    }

    public void setCinSource(ArrayList<Cin7GBR> cinSource) {
        this.cinSource = cinSource;
    }

    public ArrayList<XeroGBR> getXeroSource() {
        return xeroSource;
    }

    public void setXeroSource(ArrayList<XeroGBR> xeroSource) {
        this.xeroSource = xeroSource;
    }

    public ArrayList<MatchGBR> getSalesMatch() {
        return salesMatch;
    }

    public void setSalesMatch(ArrayList<MatchGBR> salesMatch) {
        this.salesMatch = salesMatch;
    }

    public ArrayList<MatchGBR> getSalesMatchDiscrepant() {
        return salesMatchDiscrepant;
    }

    public void setSalesMatchDiscrepant(ArrayList<MatchGBR> salesMatchDiscrepant) {
        this.salesMatchDiscrepant = salesMatchDiscrepant;
    }

    public ArrayList<Cin7GBR> getCinSingles() {
        return cinSingles;
    }

    public void setCinSingles(ArrayList<Cin7GBR> cinSingles) {
        this.cinSingles = cinSingles;
    }

    public ArrayList<XeroGBR> getXeroSingles() {
        return xeroSingles;
    }

    public void setXeroSingles(ArrayList<XeroGBR> xeroSingles) {
        this.xeroSingles = xeroSingles;
    }
    //</editor-fold>
}
