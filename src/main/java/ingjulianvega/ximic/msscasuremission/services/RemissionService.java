package ingjulianvega.ximic.msscasuremission.services;


import ingjulianvega.ximic.msscasuremission.web.model.Remission;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionDto;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionList;

import java.util.UUID;

public interface RemissionService {
    RemissionList get();

    RemissionDto getById(UUID id);

    RemissionList getByVisitId(UUID patientId);

    void create(Remission remission);

    void updateById(UUID id, Remission remission);

    void deleteById(UUID id);


}
