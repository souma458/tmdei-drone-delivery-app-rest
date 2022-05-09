import { DeliveryResponseDTO } from "../model/response/deliveryResponseDTO.js";
import { DeliveryRepository } from "../repository/repository.js";
import { DeliveryStatus } from "../model/enums/deliveryStatus.js";

export class DeliveryService {
  constructor() {
    this.repository = new DeliveryRepository();
  }

  async get(deliveryId) {
    const delivery = await this.repository.findById(deliveryId);
    return new DeliveryResponseDTO(delivery);
  }

  async createDelivery(delivery) {
    var deliveryToSave = {
      pickup: delivery.pickupCoordinates,
      dropOff: delivery.dropOffCoordinates,
      account: delivery.username,
    };
    const savedDelivery = await this.repository.save(deliveryToSave);
    return new DeliveryResponseDTO(savedDelivery);
  }

  async partiallyUpdateDelivery(deliveryId, delivery) {
    return await this.repository.update(deliveryId, delivery);
  }

  async readyDelivery(drone) {
    const delivery = await this.repository.findOldestReadyToDeliverByDrone(
      drone
    );
    delivery.drone = drone;
    delivery.status = DeliveryStatus.DELIVERY_STATUS_HEADED_TO_DROP_OFF;
    const updatedDelivery = await this.repository.update(
      delivery._id,
      delivery
    );
    return {
      delivery: updatedDelivery._id,
      pickup: updatedDelivery.pickup,
      dropOff: updatedDelivery.dropOff,
      status: updatedDelivery.status,
    };
  }

  async completeDelivery(delivery) {
    return await this.repository.update(delivery, {
      status: DeliveryStatus.DELIVERY_STATUS_COMPLETED,
    });
  }
}
