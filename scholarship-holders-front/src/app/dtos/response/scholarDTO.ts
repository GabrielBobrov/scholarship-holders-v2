export class ScholarDTO {
  constructor(
    public id?: string,
    public fullName?: string,
    public document?: string,
    public documentType?: string,
    public bankCode?: number,
    public bankAgency?: number,
    public accountNumber?: number
  ) {}
}
