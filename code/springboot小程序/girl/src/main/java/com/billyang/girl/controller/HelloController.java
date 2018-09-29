package com.billyang.girl.controller;

import com.billyang.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
//@RequestMapping("/hello")  对于类级别的映射 此时需要在方式级别上做具体的请求映射
public class HelloController {
//    @Value("${cupSize}")
//    private String capSize;
//    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
//    private String content;
    @Autowired
    private GirlProperties girlProperties;
    //*************************************//

//    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)  对于类级别的映射 此时需要在方式级别上做具体的请求映射
//    public String say(){
////        return content;
//          return girlProperties.getCupSize();
////        return "index";
//    }

    // ************************************//
    //    @RequestMapping(value = {"/hello/{id}","/{id}/hi"},method = RequestMethod.GET)
    //http://localhost:8081/hello/100         http://localhost:8081/100/hi
//    public String say(@PathVariable("id")Integer id){
//        return "id=" + id;
//    }

    //*********************************//
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping(value="/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "200")Integer myId,@RequestParam(value = "id2",required = false,defaultValue = "100")Integer myId2){
        return "id="+myId+"/r/n+id2="+myId2;
    }
}
