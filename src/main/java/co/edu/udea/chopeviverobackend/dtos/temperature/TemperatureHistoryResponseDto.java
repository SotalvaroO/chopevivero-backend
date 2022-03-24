package co.edu.udea.chopeviverobackend.dtos.temperature;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class TemperatureHistoryResponseDto {

    private TemperatureSensorDto sensor;

    private Double temperature;

    private Date time;



}
