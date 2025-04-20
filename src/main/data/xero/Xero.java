package main.data.xero;

import main.data.interfaces.CSV;

import java.util.Objects;

public class Xero implements CSV {
    //<editor-fold desc="Properties">
    private static String header = "Type|Date|Source|Description|Reference|Currency|Debit (Source)|Credit (Source)|Debit (AUD)|Credit (AUD)|Running Balance (AUD)";

    private String type;

    private String date;
    private String source;
    private String description;
    private String reference;
    private String currency;
    private String debitSource;
    private String creditSource;
    private String debit;
    private String credit;
    private String runningBalance;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Xero() {}

    public Xero(
            String type,
            String date,
            String source,
            String description,
            String reference,
            String currency,
            String debitSource,
            String creditSource,
            String debit,
            String credit,
            String runningBalance
    ) {
        this.type = type;
        this.date = date;
        this.source = source;
        this.description = description;
        this.reference = reference;
        this.currency = currency;
        this.debitSource = debitSource;
        this.creditSource = creditSource;
        this.debit = debit;
        this.credit = credit;
        this.runningBalance = runningBalance;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public String buildCSVLine() {
        StringBuilder sb = new StringBuilder();

        sb.append(type).append("|");
        sb.append(date).append("|");
        sb.append(source).append("|");
        sb.append(description).append("|");
        sb.append(reference).append("|");
        sb.append(currency).append("|");
        sb.append(debitSource).append("|");
        sb.append(creditSource).append("|");
        sb.append(debit).append("|");
        sb.append(credit).append("|");
        sb.append(runningBalance);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xero xero = (Xero) o;
        return Objects.equals(type, xero.type) &&
                Objects.equals(date, xero.date) &&
                Objects.equals(source, xero.source) &&
                Objects.equals(description, xero.description) &&
                Objects.equals(reference, xero.reference) &&
                Objects.equals(currency, xero.currency) &&
                Objects.equals(debitSource, xero.debitSource) &&
                Objects.equals(creditSource, xero.creditSource) &&
                Objects.equals(debit, xero.debit) &&
                Objects.equals(credit, xero.credit) &&
                Objects.equals(runningBalance, xero.runningBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, source, description, reference, currency, debitSource, creditSource,
                debit, credit, runningBalance);
    }

    @Override
    public String toString() {
        return(
                "Type: " + type
                +"\nDate: " + date
                +"\nSource: " + source
                +"\nDescription: " + description
                +"\nReference: " + reference    // INDEX 3
                +"\nCurrency: " + currency
                +"\nDebit Source: " + debitSource
                +"\nCredit Source: " + creditSource
                +"\nDebit: " + debit
                +"\nCredit: " + credit
                +"\nRunning Balance: " + runningBalance
                );
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public static String getHeader() {
        return header;
    }
    public static void setHeader(String header) {
        Xero.header = header;
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

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
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

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDebitSource() {
        return debitSource;
    }
    public void setDebitSource(String debitSource) {
        this.debitSource = debitSource;
    }

    public String getCreditSource() {
        return creditSource;
    }
    public void setCreditSource(String creditSource) {
        this.creditSource = creditSource;
    }

    public String getDebit() {
        return debit;
    }
    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }
    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getRunningBalance() {
        return runningBalance;
    }
    public void setRunningBalance(String runningBalance) {
        this.runningBalance = runningBalance;
    }
    //</editor-fold>
}
