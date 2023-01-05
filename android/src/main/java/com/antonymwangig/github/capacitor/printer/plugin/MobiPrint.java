package com.antonymwangig.github.capacitor.printer.plugin;
import android.os.StrictMode;
import android.util.Log;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Locale;


import com.google.zxing.BarcodeFormat;
import com.mobiwire.CSAndroidGoLib.CsPrinter;
import com.mobiwire.CSAndroidGoLib.AndroidGoCSApi;


public class MobiPrint {

     public String printReceipt(String value,Context context) {

        new AndroidGoCSApi(context);
   
   
         CsPrinter printer=new CsPrinter();
     

    try {
              
     


        JSONObject receipt_obj = new JSONObject(value);

        StringBuilder companyInfo = new StringBuilder();
        companyInfo.append("\n"+receipt_obj.getString("company")+"\n");
        companyInfo.append("\n"+receipt_obj.getString("address")+"\n");
        companyInfo.append(receipt_obj.getString("email")+"\n".toUpperCase(Locale.ROOT));
        companyInfo.append(receipt_obj.getString("contact")+"\n");
        companyInfo.append(receipt_obj.getString("other_info")+"\n");
        String line = "--------------------------------";
        printer.printText_FullParm(companyInfo.toString(), 0, 0, 3, 1, true, false);
        printer.printText(line);



        StringBuilder item_headers = new StringBuilder();
        item_headers.append("ITEM        QTY   PRICE   AMOUNT");
        item_headers.append("\n--------------------------------" + "\n");
        printer.printText(item_headers.toString());

        StringBuilder items_str = new StringBuilder();
        for (int i = 0; i < receipt_obj.getJSONArray("items").length(); i++) {
            JSONObject itemObj = receipt_obj.getJSONArray("items").getJSONObject(i);
            items_str.append(formatBrandNameForPrint(itemObj.getString("name")) +formatQuantityForPrint(itemObj.getString("quantity")) + formatPriceForPrint(String.valueOf(itemObj.getString("price"))) + formatPriceForPrint(String.valueOf(itemObj.getString("amount"))) + "\n");
        }
        printer.printText(items_str.toString());


        StringBuilder total_string = new StringBuilder();
        total_string.append("--------------------------------\n");
        total_string.append("TOTAL ITEMS " + Integer.toString(receipt_obj.getInt("total_items")));

        total_string.append("\n--------------------------------\n");

        total_string.append(MessageFormat.format("SUB TOTAL              {0}\n", receipt_obj.getString("sub_total")));
        total_string.append(MessageFormat.format("VAT({0})               {1}\n",receipt_obj.getString("tax_perc"), receipt_obj.getString("vat")));
        total_string.append(MessageFormat.format("TOTAL                  {0}\n", receipt_obj.getString("total")));
        printer.printText(total_string.toString());


        StringBuilder payments_string = new StringBuilder();
        payments_string.append("\n---------PAYMENT DETAILS--------\n");
        for (int j = 0; j < receipt_obj.getJSONArray("payments").length(); j++) {
            JSONObject jsonObject = receipt_obj.getJSONArray("payments").getJSONObject(j);
            payments_string.append(MessageFormat.format("{0}{1} {2}\n", formatPaymentMethodForPrint(jsonObject.getString("name").toUpperCase()), jsonObject.getString("amount"),jsonObject.getString("currency")));
        }
        payments_string.append(line);
        printer.printText(payments_string.toString());
      
        printer.addBarQrCodeToPrint(receipt_obj.getString("qrcode_link"), BarcodeFormat.QR_CODE, 200, 200);
        printer.printText_font("CASHIER: "+receipt_obj.getString("cashier").toUpperCase(Locale.ROOT)+"\n",10);
        printer.printText_font("DATETIME: "+receipt_obj.getString("datetime").toUpperCase(Locale.ROOT)+"\n",10);


    }catch (Exception e){}



        printer.print(context);




        return value;
    }





     public static String formatBrandNameForPrint(String name)
     {
         char[] name_array=name.toCharArray();
         StringBuilder builder=new StringBuilder();
         if (name.length()<=11)
         {
             builder.append(name);
             for (int i = 0; i <= (11-name.length()); i++) {
                 builder.append(" ");
             }
         }else {
             builder.append(name.substring(0,10)).append(" ");
         }

         return builder.toString();

     }
     public static String formatQuantityForPrint(String name)
     {
         char[] name_array=name.toCharArray();
         StringBuilder builder=new StringBuilder();
         if (name.length()<=6)
         {
             builder.append(name);
             for (int i = 0; i < 6-name_array.length; i++) {
                 builder.append(" ");
             }
         }
         else
         {
             builder.append(name.substring(0,7));
         }
         return builder.toString();

     }
     public static String formatPriceForPrint(String name)
     {
         char[] name_array=name.toCharArray();
         StringBuilder builder=new StringBuilder();
         if (name.length()<=6)
         {
             builder.append(name);
             for (int i = 0; i <= 7-name_array.length; i++) {
                 builder.append(" ");
             }
         }
         else
         {
             builder.append(name.substring(0,7));
         }
         return builder.toString();

     }

     public static String formatPaymentMethodForPrint(String name)
     {
         char[] name_array=name.toCharArray();
         StringBuilder builder=new StringBuilder();
         if (name.length()<=19)
         {
             builder.append(name);
             for (int i = 0; i < (19-name.length()); i++) {
                 builder.append(" ");
             }
         }else {
             builder.append(name.substring(0,18)).append(" ");
         }

         return builder.toString();

     }
}
