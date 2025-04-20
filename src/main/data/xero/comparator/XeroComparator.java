package main.data.xero.comparator;

import main.data.xero.Xero;

import java.util.Comparator;

public class XeroComparator implements Comparator<Xero> {
    @Override
    public int compare(Xero r1, Xero r2) {
        return r1.getReference().compareTo(r2.getReference());
    }
}
