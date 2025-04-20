package main.data.cin7;

import main.data.interfaces.CSV;

import java.util.ArrayList;
import java.util.Objects;

public class Cin7GBR implements CSV {
    //<editor-fold desc="Properties">
    private static String header = "Date|Customer|CustomerPO|OrderRef|InvoiceDate|TOTAL Sales|TOTAL Gross Profit";

    private ArrayList<Cin7> members;

    private String date;
    private String customer;
    private String customerPO;
    private String orderRef;
    private String invoiceDate;

    private String sales;
    private String grossProfit;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Cin7GBR() {}

    public Cin7GBR(
            String date,
            String customer,
            String customerPO,
            String orderRef,
            String invoiceDate
    ) {
        this.date = date;
        this.customer = customer;
        this.customerPO = customerPO;
        this.orderRef = orderRef;
        this.invoiceDate = invoiceDate;

        this.members = new ArrayList<>();
    }

    public Cin7GBR(
            String date,
            String customer,
            String customerPO,
            String orderRef,
            String invoiceDate,
            String sales,
            String grossProfit
    ) {
        this(date, customer, customerPO, orderRef, invoiceDate);
        this.sales = sales;
        this.grossProfit = grossProfit;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public void calculate() {
        double totalSales = 0;
        double totalGrossProfit = 0;

        for(Cin7 currentMember: members) {
            totalSales += Double.parseDouble(currentMember.getSales().replace(",", ""));
            totalGrossProfit += Double.parseDouble(currentMember.getGrossProfit().replace(",", ""));
        }

        this.sales = String.valueOf(totalSales);
        this.grossProfit = String.valueOf(totalGrossProfit);
    }

    public String buildCSVLine() {
        StringBuilder sb = new StringBuilder();

        sb.append(date).append("|");
        sb.append(customer).append("|");
        sb.append(customerPO).append("|");
        sb.append(orderRef).append("|");
        sb.append(invoiceDate).append("|");
        sb.append(sales).append("|");
        sb.append(grossProfit);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cin7GBR cin7_GBR = (Cin7GBR) o;
        return Objects.equals(date, cin7_GBR.date) &&
                Objects.equals(customer, cin7_GBR.customer) &&
                Objects.equals(customerPO, cin7_GBR.customerPO) &&
                Objects.equals(orderRef, cin7_GBR.orderRef) &&
                Objects.equals(invoiceDate, cin7_GBR.invoiceDate) &&
                Objects.equals(sales, cin7_GBR.sales) &&
                Objects.equals(grossProfit, cin7_GBR.grossProfit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, customer, customerPO, orderRef, invoiceDate, sales, grossProfit);
    }

    @Override
    public String toString() {
        return "Date: " + date
                + "\nCustomer: " + customer
                + "\nCustomer PO: " + customerPO
                + "\nOrder Ref: " + orderRef
                + "\nInvoice Date: " + invoiceDate
                + "\nSales: " + sales
                + "\nGross Profit: " + grossProfit;
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public static String getHeader() {
        return header;
    }

    public static void setHeader(String header) {
        Cin7GBR.header = header;
    }

    public ArrayList<Cin7> getMembers() {
        return this.members;
    }

    public void setMembers(ArrayList<Cin7> members) {
        this.members = members;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerPO() {
        return customerPO;
    }

    public void setCustomerPO(String customerPO) {
        this.customerPO = customerPO;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(String grossProfit) {
        this.grossProfit = grossProfit;
    }
    //</editor-fold>
}
