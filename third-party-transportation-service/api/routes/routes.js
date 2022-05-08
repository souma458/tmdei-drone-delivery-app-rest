import { Router } from "express";
import { TransportationRequestController } from "../controller/controller.js";

export default () => {
  const controller = new TransportationRequestController();
  const app = Router();

  app.post("/transportation-request", (req, res) => {
    return controller.createTransportationRequest(req, res);
  });

  return app;
};
