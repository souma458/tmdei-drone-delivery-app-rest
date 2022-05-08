if (!process.env.MONGODB_URI) {
  throw new Error("Couldn't find MongoDB connection path");
}

export default {
  appName: "Delivery Management",
  port: parseInt(process.env.PORT, 10) || 8080,
  databaseURL: process.env.MONGODB_URI,
  api: {
    prefix: process.env.DELIVERY_SERVICE_PREFIX || "/dm",
  },
};
