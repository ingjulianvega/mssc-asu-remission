package ingjulianvega.ximic.msscasuremission.web.controller;


import ingjulianvega.ximic.msscasuremission.services.RemissionService;
import ingjulianvega.ximic.msscasuremission.web.model.Remission;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionDto;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RemissionController implements RemissionI {

    private final RemissionService remissionService;

    @Override
    public ResponseEntity<RemissionList> get() {
        return new ResponseEntity<>(remissionService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RemissionDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(remissionService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RemissionList> getByVisittId(UUID visitId) {
        return new ResponseEntity<>(remissionService.getByVisitId(visitId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Remission remission) {
        remissionService.create(remission);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Remission remission) {
        remissionService.updateById(id, remission);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        remissionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
