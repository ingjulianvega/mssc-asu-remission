package ingjulianvega.ximic.msscasuremission.services;


import ingjulianvega.ximic.msscasuremission.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuremission.domain.RemissionEntity;
import ingjulianvega.ximic.msscasuremission.domain.repositories.RemissionRepository;
import ingjulianvega.ximic.msscasuremission.exception.RemissionException;
import ingjulianvega.ximic.msscasuremission.web.Mappers.RemissionMapper;
import ingjulianvega.ximic.msscasuremission.web.model.Remission;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionDto;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class RemissionServiceImpl implements RemissionService {

    private final RemissionRepository remissionRepository;
    private final RemissionMapper remissionMapper;

    @Cacheable(cacheNames = "remissionListCache")
    @Override
    public RemissionList get() {
        log.debug("get()...");
        return RemissionList
                .builder()
                .remissionDtoList(remissionMapper.remissionEntityListToRemissionDtoList(remissionRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "remissionCache")
    @Override
    public RemissionDto getById(UUID id) {
        log.debug("getById()...");
        return remissionMapper.remissionEntityToRemissionDto(
                remissionRepository.findById(id)
                        .orElseThrow(() -> RemissionException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.REMISSION_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.REMISSION_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.REMISSION_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.REMISSION_NOT_FOUND_SOLUTION)
                                .build()));
    }

    @Override
    public RemissionList getByVisitId(UUID visitId) {
        log.debug("getByVisitId()...");
        return RemissionList
                .builder()
                .remissionDtoList(remissionMapper.remissionEntityListToRemissionDtoList(remissionRepository.findByVisitId(visitId)))
                .build();
    }

    @Override
    public void create(Remission remission) {
        log.debug("create()...");
        remissionMapper.remissionEntityToRemissionDto(
                remissionRepository.save(
                        remissionMapper.remissionDtoToRemissionEntity(
                                RemissionDto
                                        .builder()
                                        .visitId(remission.getVisitId())
                                        .remissionTypeId(remission.getRemissionTypeId())
                                        .observations(remission.getObservations())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Remission remission) {
        log.debug("updateById...");
        RemissionEntity remissionEntity = remissionRepository.findById(id)
                .orElseThrow(() -> RemissionException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.REMISSION_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.REMISSION_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.REMISSION_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.REMISSION_NOT_FOUND_SOLUTION)
                        .build());

        remissionEntity.setVisitId(remission.getVisitId());
        remissionEntity.setRemissionTypeId(remission.getRemissionTypeId());
        remissionEntity.setObservations(remission.getObservations());

        remissionRepository.save(remissionEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        remissionRepository.deleteById(id);
    }
}
