package main.data.cin7.comparator;

import main.data.cin7.Cin7GBR;

import java.util.Comparator;

public class Cin7GBRComparator implements Comparator<Cin7GBR> {
    @Override
    public int compare(Cin7GBR r1, Cin7GBR r2) {
        return r1.getCustomerPO().compareTo(r2.getCustomerPO());
    }
}
