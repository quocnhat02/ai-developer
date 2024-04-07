'use strict';

const {
  connectToRabbitMQ,
  consumerQueue,
} = require('../databases/init.rabbitmq');

class ConsumerQueueService {
  static async consumerToQueue(queueName) {
    try {
      const { channel, connection } = await connectToRabbitMQ();
      await consumerQueue(channel, queueName);
      //   find user following SHOP
      // send message
      // yes => success
      // error. setup DLX ...
    } catch (error) {
      console.error('Error consume message to RabbitMQ', error);
      throw error;
    }
  }
}

module.exports = ConsumerQueueService;
