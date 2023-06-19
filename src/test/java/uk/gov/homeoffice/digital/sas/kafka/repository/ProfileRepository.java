package uk.gov.homeoffice.digital.sas.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gov.homeoffice.digital.sas.kafka.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
}
