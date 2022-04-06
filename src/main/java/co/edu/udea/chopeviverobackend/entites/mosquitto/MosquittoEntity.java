package co.edu.udea.chopeviverobackend.entites.mosquitto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MosquittoEntity {

    private String topic;
    private Object message;

}
