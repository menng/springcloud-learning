package org.aaron.ping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    private Integer id;
    private String name;
    private String description;
}

@RestController
@RequestMapping("/ping")
class CityController {

    @Autowired
    private PongCityFeign pongCityFeign;

    @RequestMapping("/city/list")
    public Object listCity() {
        return Arrays.asList(City.builder().id(1).name("北京").description("ping").build()
                , City.builder().id(2).name("上海").description("ping").build());
    }

    @RequestMapping("/pong/city/list")
    public Object listPongCity() {
        return pongCityFeign.listPongCity();
    }
}

@FeignClient(name = "sc-bs-pong")
interface PongCityFeign {

    @RequestMapping("/pong/city/list")
    Object listPongCity();
}