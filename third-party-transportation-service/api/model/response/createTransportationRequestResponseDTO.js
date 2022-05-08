export class CreateTransportationRequestResponseDTO {
  constructor(transportationRequest) {
    this.requestId = transportationRequest._id;
    this.status = transportationRequest.status;
    this.requestDate = transportationRequest.pickup;
  }
}
