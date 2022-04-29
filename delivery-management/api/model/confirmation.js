const { Schema, model } = require("mongoose");

const ConfirmationSchema = new Schema({
  signature: { type: String },
  fingerPrint: { type: String },
});

const Confirmation = model("Confirmation", ConfirmationSchema);

module.exports = { Confirmation };
