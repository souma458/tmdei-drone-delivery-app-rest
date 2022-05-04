import { Package } from "../model/package.js";

export class PackageRepository {
  constructor() {
    this.model = Package;
  }

  async save(packageToDeliver) {
    const packageToSave = new Package(packageToDeliver);
    return await packageToSave.save();
  }
}
