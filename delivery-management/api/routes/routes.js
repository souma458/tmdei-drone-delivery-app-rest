import { Router } from "express";
import { DeliveryController } from "../controller/controller.js";

export default () => {
  const controller = new DeliveryController();
  const app = Router();

  app.post("/delivery", (req, res) => {
    return controller.createDelivery(req, res);
  });

  app.get("/delivery/:deliveryId", (req, res) => {
    return controller.get(req, res);
  });

  app.patch("/delivery/:deliveryId", (req, res) => {
    return controller.partiallyUpdateDelivery(req, res);
  });

  app.put("/delivery/:drone/pickup", (req, res) => {
    return controller.readyDelivery(req, res);
  });

  app.put("/delivery/:delivery/complete", (req, res) => {
    return controller.completeDelivery(req, res);
  });

  app.put("/delivery/:delivery/cancel", (req, res) => {
    return controller.cancelDelivery(req, res);
  });

  app.post("/confirmation", (req, res) => {
    return controller.createDeliveryConfirmation(req, res);
  });

  return app;
};
