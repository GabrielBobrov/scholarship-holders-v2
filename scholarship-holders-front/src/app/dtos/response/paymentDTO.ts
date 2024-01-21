export class PaymentDTO {
  constructor(
    public id?: string | null,
    public paymentDate?: string,
    public amount?: number
  ) {}
}
