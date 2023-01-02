import { WebPlugin } from '@capacitor/core';

import type { MobiPrintPlugin } from './definitions';

export class MobiPrintWeb extends WebPlugin implements MobiPrintPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async printReceipt(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
