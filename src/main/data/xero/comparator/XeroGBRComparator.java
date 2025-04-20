package main.data.xero.comparator;

import main.data.xero.XeroGBR;

import java.util.Comparator;

public class XeroGBRComparator implements Comparator<XeroGBR> {
    @Override
    public int compare(XeroGBR r1, XeroGBR r2) {
        return r1.getReference().compareTo(r2.getReference());
    }
}
