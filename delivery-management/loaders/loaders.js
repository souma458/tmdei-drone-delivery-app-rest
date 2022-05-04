import expressLoader from "./express.js";
import mongooseLoader from "./mongoose.js";
import Logger from "./logger.js";

export default async ({ expressApp }) => {
  await mongooseLoader();
  Logger.info("DB loaded and connected!");

  await expressLoader({ app: expressApp });
  Logger.info("Express loaded!");
};
