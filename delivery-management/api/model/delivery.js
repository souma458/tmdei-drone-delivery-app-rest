const { Schema, model } = require("mongoose");
var Location = require("./location.js");

const DeliverySchema = new Schema({
  expedited: { type: Boolean, required: true, default: false },
  pickup: { type: Location, required: true },
  dropOff: { type: Location, required: true },
  drone: { type: String, required: true },
  account: { type: String, required: true },
  status: { type: string, enum: DeliveryStatus, required: true },
});

const Delivery = model("Delivery", DeliverySchema);

module.exports = { Delivery };
