package main.data.cin7;

import main.data.interfaces.CSV;

import java.util.Objects;

public class Cin7 implements CSV {
    //<editor-fold desc="Properties">
    private static String header = "Date|Customer|CustomerPONo|Code|Product|Brand|Product Category|Manufacturer|Order Ref|Patient|Surgeon|SalesRep|InvoiceDate|InternalComments|Qty|Sales|Gross Profit|GP%|Month|Year";

    private String date; // Important
    private String customer; // Important
    private String customerPO; // Important
    private String code;
    private String product;
    private String brand;
    private String productCategory;
    private String manufacturer;
    private String orderRef; // Important
    private String patient;
    private String surgeon;
    private String salesRep;
    private String invoiceDate; // Important
    private String internalComments;
    private String qty;
    private String sales; // Important
    private String grossProfit; // Important
    private String gp;
    private String month;
    private String year;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Cin7() {}

    public Cin7(
            String date,
            String customer,
            String customerPO,
            String code,
            String product,
            String brand,
            String productCategory,
            String manufacturer,
            String orderRef,
            String patient,
            String surgeon,
            String salesRep,
            String invoiceDate,
            String internalComments,
            String qty,
            String sales,
            String grossProfit,
            String gp,
            String month,
            String year
    ) {
        this.date = date; // 0
        this.customer = customer; // 1
        this.customerPO = customerPO; // 2
        this.code = code; // 3
        this.product = product; // 4
        this.brand = brand; // 5
        this.productCategory = productCategory; // 6
        this.manufacturer = manufacturer; // 7
        this.orderRef = orderRef; // 8
        this.patient = patient; // 9
        this.surgeon = surgeon; // 10
        this.salesRep = salesRep; // 11
        this.invoiceDate = invoiceDate; // 12
        this.internalComments = internalComments; // 13
        this.qty = qty; // 14
        this.sales = sales; // 15
        this.grossProfit = grossProfit; // 16
        this.gp = gp; // 17
        this.month = month; // 18
        this.year = year; // 19
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    public String buildCSVLine() {
        StringBuilder sb = new StringBuilder();

        sb.append(date).append("|");
        sb.append(customer).append("|");
        sb.append(customerPO).append("|");
        sb.append(code).append("|");
        sb.append(product).append("|");
        sb.append(brand).append("|");
        sb.append(productCategory).append("|");
        sb.append(manufacturer).append("|");
        sb.append(orderRef).append("|");
        sb.append(patient).append("|");
        sb.append(surgeon).append("|");
        sb.append(salesRep).append("|");
        sb.append(invoiceDate).append("|");
        sb.append(internalComments).append("|");
        sb.append(qty).append("|");
        sb.append(sales).append("|");
        sb.append(grossProfit).append("|");
        sb.append(gp).append("|");
        sb.append(month).append("|");
        sb.append(year);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cin7 cin7 = (Cin7) o;
        return Objects.equals(date, cin7.date) &&
                Objects.equals(customer, cin7.customer) &&
                Objects.equals(customerPO, cin7.customerPO) &&
                Objects.equals(code, cin7.code) &&
                Objects.equals(product, cin7.product) &&
                Objects.equals(brand, cin7.brand) &&
                Objects.equals(productCategory, cin7.productCategory) &&
                Objects.equals(manufacturer, cin7.manufacturer) &&
                Objects.equals(orderRef, cin7.orderRef) &&
                Objects.equals(patient, cin7.patient) &&
                Objects.equals(surgeon, cin7.surgeon) &&
                Objects.equals(salesRep, cin7.salesRep) &&
                Objects.equals(invoiceDate, cin7.invoiceDate) &&
                Objects.equals(internalComments, cin7.internalComments) &&
                Objects.equals(qty, cin7.qty) &&
                Objects.equals(sales, cin7.sales) &&
                Objects.equals(grossProfit, cin7.grossProfit) &&
                Objects.equals(gp, cin7.gp) &&
                Objects.equals(month, cin7.month) &&
                Objects.equals(year, cin7.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, customer, customerPO, code, product, brand, productCategory,
                manufacturer, orderRef, patient, surgeon, salesRep, invoiceDate,
                internalComments, qty, sales, grossProfit, gp, month, year);
    }

    @Override
    public String toString() {
        return(
                "Date: " + date
                + "\nCustomer: " + customer
                + "\nCustomer PO: " + customerPO
                + "\nCode: " + code
                + "\nProduct: " + product
                + "\nBrand: " + brand
                + "\nProduct Category: " + productCategory
                + "\nManufacturer: " + manufacturer
                + "\nOrder REF: " + orderRef    // INDEX 8
                + "\nPatient: " + patient
                + "\nSurgeon: " + surgeon
                + "\nSales Rep: " + salesRep
                + "\nInvoice Date: " + invoiceDate
                + "\nComments: " + internalComments
                + "\nQty: " + qty
                + "\nSales: " + sales
                + "\nGross Profit: " + grossProfit
                + "\nGP%: " + gp
                + "\nMonth: " + month
                + "\nYear: " + year
                );
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public static String getHeader() {
        return header;
    }
    public static void setHeader(String header) {
        Cin7.header = header;
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

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrderRef() {
        return orderRef;
    }
    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getPatient() {
        return patient;
    }
    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getSurgeon() {
        return surgeon;
    }
    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public String getSalesRep() {
        return salesRep;
    }
    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInternalComments() {
        return internalComments;
    }
    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public String getQty() {
        return qty;
    }
    public void setQty(String qty) {
        this.qty = qty;
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

    public String getGp() {
        return gp;
    }
    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    //</editor-fold>
}
