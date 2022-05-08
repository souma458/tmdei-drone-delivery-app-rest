import { TransportationRequestService } from "../service/service.js";
import { CreateTransportationRequestResponseDTO } from "../model/response/createTransportationRequestResponseDTO.js";
import { handleError } from "./errorHandler.js";

export class TransportationRequestController {
  constructor() {
    this.service = new TransportationRequestService();
  }

  async createTransportationRequest(req, res) {
    try {
      const transportationRequest =
        await this.service.createTransportationRequest(req.body);
      res
        .status(201)
        .send(
          new CreateTransportationRequestResponseDTO(transportationRequest)
        );
    } catch (err) {
      handleError(res, err);
    }
  }
}
