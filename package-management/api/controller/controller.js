import { PackageService } from "../service/service.js";
import { CreatePackageResponseDTO } from "../model/response/createPackageResponseDTO.js";
import { handleError } from "./errorHandler.js";

export class PackageController {
  constructor() {
    this.service = new PackageService();
  }

  async createPackage(req, res) {
    try {
      const packageToDeliver = await this.service.createPackage(req.body);
      res.status(201).send(new CreatePackageResponseDTO(packageToDeliver));
    } catch (err) {
      handleError(res, err);
    }
  }
}
