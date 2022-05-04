if (!process.env.MONGODB_URI) {
  throw new Error("Couldn't find MongoDB connection path");
}

export default {
  appName: "Delivery Management",
  /**
   * Your favorite port
   */
  port: parseInt(process.env.PORT, 10) || 8080,

  /**
   * That long string from mlab
   */
  databaseURL: process.env.MONGODB_URI,

  /**
   * API configs
   */
  api: {
    prefix: process.env.DELIVERY_SERVICE_PREFIX || "/dm",
  },
};
