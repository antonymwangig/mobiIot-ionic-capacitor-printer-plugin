export interface MobiPrintPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
