export class DeliveryResponseDTO {
  constructor(delivery) {
    this.username = delivery.account;
    this.deliveryId = delivery._id;
    this.pickupCoordinates = delivery.pickup;
    this.dropOffCoordinates = delivery.dropOff;
    this.created = delivery.created;
    this.status = delivery.status;
    this.expedited = delivery.expedited;
    this.drone = delivery.drone ? delivery.drone : null;
    this.transportationRequest = delivery.transportationRequest
      ? delivery.transportationRequest
      : null;
  }
}
