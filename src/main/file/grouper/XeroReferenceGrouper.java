package main.file.grouper;

import main.data.xero.Xero;
import main.data.xero.comparator.XeroComparator;
import main.data.xero.XeroGBR;

import java.util.ArrayList;

public class XeroReferenceGrouper {
    private ArrayList<Xero> sourceData;
    private ArrayList<XeroGBR> groupedData;

    public XeroReferenceGrouper() {}
    public XeroReferenceGrouper(ArrayList<Xero> sourceData) {
        this.sourceData = sourceData;

        this.sourceData.sort(new XeroComparator());
    }

    public void group() {
        groupedData = new ArrayList<>();

        for(int sourceIndex = 0; sourceIndex < sourceData.size(); sourceIndex++) {
            // First we expose the current necessary fields.
            Xero currentData = sourceData.get(sourceIndex);

            String type = currentData.getType();
            String date = currentData.getDate();
            String description = currentData.getDescription();
            String reference = currentData.getReference();

            // For first entry only:
            if(sourceIndex == 0) {
                XeroGBR newData = new XeroGBR(
                        type,
                        date,
                        description,
                        reference
                );
                newData.getMembers().add(currentData);

                groupedData.add(newData);
            }

            // Second entry and onwards.
            else {
                // Previous entry's 'reference'
                String previousReference = sourceData.get(sourceIndex-1).getReference();

                // If 'reference' is equals to previous entry's 'reference':
                // Add it to the previous GBR's members ArrayList.
                if(reference.equals(previousReference)) {
                    groupedData.getLast().getMembers().add(currentData);
                }

                // If 'reference' is different to previous:
                // Create new GBR object.
                else {
                    XeroGBR newData = new XeroGBR(
                            type,
                            date,
                            description,
                            reference
                    );
                    newData.getMembers().add(currentData);

                    groupedData.add(newData);
                }
            }
        }
    }

    public void calculate() {
        for(XeroGBR xero: groupedData) {
            xero.calculate();
        }
    }

    //<editor-fold desc="Getters & Setters">
    public ArrayList<Xero> getSourceData() {
        return sourceData;
    }

    public void setSourceData(ArrayList<Xero> sourceData) {
        this.sourceData = sourceData;
    }

    public ArrayList<XeroGBR> getGroupedData() {
        return groupedData;
    }

    public void setGroupedData(ArrayList<XeroGBR> groupedData) {
        this.groupedData = groupedData;
    }
    //</editor-fold>
}
