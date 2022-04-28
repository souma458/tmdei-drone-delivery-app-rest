const { Schema, model } = require("mongoose");
const { RequestStatus } = require("./enums/requestStatus.js");

const TransportationRequestSchema = new Schema({
  requestDate: { type: Date, required: true },
  status: { type: String, enum: RequestStatus, required: true },
  delivery: { type: Schema.Types.ObjectId, ref: "Delivery", required: true },
});

const TransportationRequest = model(
  "TransporationRequest",
  TransportationRequestSchema
);

module.exports = { TransportationRequest };
