package main.file.grouper;

import main.data.cin7.Cin7;
import main.data.cin7.comparator.Cin7Comparator;
import main.data.cin7.Cin7GBR;

import java.util.ArrayList;

public class Cin7ReferenceGrouper {
    private ArrayList<Cin7> sourceData;
    private ArrayList<Cin7GBR> groupedData;

    public Cin7ReferenceGrouper() {}
    public Cin7ReferenceGrouper(ArrayList<Cin7> sourceData) {
        this.sourceData = sourceData;

        this.sourceData.sort(new Cin7Comparator());
    }

    public void group() {
        groupedData = new ArrayList<>();

        for(int i = 0; i < sourceData.size(); i++) {
            // First we expose the current necessary fields.
            Cin7 currentData = sourceData.get(i);

            String date = currentData.getDate();
            String customer = currentData.getCustomer();
            String customerPO = currentData.getCustomerPO();
            String orderRef = currentData.getOrderRef();
            String invoiceDate = currentData.getInvoiceDate();

            // For first entry only:
            if(i == 0) {
                Cin7GBR newData = new Cin7GBR(
                        date,
                        customer,
                        customerPO,
                        orderRef,
                        invoiceDate
                );
                newData.getMembers().add(currentData);

                groupedData.add(newData);
            }

            // Second entry and onwards.
            else {
                // Previous entry's 'customerPO'
                String previousCustomerPO = sourceData.get(i-1).getCustomerPO();

                // If 'customerPO' is equals to previous entry's 'customerPO':
                // Add it to the previous GBR's members ArrayList.
                if(customerPO.equals(previousCustomerPO)) {
                    groupedData.getLast().getMembers().add(currentData);
                }

                // If 'customerPO' is different to previous:
                // Create new GBR object.
                else {
                    Cin7GBR newData = new Cin7GBR(
                            date,
                            customer,
                            customerPO,
                            orderRef,
                            invoiceDate
                    );
                    newData.getMembers().add(currentData);

                    groupedData.add(newData);
                }

            }

        }
    }

    public void calculate() {
        for(Cin7GBR cin: groupedData) {
            cin.calculate();
        }
    }

    //<editor-fold desc="Getters & Setters">
    public ArrayList<Cin7> getSourceData() {
        return sourceData;
    }

    public void setSourceData(ArrayList<Cin7> sourceData) {
        this.sourceData = sourceData;
    }

    public ArrayList<Cin7GBR> getGroupedData() {
        return groupedData;
    }

    public void setGroupedData(ArrayList<Cin7GBR> groupedData) {
        this.groupedData = groupedData;
    }
    //</editor-fold>
}
