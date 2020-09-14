# amq-streams-client project

To validate if the message is being sent to the topic check this:

```sh
/opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server kafka-kafka-bootstrap:9092 \
        --topic test.prices --from-beginning --property print.key=true --property key.separator=" : " \
        --value-deserializer "org.apache.kafka.common.serialization.IntegerDeserializer"
```