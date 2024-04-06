'use strict';

const { connectToRabbitMQForTest } = require('../databases/init.rabbitmq');

describe('RabbitMQ connect', () => {
  it('Should connect to successful RabbitMQ', async () => {
    const result = await connectToRabbitMQForTest();
    expect(result).toBeUndefined();
  });
});
