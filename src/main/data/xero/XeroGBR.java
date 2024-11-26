package main.data.xero;

import main.data.interfaces.CSV;

import java.util.ArrayList;
import java.util.Objects;

public class XeroGBR implements CSV {
    //<editor-fold desc="Properties">
    private static String header = "Type|Date|Description|Reference|TOTAL Debit(AUD)|TOTAL Credit(AUD)|Credit-Debit";

    private ArrayList<Xero> members;

    private String type;

    private String date;
    private String description;
    private String reference;

    private String debitAUD;
    private String creditAUD;

    private String bal;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public XeroGBR() {}

    public XeroGBR(String type, String date, String description, String reference) {
        this.type = type;
        this.date = date;
        this.description = description;
        this.reference = reference;

        members = new ArrayList<>();
    }

    public XeroGBR(String type, String date, String description, String reference, String debitAUD, String creditAUD) {
        this(type, date, description, reference);
        this.debitAUD = debitAUD;
        this.creditAUD = creditAUD;
    }

    public XeroGBR(String type, String date, String description, String reference, String debitAUD, String creditAUD, String bal) {
        this(type, date, description, reference, debitAUD, creditAUD);
        this.bal = bal;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void calculate() {
        double totalDebitAUD = 0;
        double totalCreditAUD = 0;

        for(Xero currentMember: members) {
            totalDebitAUD += Double.parseDouble(currentMember.getDebit().replace(",", ""));
            totalCreditAUD += Double.parseDouble(currentMember.getCredit().replace(",", ""));
        }

        this.debitAUD = String.valueOf(totalDebitAUD);
        this.creditAUD = String.valueOf(totalCreditAUD);

        this.bal = String.valueOf(totalCreditAUD - totalDebitAUD);
    }

    public String buildCSVLine() {
        StringBuilder sb = new StringBuilder();

        sb.append(type).append("|");
        sb.append(date).append("|");
        sb.append(description).append("|");
        sb.append(reference).append("|");
        sb.append(debitAUD).append("|");
        sb.append(creditAUD).append("|");
        sb.append(bal);


        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XeroGBR xero_GBR = (XeroGBR) o;
        return Objects.equals(type, xero_GBR.type) &&
                Objects.equals(date, xero_GBR.date) &&
                Objects.equals(description, xero_GBR.description) &&
                Objects.equals(reference, xero_GBR.reference) &&
                Objects.equals(debitAUD, xero_GBR.debitAUD) &&
                Objects.equals(creditAUD, xero_GBR.creditAUD) &&
                Objects.equals(bal, xero_GBR.bal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, description, reference, debitAUD, creditAUD, bal);
    }

    @Override
    public String toString() {
        return "Type: " + type
                + "\nDate: " + date
                + "\nDescription: " + description
                + "\nReference: " + reference
                + "\nDebit AUD: " + debitAUD
                + "\nCredit AUD: " + creditAUD
                + "\nBalance: " + bal;
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public static String getHeader() {
        return header;
    }

    public static void setHeader(String header) {
        XeroGBR.header = header;
    }

    public ArrayList<Xero> getMembers() {
        return this.members;
    }

    public void setMembers(ArrayList<Xero> members) {
        this.members = members;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDebitAUD() {
        return debitAUD;
    }

    public void setDebitAUD(String debitAUD) {
        this.debitAUD = debitAUD;
    }

    public String getCreditAUD() {
        return creditAUD;
    }

    public void setCreditAUD(String creditAUD) {
        this.creditAUD = creditAUD;
    }

    public String getBal() {
        return bal;
    }

    public void setBal(String bal) {
        this.bal = bal;
    }
    //</editor-fold>
}
