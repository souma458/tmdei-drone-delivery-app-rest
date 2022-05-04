import config from "./config/config.js";
import loaders from "./loaders/loaders.js";
import express from "express";
import Logger from "./loaders/logger.js";

async function startServer() {
  const app = express();

  await loaders({ expressApp: app });

  app
    .listen(config.port, () => {
      Logger.info(`
      ######################################################
      ${config.appName} Server listening on port: ${config.port}
      ######################################################
    `);
    })
    .on("error", (err) => {
      Logger.error(err);
      process.exit(1);
    });
}

startServer();
