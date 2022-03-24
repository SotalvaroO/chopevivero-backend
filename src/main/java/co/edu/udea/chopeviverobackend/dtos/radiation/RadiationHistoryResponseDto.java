package co.edu.udea.chopeviverobackend.dtos.radiation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class RadiationHistoryResponseDto {

    private RadiationSensorDto sensor;

    private Double radiation;

    private Date time;



}
