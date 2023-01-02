package com.antonymwangig.github.capacitor.printer.plugin;

import android.util.Log;
import android.content.Context;
import com.mobiwire.CSAndroidGoLib.CsPrinter;
import com.mobiwire.CSAndroidGoLib.AndroidGoCSApi;


public class MobiPrint {

    public String echo(String value) {
        return value;
    }

     public String printReceipt(String value,Context context) {
        new AndroidGoCSApi(context);
        StringBuilder companyInfo = new StringBuilder();
        companyInfo.append("\nMOGENI TEA FACTORY LIMITED\n");
        companyInfo.append("\nP.O.BOX-12-40501,IKONGE,NYAMIRA\n");
        companyInfo.append("info@mogeniteafactory.co.ke\n");
        companyInfo.append("011000096,0110041693\n");
        companyInfo.append("PIN : P051345509A\n");
        String titleStr = "--------------------------------";

        StringBuilder contentSb = new StringBuilder();
        String tab = "\n";
        contentSb.append("TEA BRAND   QTY   PRICE   AMOUNT");
        contentSb.append("\n--------------------------------" + "\n");

        contentSb.append("--------------------------------\n");

        contentSb.append("\n--------------------------------\n");
      
      
        CsPrinter.printText_FullParm(companyInfo.toString(), 0, 0, 3, 1, true, false);

        CsPrinter.printText(contentSb.toString());
   
        CsPrinter.printText("\t");
        CsPrinter.printEndLine();
        return value;
    }
}
