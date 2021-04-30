package ingjulianvega.ximic.msscasuremission.bootstrap;

import ingjulianvega.ximic.msscasuremission.domain.RemissionEntity;
import ingjulianvega.ximic.msscasuremission.domain.repositories.RemissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RemissionLoader implements CommandLineRunner {

    private final RemissionRepository remissionRepository;

    @Override
    public void run(String... args) throws Exception {
        if (remissionRepository.count() == 0) {
            loadRemissionObjects();
        }
    }

    private void loadRemissionObjects() {
        remissionRepository.saveAll(Arrays.asList(
                RemissionEntity.builder().visitId(UUID.randomUUID())
                        .remissionTypeId(UUID.randomUUID())
                        .observations("observación").build(),
                RemissionEntity.builder().visitId(UUID.randomUUID())
                        .remissionTypeId(UUID.randomUUID())
                        .observations("observación").build(),
                RemissionEntity.builder().visitId(UUID.randomUUID())
                        .remissionTypeId(UUID.randomUUID())
                        .observations("observación").build(),
                RemissionEntity.builder().visitId(UUID.randomUUID())
                        .remissionTypeId(UUID.randomUUID())
                        .observations("observación").build(),
                RemissionEntity.builder().visitId(UUID.randomUUID())
                        .remissionTypeId(UUID.randomUUID())
                        .observations("observación").build(),
                RemissionEntity.builder().visitId(UUID.randomUUID())
                        .remissionTypeId(UUID.randomUUID())
                        .observations("observación").build(),
                RemissionEntity.builder().visitId(UUID.randomUUID())
                        .remissionTypeId(UUID.randomUUID())
                        .observations("observación").build()

        ));
    }
}