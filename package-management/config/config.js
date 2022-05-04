if (!process.env.MONGODB_URI) {
  throw new Error("Couldn't find MongoDB connection path");
}

export default {
  appName: "Package Management",
  port: parseInt(process.env.PORT, 10) || 8080,
  databaseURL: process.env.MONGODB_URI,
  api: {
    prefix: process.env.PACKAGE_SERVICE_PREFIX || "/pm",
  },
};
