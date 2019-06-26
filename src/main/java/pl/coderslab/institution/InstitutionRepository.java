package pl.coderslab.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    @Query(value = "select count(distinct institution_id) from donation", nativeQuery = true)
    Long getNumberOfInstitutions();
}
