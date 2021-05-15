package ingjulianvega.ximic.msscasuremission.listener;

import ingjulianvega.ximic.events.UpdateRemissionEvent;
import ingjulianvega.ximic.msscasuremission.configuration.JmsConfig;
import ingjulianvega.ximic.msscasuremission.services.RemissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateRemissionListener {

    private final RemissionService remissionService;

    @JmsListener(destination = JmsConfig.UPDATE_REMISSION_QUEUE)
    public void listen(UpdateRemissionEvent event) {
        log.debug("Got updateVisit " + event.toString());
        //visitService.create(event.getVisit());
    }
}
