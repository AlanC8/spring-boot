package kz.kbtu.sis5.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PartitionKafkaConsumer {

    // Слушаем конкретные партиции (0 и 3) с указанием начального offset'а
    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "${spring.kafka.topic-name}",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")
                    }),
            containerFactory = "kafkaListenerContainerFactory"
    )

    public void listenSpecificPartitionsWithOffset(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        System.out.println("Received message: " + message +
                " from partition: " + partition);
    }

    // Если не нужно указывать offset, слушаем только партиции (например, 1 и 2)
    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "${spring.kafka.topic-name}",
                    partitions = {"1", "2"}),
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listenSpecificPartitionsWithoutOffset(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        System.out.println("Received message: " + message +
                " from partition: " + partition);
    }
}
