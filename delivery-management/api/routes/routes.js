import { Router } from "express";
import { DeliveryController } from "../controller/controller.js";

export default () => {
  const controller = new DeliveryController();
  const app = Router();

  app.post("/delivery", (req, res) => {
    return controller.createDelivery(req, res);
  });

  app.patch("/delivery/:deliveryId", (req, res) => {
    return controller.partiallyUpdateDelivery(req, res);
  });

  app.put("/delivery/:drone/pickup", (req, res) => {
    return controller.readyDelivery(req, res);
  });

  return app;
};
