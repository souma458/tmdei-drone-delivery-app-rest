if (!process.env.MONGODB_URI) {
  throw new Error("Couldn't find MongoDB connection path");
}

export default {
  appName: "Package Management",
  /**
   * Your favorite port
   */
  port: parseInt(process.env.PORT, 10) || 8084,

  /**
   * That long string from mlab
   */
  databaseURL: process.env.MONGODB_URI,

  /**
   * API configs
   */
  api: {
    prefix: "/pm",
  },
};
