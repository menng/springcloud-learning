package org.aaron.ping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * TODO
 * @author mengxy
 * @create 2018/11/20 20:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    private Integer id;
    private String name;
}

@RestController
class CityController {

    @RequestMapping("/city/list")
    public Object listCity() {
        return Arrays.asList(City.builder().id(1).name("北京").build()
                , City.builder().id(2).name("上海").build());
    }
}