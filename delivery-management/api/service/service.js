import { DeliveryRepository } from "../repository/repository.js";

export class DeliveryService {
  constructor() {
    this.repository = new DeliveryRepository();
  }

  async createDelivery(delivery) {
    var deliveryToSave = {
      pickup: delivery.pickupCoordinates,
      dropOff: delivery.dropOffCoordinates,
      account: delivery.username,
    };
    return await this.repository.save(deliveryToSave);
  }

  async partiallyUpdateDelivery(deliveryId, delivery) {
    return await this.repository.update(deliveryId, delivery);
  }
}
