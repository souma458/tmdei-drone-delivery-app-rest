import { PackageRepository } from "../repository/repository.js";

export class PackageService {
  constructor() {
    this.repository = new PackageRepository();
  }

  async createPackage(packageToDeliver) {
    return await this.repository.save(packageToDeliver);
  }
}
