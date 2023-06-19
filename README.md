# callisto-kafka-commons

A Library using spring kafka, containing useful functionality for a spring applications that need to produce and consume with kafka topics.

# Producing
  This library wires itself into a JPA transaction for producing messages to kafka topics. It is configured to produce event messages after commit.
  This can be wired up on a entity that will be used for JPA transactions with the following:
  ```
  @EntityListeners(KafkaEntityListener.class)
  ```
 
# Consumer
   When consuming a kafa listener will need to be wired up within your servce. The library contains a method to deserialize a valid kafkaEventMessage.
      ```
     KafkaConsumerService.convertToKafkaEventMessage
    ```
   The library also contains a schema validator. This uses the semver4J library to validate the schema version. This can be configured as follows:
    ```
     kafka.supported.schema.version
    ```
    
   See the[semver4J](https://github.com/vdurmont/semver4j) for further details on what validation can be achieved.
   
   ## Exception Handling
   This library contains an excpetion which can be thrown in order to stop the consumer from consuming messages. This is a critical exception and would require      the consumer service to be brought back up when thrown.


