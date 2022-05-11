export function ConflictException(message) {
  const error = new Error(message);
  error.status = 409;
  return error;
}
