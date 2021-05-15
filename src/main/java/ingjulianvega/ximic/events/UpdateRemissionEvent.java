package ingjulianvega.ximic.events;

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
public class UpdateRemissionEvent implements Serializable {
    static final long serialVersionUID = 7387012760120456424L;

    private UUID visitId;
    private UUID remissionTypeId;
    private String observations;

}
