package com.antonymwangig.github.capacitor.printer.plugin;


import android.content.Context;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "MobiPrint")
public class MobiPrintPlugin extends Plugin {

    private MobiPrint implementation = new MobiPrint();



    @PluginMethod
    public void printReceipt(PluginCall call) {
        String value = call.getString("value");
        Context context=this.getActivity().getApplicationContext();
        JSObject ret = new JSObject();
        ret.put("value", implementation.printReceipt(value,context));
        call.resolve(ret);
    }
}
