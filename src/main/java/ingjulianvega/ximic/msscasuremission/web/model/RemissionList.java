package ingjulianvega.ximic.msscasuremission.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemissionList implements Serializable {

    static final long serialVersionUID = 3299660768817965510L;

    public ArrayList<RemissionDto> remissionDtoList;
}
