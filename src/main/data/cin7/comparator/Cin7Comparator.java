package main.data.cin7.comparator;

import main.data.cin7.Cin7;

import java.util.Comparator;

public class Cin7Comparator implements Comparator<Cin7> {
    @Override
    public int compare(Cin7 r1, Cin7 r2) {
        return r1.getCustomerPO().compareTo(r2.getCustomerPO());
    }
}
