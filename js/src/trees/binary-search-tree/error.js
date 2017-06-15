export class NotFoundError extends Error{
  constructor(value) {
    super();
    this.name = 'NotFoundError';
    this.message = `value ${value} not found`;
  }
}
