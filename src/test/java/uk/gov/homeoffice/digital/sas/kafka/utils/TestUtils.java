package uk.gov.homeoffice.digital.sas.kafka.utils;


import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ACTION_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ACTION_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ACTUAL_END_TIME_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ACTUAL_END_TIME_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ACTUAL_START_TIME_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ACTUAL_START_TIME_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ID_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.ID_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.OWNER_ID_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.OWNER_ID_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.RESOURCE_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.SCHEMA_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.SCHEMA_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.SHIFT_TYPE_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.SHIFT_TYPE_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.TENANT_ID_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.TENANT_ID_FIELD_VALUE;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.TIME_PERIOD_TYPE_ID_FIELD_NAME;
import static uk.gov.homeoffice.digital.sas.kafka.Constants.TestConstants.TIME_PERIOD_TYPE_ID_FIELD_VALUE;

import com.google.gson.Gson;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;
import uk.gov.homeoffice.digital.sas.kafka.message.KafkaAction;
import uk.gov.homeoffice.digital.sas.kafka.message.KafkaEventMessage;
import uk.gov.homeoffice.digital.sas.kafka.model.Profile;

public class TestUtils {

  public static KafkaEventMessage<Profile> generateExpectedKafkaEventMessage(String version, Profile resource,
                                                                             KafkaAction action) {
    return new KafkaEventMessage<>(version, resource, action);
  }

  public static <S extends Serializable> String createKafkaMessage(String version){
    String resource = createResourceJson();

    return new Gson().toJson(Map.of(
        SCHEMA_FIELD_NAME, String.format(SCHEMA_FIELD_VALUE, version),
        RESOURCE_FIELD_NAME, resource,
        ACTION_FIELD_NAME, ACTION_FIELD_VALUE));
  }

  public static <S extends Serializable> String createKafkaMessage(String schemaFieldValue,
                                                                   String version){
    String resource = createResourceJson();

    return new Gson().toJson(Map.of(
        SCHEMA_FIELD_NAME, String.format(schemaFieldValue, version),
        RESOURCE_FIELD_NAME, resource,
        ACTION_FIELD_NAME, ACTION_FIELD_VALUE));
  }

  private static <S extends Serializable> String createResourceJson() {
    return new Gson().toJson(Map.of(
        ID_FIELD_NAME, ID_FIELD_VALUE,
        TENANT_ID_FIELD_NAME, TENANT_ID_FIELD_VALUE,
        OWNER_ID_FIELD_NAME, OWNER_ID_FIELD_VALUE,
        TIME_PERIOD_TYPE_ID_FIELD_NAME, TIME_PERIOD_TYPE_ID_FIELD_VALUE,
        SHIFT_TYPE_FIELD_NAME, SHIFT_TYPE_FIELD_VALUE,
        ACTUAL_START_TIME_FIELD_NAME, ACTUAL_START_TIME_FIELD_VALUE,
        ACTUAL_END_TIME_FIELD_NAME, ACTUAL_END_TIME_FIELD_VALUE
    ));
  }

  public static Date getAsDate(LocalDateTime dateTime) {
    return Date.from(dateTime.toInstant(ZoneOffset.UTC));
  }
}
