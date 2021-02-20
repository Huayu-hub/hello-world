package com.alice;



import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class paramValue {

    @GetMapping("car/{id}/owner/{username}")
    public Map<String, Object> getStringvalue(
            @RequestParam Map<String , String> params,
            @RequestParam("inters") String inters
    ){
        Map<String , Object> map = new HashMap<String, Object>();

        map.put("params" , params);
        map.put("inters" , inters);

        return map ;

    }
    @PostMapping("/test/pet")
    public Map getPetInformation(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ){
        Pet pet = new Pet(name , age ) ;
        Map<String , Object > map = new HashMap<>();
        map.put("Pet",pet) ;
        return map ;
    }

}
//        import org.springframework.web.bind.annotation.GetMapping;
//        import org.springframework.web.bind.annotation.RequestParam;
//        import org.springframework.web.bind.annotation.RestController;
//
//        import java.util.HashMap;
//        import java.util.Map;
//
//@RestController
//public class paramValue {
//
//    @GetMapping("car/{id}/owner/{username}")
//    public Map<String, String> getStringvalue(
//            @RequestParam Map<String , String > params,
//            @RequestParam("inters") String inters
//    ){
//        Map<String , Object> map = new HashMap<>();
//
//        map.put("params" , params);
//        map.put("inters" , inters);
//
//        return map ;
//
//    }
//}