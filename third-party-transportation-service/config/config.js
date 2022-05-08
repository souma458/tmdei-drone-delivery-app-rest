if (!process.env.MONGODB_URI) {
  throw new Error("Couldn't find MongoDB connection path");
}

export default {
  appName: "Third Party Transportation Service",
  port: parseInt(process.env.PORT, 10) || 8084,
  databaseURL: process.env.MONGODB_URI,
  api: {
    prefix: process.env.THIRD_PARTY_TRANSPORTATION_SERVICE_PREFIX || "/tpt",
  },
};
