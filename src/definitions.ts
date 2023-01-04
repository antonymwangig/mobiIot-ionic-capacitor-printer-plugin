export interface MobiPrintPlugin {
  printReceipt(options: { value: string }): Promise<{ value: string }>;
}
