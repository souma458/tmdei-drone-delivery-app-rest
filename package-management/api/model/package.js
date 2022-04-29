const { Schema, model } = require("mongoose");

const PackageSchema = new Schema({
  weight: { type: Number, required: true },
  height: { type: Number, required: true },
  width: { type: Number, required: true },
  delivery: { type: String, required: true },
});

const Package = model("Package", PackageSchema);

module.exports = { Package };
