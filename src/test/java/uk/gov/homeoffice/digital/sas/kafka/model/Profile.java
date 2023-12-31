package uk.gov.homeoffice.digital.sas.kafka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.gov.homeoffice.digital.sas.kafka.listener.KafkaEntityListener;
import uk.gov.homeoffice.digital.sas.kafka.message.Messageable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "profile")
@EntityListeners(KafkaEntityListener.class)
public class Profile implements Messageable {

  @Id
  @GeneratedValue
  private Long id;
  private String tenantId;
  private String name;
  private Date startTime;

  @Override
  public String resolveMessageKey() {
    return getId() + ":" + getTenantId();
  }
}
