package ingjulianvega.ximic.msscasuremission.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Remission implements Serializable {

    static final long serialVersionUID = -4078429777656358572L;

    @NotNull
    private UUID visitId;

    @NotNull
    private UUID remissionTypeId;

    @NotBlank
    private String observations;

}
