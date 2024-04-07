'use strict';

const ConsumerQueueService = require('./src/services/consumer-queue.service');

const queueName = 'test-topic';

// ConsumerQueueService.consumerToQueue(queueName)
//   .then(() => {
//     console.log(`Message consumer started ${queueName}`);
//   })
//   .catch((error) => {
//     console.log(`Message error: ${error}`);
//   });

ConsumerQueueService.consumerToQueueNormal()
  .then(() => {
    console.log(`Message consumer normal started`);
  })
  .catch((error) => {
    console.log(`Message error: ${error}`);
  });

ConsumerQueueService.consumerToQueueFailed()
  .then(() => {
    console.log(`Message consumer failed started`);
  })
  .catch((error) => {
    console.log(`Message error: ${error}`);
  });
