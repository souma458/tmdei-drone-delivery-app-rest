import { DeliveryService } from "../service/service.js";
import { handleError } from "./errorHandler.js";

export class DeliveryController {
  constructor() {
    this.service = new DeliveryService();
  }

  async get(req, res) {
    try {
      const delivery = await this.service.get(req.params.deliveryId);
      res.status(200).send(delivery);
    } catch (err) {
      handleError(res, err);
    }
  }

  async getDeliveries(req, res) {
    try {
      const deliveries = await this.service.getDeliveries(req.params.username);
      res.status(200).send(deliveries);
    } catch (err) {
      handleError(res, err);
    }
  }

  async createDelivery(req, res) {
    try {
      const delivery = await this.service.createDelivery(req.body);
      res.status(201).send(delivery);
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

  async readyDelivery(req, res) {
    try {
      const delivery = await this.service.readyDelivery(req.params.drone);
      res.status(200).send(delivery);
    } catch (err) {
      handleError(res, err);
    }
  }

  async completeDelivery(req, res) {
    try {
      await this.service.completeDelivery(req.params.delivery);
      res.status(204).send();
    } catch (err) {
      handleError(res, err);
    }
  }

  async cancelDelivery(req, res) {
    try {
      await this.service.cancelDelivery(req.params.delivery);
      res.status(204).send();
    } catch (err) {
      handleError(res, err);
    }
  }

  async createDeliveryConfirmation(req, res) {
    try {
      const confirmation = await this.service.createDeliveryConfirmation(
        req.body
      );
      res.status(201).send(confirmation);
    } catch (err) {
      handleError(res, err);
    }
  }

  async confirmDelivery(req, res) {
    try {
      const confirmation = await this.service.createDeliveryConfirmation(
        req.body
      );
      res.status(201).send(confirmation);
    } catch (err) {
      handleError(res, err);
    }
  }
}
