package co.edu.udea.chopeviverobackend.dtos.humidity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HumidityHistoryRequestDto {

    private String sensorSerial;

    private Double humidity;

}
