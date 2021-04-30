package ingjulianvega.ximic.msscasuremission.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemissionDto implements Serializable {

    static final long serialVersionUID = -4666392673916971725L;

    private UUID id;
    private UUID visitId;
    private UUID remissionTypeId;
    private String observations;

}
