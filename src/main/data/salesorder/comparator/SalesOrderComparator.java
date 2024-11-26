package main.data.salesorder.comparator;

import main.data.salesorder.SalesOrder;

import java.util.Comparator;

public class SalesOrderComparator implements Comparator<SalesOrder> {
    @Override
    public int compare(SalesOrder r1, SalesOrder r2) {
        return(r1.getCustomerPO().compareTo(r2.getCustomerPO()));
    }
}
