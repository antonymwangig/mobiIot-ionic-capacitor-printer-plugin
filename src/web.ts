import { WebPlugin } from '@capacitor/core';

import type { MobiPrintPlugin } from './definitions';

export class MobiPrintWeb extends WebPlugin implements MobiPrintPlugin {
  async printReceipt(options: { value: string }): Promise<{ value: string }> {
    //    {
    //        "company":"COMPANY X",
    //        "address":"P.O.BOX-XXX-XXXXX,NAKURU",
    //        "email":"XXX-XXXXX@XXX.COM",
    //        "contact":"020-2336234/24732472364",
    //        "other_info":"PIN : XXXXXXXXXX",
    //        "cashier":"XXXXX XXXX",
    //        "total_items":"1",
    //        "sub_total":"340",
    //        "vat":"20",
    //        "total":"360",
    //        "qrcode_link":"http://www.google.com",
    //        "tax_perc":"18%",
    //        "datetime":"10:30 PM JAN 04 2023",
    //        "items":[
    //            {
    //                "name":"item x",
    //                "quantity":"1",
    //                "price":"1000.50",
    //                "amount":"1000.50"
    //             }],
    //         "payments":[
    //             {"name":"CASH","amount":"1000.50","currency":"KSH"}
    //             ]
            
    //         }
    return options;
  }
}
