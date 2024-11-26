package main.data.matches;

import main.data.cin7.Cin7GBR;
import main.data.interfaces.CSV;
import main.data.xero.XeroGBR;

public class MatchGBR implements CSV {
    private static String header = Cin7GBR.getHeader() + "||" + XeroGBR.getHeader();

    private Cin7GBR cin;
    private XeroGBR xero;

    public MatchGBR() {}
    public MatchGBR(Cin7GBR cin, XeroGBR xero) {
        this.cin = cin;
        this.xero = xero;
    }

    public String buildCSVLine() {
        return(cin.buildCSVLine() + "||" + xero.buildCSVLine());
    }

    //<editor-fold desc="Getters & Setters">
    public static String getHeader() {
        return header;
    }
    public static void setHeader(String header) {
        MatchGBR.header = header;
    }

    public Cin7GBR getCin() {
        return this.cin;
    }
    public void setCin(Cin7GBR cin) {
        this.cin = cin;
    }

    public XeroGBR getXero() {
        return this.xero;
    }
    public void setXero(XeroGBR xero) {
        this.xero = xero;
    }
    //</editor-fold>
}
