import { Router } from "express";
import { DeliveryController } from "../controller/controller.js";

export default () => {
  const controller = new DeliveryController();
  const app = Router();

  app.post("/delivery", (req, res) => {
    return controller.createDelivery(req, res);
  });

  return app;
};
