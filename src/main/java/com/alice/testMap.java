package com.alice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


public class testMap {

    @GetMapping("car/{id}/owner/{username}")
    public Map<String, Object> getStringvalue(
            @RequestParam Map<String , String > params
    ){
        Map<String ,Object> map = new HashMap<>();
        map.put("params" , params);
        return map;

    }
}
