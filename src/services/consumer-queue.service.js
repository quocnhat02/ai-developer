'use strict';

const {
  connectToRabbitMQ,
  consumerQueue,
} = require('../databases/init.rabbitmq');

const log = console.log;

console.log = function () {
  log.apply(console, [new Date()].concat(arguments));
};

class ConsumerQueueService {
  static async consumerToQueue(queueName) {
    try {
      const { channel, connection } = await connectToRabbitMQ();
      await consumerQueue(channel, queueName);
    } catch (error) {
      console.error('Error consume message to RabbitMQ', error);
      throw error;
    }
  }

  //   case processing
  static async consumerToQueueNormal(queueName) {
    try {
      const { channel, connection } = await connectToRabbitMQ();
      const timeExpired = 5000;
      setTimeout(() => {
        channel.consume(notificationQueue, (msg) => {
          console.log(
            `Send notificationQueue successfully processed: `,
            msg.content.toString()
          );
          channel.ack(msg);
        });
      }, timeExpired);
    } catch (error) {
      console.error(error);
    }
  }

  //   case failed processing
  static async consumerToQueueFailed(queueName) {
    try {
      const { channel, connection } = await connectToRabbitMQ();

      const notificationExchangeDLX = 'notificationExDXL';
      const notificationRoutingKeyDLX = 'notificationRoutingKeyDLX';
      const notificationQueueHandler = 'notificationQueueHotFix';

      await channel.assertExchange(notificationExchangeDLX, 'direct', {
        durable: true,
      });

      const queueResult = await channel.assertQueue(notificationQueueHandler, {
        exclusive: false,
      });

      await channel.bindQueue(
        queueResult.queue,
        notificationExchangeDLX,
        notificationRoutingKeyDLX
      );
      await channel.consume(
        queueResult.queue,
        (msgFailed) => {
          console.log(
            `This notification was error, please hot fix: `,
            msgFailed.content.toString()
          );
        },
        {
          noAck: true,
        }
      );
    } catch (error) {
      console.error(error);
      throw error;
    }
  }
}

module.exports = ConsumerQueueService;
