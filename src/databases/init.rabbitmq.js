'use strict';

const amqp = require('amqplib');

const connectToRabbitMQ = async () => {
  try {
    const connection = await amqp.connect('amqp://localhost');
    if (!connection) {
      throw new Error('Not connect to MQ');
    }

    const channel = await connection.createChannel();

    return { channel, connection };
  } catch (error) {
    console.error('Error connect to RabbitMQ', error);
    throw error;
  }
};

const connectToRabbitMQForTest = async () => {
  try {
    const { channel, connection } = await connectToRabbitMQ();

    // Publish message to queue
    const queue = 'test-queue';
    const message = 'Hello World';
    await channel.assertQueue(queue);
    await channel.sendToQueue(queue, Buffer.from(message));

    // close the connection
    await connection.close();
  } catch (error) {
    console.error('Error connect to RabbitMQ', error);
    throw error;
  }
};

const consumerQueue = async (channel, queueName) => {
  try {
    await channel.assertQueue(queueName, { durable: true });
    console.log(`Waiting for messages ...`);
    channel.consume(
      queueName,
      (msg) => {
        console.log(
          `Received message of ${queueName}: `,
          msg.content.toString()
        );
      },
      {
        noAck: true,
      }
    );

    // close the connection
  } catch (error) {
    console.error('Error consume message to RabbitMQ', error);
    throw error;
  }
};

module.exports = {
  connectToRabbitMQ,
  connectToRabbitMQForTest,
  consumerQueue,
};
