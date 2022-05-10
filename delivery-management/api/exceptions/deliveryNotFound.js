export function DeliveryNotFoundException(delivery) {
  const error = new Error("There is no delivery with id = " + delivery);
  error.status = 404;
  return error;
}
