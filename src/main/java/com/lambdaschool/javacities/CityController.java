package com.lambdaschool.javacities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@RestController
public class CityController
{
    private final CityRepository cityrepo;
    private final RabbitTemplate rt;

    public CityController(CityRepository cityrepo, RabbitTemplate rt)
    {
        this.cityrepo = cityrepo;
        this.rt = rt;
    }

    @GetMapping("/cities/afford")
    public void getAffordable()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.addAll(cityrepo.findAll());

        for (City c : cities)
        {
            int rand = new Random().nextInt(10);
            boolean randBool = new Random().nextBoolean();
            final CityMessage message = new CityMessage(c.toString(), rand, randBool);

            log.info("Sending Message...");
            if (randBool) {
                rt.convertAndSend(JavacitiesApplication.QUEUE_NAME_SECRET, message);
            } else if (c.getAffordability() < 6) {
                rt.convertAndSend(JavacitiesApplication.QUEUE_NAME_CITIES1, message);
            } else {
                rt.convertAndSend(JavacitiesApplication.QUEUE_NAME_CITIES2, message);
            }
        }
    }
}
