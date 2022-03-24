package co.edu.udea.chopeviverobackend.dtos.radiation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RadiationHistoryRequestDto {

    private String sensorSerial;

    private Double radiation;

}
