package ingjulianvega.ximic.msscasuremission.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "remission")
public class RemissionParameters {

    private String api;
}
