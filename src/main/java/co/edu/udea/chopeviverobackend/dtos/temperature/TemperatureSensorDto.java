package co.edu.udea.chopeviverobackend.dtos.temperature;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TemperatureSensorDto {

    private String serial;
    private String name;


}
