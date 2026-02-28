package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

import jakarta.annotation.PostConstruct;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @PostConstruct
    public void init() {
        log.info("========================================");
        log.info("KafkaConsumer initialized and ready to consume from topic 'patient'");
        log.info("Consumer Group ID: analytics-service");
        log.info("========================================");
    }

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumeEvent(byte[] event) {
        if (event == null || event.length == 0) {
            log.warn("Received null or empty event from Kafka topic 'patient'");
            return;
        }

        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);

            log.info("✓ Received Patient Event: [PatientId={}, PatientName={}, PatientEmail={}, EventType={}]",
                    patientEvent.getPatientId(),
                    patientEvent.getName(),
                    patientEvent.getEmail(),
                    patientEvent.getEventType());

            // TODO: Implement analytics business logic here
            // Examples: store in analytics DB, update dashboards, calculate metrics, etc.

        } catch (InvalidProtocolBufferException e) {
            log.error("✗ Failed to deserialize PatientEvent from Kafka message. Invalid protobuf format. Error: {}",
                    e.getMessage(), e);
        } catch (Exception e) {
            log.error("✗ Unexpected error while processing Kafka event: {}",
                    e.getMessage(), e);
        }
    }
}