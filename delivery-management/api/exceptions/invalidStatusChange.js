export function InvalidStatusChangeException() {
  const error = new Error("The required change in status is invalid");
  error.status = 409;
  return error;
}
