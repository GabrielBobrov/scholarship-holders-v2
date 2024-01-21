export class PaymentDTO {
  constructor(
    public id?: string | null,
    public scholarId?: string | null,
    public paymentId?: string | null,
    public paymentDate?: string,
    public amount?: number,
    public status?: string
  ) {}
}
