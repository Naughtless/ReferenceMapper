package main.data.matches;

import main.data.interfaces.CSV;
import main.data.salesorder.SalesOrder;
import main.data.xero.XeroGBR;

public class MatchXSO implements CSV {
    private static String header = XeroGBR.getHeader() + "||" + SalesOrder.getHeader();

    private XeroGBR xero;
    private SalesOrder so;

    public MatchXSO() {}
    public MatchXSO(XeroGBR xero, SalesOrder so) {
        this.xero = xero;
        this.so = so;
    }

    public String buildCSVLine() {
        return xero.buildCSVLine() + "||" + so.buildCSVLine();
    }

    //<editor-fold desc="Getters & Setters">
    public static String getHeader() {
        return header;
    }
    public static void setHeader(String header) {
        MatchXSO.header = header;
    }

    public XeroGBR getXero() {
        return xero;
    }
    public void setXero(XeroGBR xero) {
        this.xero = xero;
    }

    public SalesOrder getSo() {
        return so;
    }
    public void setSo(SalesOrder so) {
        this.so = so;
    }
    //</editor-fold>
}
