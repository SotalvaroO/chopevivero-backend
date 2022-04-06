package co.edu.udea.chopeviverobackend.controllers.mosquitto;

import co.edu.udea.chopeviverobackend.entites.mosquitto.MosquittoEntity;
import co.edu.udea.chopeviverobackend.services.mosquitto.MessagingService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/mosquitto")
public class MosquittoController {

    @Autowired
    private MessagingService _messagingService;

    @PostMapping
    public ResponseEntity<?> publishMessage(@RequestBody MosquittoEntity mqttMessage) {
        try {
            _messagingService.publish(mqttMessage.getTopic(), mqttMessage.getMessage().toString() , 0, false);
            return ResponseEntity.ok("Success");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.ok("fail");
        }
    }


}
