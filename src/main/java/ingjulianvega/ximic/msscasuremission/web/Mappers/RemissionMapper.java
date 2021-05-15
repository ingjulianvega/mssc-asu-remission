package ingjulianvega.ximic.msscasuremission.web.Mappers;


import ingjulianvega.ximic.events.UpdateRemissionEvent;
import ingjulianvega.ximic.msscasuremission.domain.RemissionEntity;
import ingjulianvega.ximic.msscasuremission.web.model.Remission;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface RemissionMapper {
    RemissionDto remissionEntityToRemissionDto(RemissionEntity remissionEntity);

    RemissionEntity remissionDtoToRemissionEntity(RemissionDto remissionDto);

    ArrayList<RemissionDto> remissionEntityListToRemissionDtoList(List<RemissionEntity> remissionEntityList);

    Remission updateRemissionEventToRemission(UpdateRemissionEvent updateRemissionEvent);
}
