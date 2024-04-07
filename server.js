'use strict';

const ConsumerQueueService = require('./src/services/consumer-queue.service');

const queueName = 'test-topic';

ConsumerQueueService.consumerToQueue(queueName)
  .then(() => {
    console.log(`Message consumer started ${queueName}`);
  })
  .catch((error) => {
    console.log(`Message error: ${error}`);
  });
