const { Schema, model } = require("mongoose");

const DeliverySchema = new Schema({
  externalRef: { type: String, required: true },
});

const DeliveryRequest = model("DeliveryRequest", DeliverySchema);

module.exports = { DeliveryRequest };
