package com.digitalesweb.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic generateTopic()
    {
        Map<String , String> topicsConfig = new HashMap<>();
        topicsConfig.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        topicsConfig.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // por defecto viene en -1 para que never delete.
        topicsConfig.put(TopicConfig.SEGMENT_BYTES_CONFIG, "9000000000");
        topicsConfig.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "90000");


        return TopicBuilder.name("DigitalesWeb-Topic")
                .partitions(2)
                .replicas(2)
                .configs(topicsConfig)
                .build();
    }
}
