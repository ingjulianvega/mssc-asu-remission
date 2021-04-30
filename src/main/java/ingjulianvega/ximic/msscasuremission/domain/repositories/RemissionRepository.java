package ingjulianvega.ximic.msscasuremission.domain.repositories;

import ingjulianvega.ximic.msscasuremission.domain.RemissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface RemissionRepository extends JpaRepository<RemissionEntity, UUID>, JpaSpecificationExecutor<RemissionEntity> {
    List<RemissionEntity> findByVisitId(UUID visitId);
}
