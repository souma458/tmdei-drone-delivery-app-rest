import { DeliveryService } from "../service/service.js";
import { CreateDeliveryResponseDTO } from "../model/response/createDeliveryResponseDTO.js";
import { handleError } from "./errorHandler.js";

export class DeliveryController {
  constructor() {
    this.service = new DeliveryService();
  }

  async createDelivery(req, res) {
    try {
      const delivery = await this.service.createDelivery(req.body);
      res.status(201).send(new CreateDeliveryResponseDTO(delivery));
    } catch (err) {
      handleError(res, err);
    }
  }

  async partiallyUpdateDelivery(req, res) {
    try {
      await this.service.partiallyUpdateDelivery(
        req.params.deliveryId,
        req.body
      );
      res.status(204).send();
    } catch (err) {
      handleError(res, err);
    }
  }
}
