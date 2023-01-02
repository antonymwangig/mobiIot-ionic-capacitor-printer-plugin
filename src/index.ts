import { registerPlugin } from '@capacitor/core';

import type { MobiPrintPlugin } from './definitions';

const MobiPrint = registerPlugin<MobiPrintPlugin>('MobiPrint', {
  web: () => import('./web').then(m => new m.MobiPrintWeb()),
});

export * from './definitions';
export { MobiPrint };
