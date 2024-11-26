package main.file.matcher;

import main.data.salesorder.SalesOrder;
import main.data.salesorder.comparator.SalesOrderComparator;
import main.data.xero.XeroGBR;
import main.data.xero.comparator.XeroGBRComparator;
import main.data.matches.MatchXSO;

import java.util.ArrayList;

public class Matcher_Xero_SalesOrder {
    //<editor-fold desc="Properties">
    private ArrayList<XeroGBR> xeroSource;
    private ArrayList<SalesOrder> soSource;

    private ArrayList<MatchXSO> salesMatch;
    private ArrayList<MatchXSO> salesMatchDiscrepant;

    private ArrayList<XeroGBR> xeroSingles;
    private ArrayList<SalesOrder> soSingles;

    // Just to find SalesOrder singles.
    private ArrayList<SalesOrder> soMatches;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Matcher_Xero_SalesOrder() {}

    public Matcher_Xero_SalesOrder(ArrayList<XeroGBR> xeroSource, ArrayList<SalesOrder> soSource) {
        this.xeroSource = xeroSource;
        this.soSource = soSource;

        this.xeroSource.sort(new XeroGBRComparator());
        this.soSource.sort(new SalesOrderComparator());

        salesMatch = new ArrayList<>();
        salesMatchDiscrepant = new ArrayList<>();

        xeroSingles = new ArrayList<>();
        soSingles = new ArrayList<>();

        soMatches = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void processResults() {
        // Populate Matches.
        for(int i = 0; i < xeroSource.size(); ++i) {
            String currentReference = xeroSource.get(i).getReference();

            if(currentReference.contains("Purchase order: ")) {
                currentReference = currentReference.replaceAll("Purchase order: ", "");
                currentReference = currentReference.trim();
            }

            int soSearchResult = binarySearchSalesOrder(soSource, currentReference);

            // If found a matching reference.
            if(soSearchResult != -1) {
                // Instantiate new XeroSalesOrder (XSO) object.
                MatchXSO newMatch = new MatchXSO(xeroSource.get(i), soSource.get(soSearchResult));

                // Populate the 'differentiator' array, so we can find the SalesOrder singles.
                soMatches.add(soSource.get(soSearchResult));

                // Check sales number match.
                double xeroSales = Double.parseDouble(xeroSource.get(i).getBal());
                double soSales = Double.parseDouble(soSource.get(soSearchResult).getTotalExcl());

                // If sales numbers match.
                if(xeroSales == soSales) {
                    salesMatch.add(newMatch);
                }

                // If sales numbers did not match.
                else {
                    salesMatchDiscrepant.add(newMatch);
                }
            }

            // If matching reference not found.
            else {
                xeroSingles.add(xeroSource.get(i));
            }
        }

        // Populate SalesOrder Singles (couldn't be done simultaneously unfortunately).
        for(SalesOrder x: soSource) {
            if(!soMatches.contains(x)) {
                soSingles.add(x);
            }
        }
    }

    public int binarySearchSalesOrder(ArrayList<SalesOrder> source, String targetReference) {
        int result = -1;

        int lowIndex = 0;
        int highIndex = source.size() - 1;
        int midIndex;

        while (lowIndex <= highIndex) {
            midIndex = lowIndex + ((highIndex - lowIndex) / 2);

            String reference = source.get(midIndex).getCustomerPO();

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
    public ArrayList<XeroGBR> getXeroSource() {
        return xeroSource;
    }

    public void setXeroSource(ArrayList<XeroGBR> xeroSource) {
        this.xeroSource = xeroSource;
    }

    public ArrayList<SalesOrder> getSoSource() {
        return soSource;
    }

    public void setSoSource(ArrayList<SalesOrder> soSource) {
        this.soSource = soSource;
    }

    public ArrayList<MatchXSO> getSalesMatch() {
        return salesMatch;
    }

    public void setSalesMatch(ArrayList<MatchXSO> salesMatch) {
        this.salesMatch = salesMatch;
    }

    public ArrayList<MatchXSO> getSalesMatchDiscrepant() {
        return salesMatchDiscrepant;
    }

    public void setSalesMatchDiscrepant(ArrayList<MatchXSO> salesMatchDiscrepant) {
        this.salesMatchDiscrepant = salesMatchDiscrepant;
    }

    public ArrayList<XeroGBR> getXeroSingles() {
        return xeroSingles;
    }

    public void setXeroSingles(ArrayList<XeroGBR> xeroSingles) {
        this.xeroSingles = xeroSingles;
    }

    public ArrayList<SalesOrder> getSoSingles() {
        return soSingles;
    }

    public void setSoSingles(ArrayList<SalesOrder> soSingles) {
        this.soSingles = soSingles;
    }

    public ArrayList<SalesOrder> getSoMatches() {
        return soMatches;
    }

    public void setSoMatches(ArrayList<SalesOrder> soMatches) {
        this.soMatches = soMatches;
    }
    //</editor-fold>
}
