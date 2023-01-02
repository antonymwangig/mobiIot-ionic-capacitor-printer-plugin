export interface MobiPrintPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  printReceipt(options: { value: string }): Promise<{ value: string }>;
}
