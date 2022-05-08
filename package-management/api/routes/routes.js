import { Router } from "express";
import { PackageController } from "../controller/controller.js";

export default () => {
  const controller = new PackageController();
  const app = Router();

  app.post("/package", (req, res) => {
    return controller.createPackage(req, res);
  });

  return app;
};
