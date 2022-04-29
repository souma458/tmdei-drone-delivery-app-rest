const { Schema, model } = require("mongoose");

const TagSchema = new Schema({
  tag: { type: String, required: true },
});

const Tag = model("Tag", TagSchema);

module.exports = { Tag };
