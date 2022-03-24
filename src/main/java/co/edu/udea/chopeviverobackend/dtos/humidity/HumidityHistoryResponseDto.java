package co.edu.udea.chopeviverobackend.dtos.humidity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class HumidityHistoryResponseDto {

    private HumiditySensorDto sensor;

    private Double humidity;

    private Date time;



}
