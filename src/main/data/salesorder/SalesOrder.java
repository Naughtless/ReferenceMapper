package main.data.salesorder;

import main.data.interfaces.CSV;

import java.util.Objects;

public class SalesOrder implements CSV {
    //<editor-fold desc="Properties">
    private static String header = "Created|Cin7 Status|Stage|Ref|Cust PONo|Total Incl|Inv No|Invoice|Company|Customer|Dispatched|Items|Internal Comments|Progress Notes|Project Name|Total Excl - Local|Branch|Sales Rep|Date Of Surgery|Patient Name";

    private String created;
    private String cinStatus;
    private String stage;
    private String ref;
    private String customerPO;
    private String totalIncl;
    private String invNo;
    private String invoice;
    private String company;
    private String customer;
    private String dispatched;
    private String items;
    private String internalComments;
    private String progressNotes;
    private String projectName;
    private String totalExcl;
    private String branch;
    private String salesRep;
    private String dateOfSurgery;
    private String patientName;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public SalesOrder() {}

    public SalesOrder(String created, String cinStatus, String stage, String ref, String customerPO, String totalIncl, String invNo, String invoice, String company, String customer, String dispatched, String items, String internalComments, String progressNotes, String projectName, String totalExcl, String branch, String salesRep, String dateOfSurgery, String patientName) {
        this.created = created;
        this.cinStatus = cinStatus;
        this.stage = stage;
        this.ref = ref;
        this.customerPO = customerPO;
        this.totalIncl = totalIncl;
        this.invNo = invNo;
        this.invoice = invoice;
        this.company = company;
        this.customer = customer;
        this.dispatched = dispatched;
        this.items = items;
        this.internalComments = internalComments;
        this.progressNotes = progressNotes;
        this.projectName = projectName;
        this.totalExcl = totalExcl;
        this.branch = branch;
        this.salesRep = salesRep;
        this.dateOfSurgery = dateOfSurgery;
        this.patientName = patientName;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    @Override
    public String buildCSVLine() {
        StringBuilder sb = new StringBuilder();

        sb.append(created).append("|");
        sb.append(cinStatus).append("|");
        sb.append(stage).append("|");
        sb.append(ref).append("|");
        sb.append(customerPO).append("|");
        sb.append(totalIncl).append("|");
        sb.append(invNo).append("|");
        sb.append(invoice).append("|");
        sb.append(company).append("|");
        sb.append(customer).append("|");
        sb.append(dispatched).append("|");
        sb.append(items).append("|");
        sb.append(internalComments).append("|");
        sb.append(progressNotes).append("|");
        sb.append(projectName).append("|");
        sb.append(totalExcl).append("|");
        sb.append(branch).append("|");
        sb.append(salesRep).append("|");
        sb.append(dateOfSurgery).append("|");
        sb.append(patientName);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrder that = (SalesOrder) o;
        return Objects.equals(created, that.created) && Objects.equals(cinStatus, that.cinStatus) && Objects.equals(stage, that.stage) && Objects.equals(ref, that.ref) && Objects.equals(customerPO, that.customerPO) && Objects.equals(totalIncl, that.totalIncl) && Objects.equals(invNo, that.invNo) && Objects.equals(invoice, that.invoice) && Objects.equals(company, that.company) && Objects.equals(customer, that.customer) && Objects.equals(dispatched, that.dispatched) && Objects.equals(items, that.items) && Objects.equals(internalComments, that.internalComments) && Objects.equals(progressNotes, that.progressNotes) && Objects.equals(projectName, that.projectName) && Objects.equals(totalExcl, that.totalExcl) && Objects.equals(branch, that.branch) && Objects.equals(salesRep, that.salesRep) && Objects.equals(dateOfSurgery, that.dateOfSurgery) && Objects.equals(patientName, that.patientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, cinStatus, stage, ref, customerPO, totalIncl, invNo, invoice, company, customer, dispatched, items, internalComments, progressNotes, projectName, totalExcl, branch, salesRep, dateOfSurgery, patientName);
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public static String getHeader() {
        return header;
    }

    public static void setHeader(String header) {
        SalesOrder.header = header;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCinStatus() {
        return cinStatus;
    }

    public void setCinStatus(String cinStatus) {
        this.cinStatus = cinStatus;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCustomerPO() {
        return customerPO;
    }

    public void setCustomerPO(String customerPO) {
        this.customerPO = customerPO;
    }

    public String getTotalIncl() {
        return totalIncl;
    }

    public void setTotalIncl(String totalIncl) {
        this.totalIncl = totalIncl;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDispatched() {
        return dispatched;
    }

    public void setDispatched(String dispatched) {
        this.dispatched = dispatched;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public String getProgressNotes() {
        return progressNotes;
    }

    public void setProgressNotes(String progressNotes) {
        this.progressNotes = progressNotes;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTotalExcl() {
        return totalExcl;
    }

    public void setTotalExcl(String totalExcl) {
        this.totalExcl = totalExcl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    public String getDateOfSurgery() {
        return dateOfSurgery;
    }

    public void setDateOfSurgery(String dateOfSurgery) {
        this.dateOfSurgery = dateOfSurgery;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    //</editor-fold>
}
