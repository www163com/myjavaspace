package com.billyang.girl.controller;

import com.billyang.girl.aspect.HttpAspect;
import com.billyang.girl.domain.Girl;
import com.billyang.girl.domain.Result;
import com.billyang.girl.repository.GirlRepository;
import com.billyang.girl.service.GirlService;
import com.billyang.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /*
    * 查找女生列表
    * */
    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        logger.error("3333");
        return girlRepository.findAll();
    }
//    /*
//    * 添加一个女生
//    * */
//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                         @RequestParam("age") Integer age){
//        Girl girl = new Girl();
//        girl.setAge(age);
//        girl.setCupSize(cupSize);
//        return  girlRepository.save(girl);
//    }
     /*
    * 添加一个女生
    * */
@PostMapping(value = "/girls")
public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
       // System.out.println(bindingResult.getFieldError().getDefaultMessage());
//        Result result = new Result();
//        result.setCode(1);
//        result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//        result.setData(null);
//      //  return bindingResult.getFieldError().getDefaultMessage();
//        return result;
        return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
    }
    girl.setAge(girl.getAge());
    girl.setCupSize(girl.getCupSize());
//    Result result = new Result();
//    result.setCode(0);
//    result.setMsg("处理成功");
  //   result.setData(girlRepository.save(girl));
    return  ResultUtils.success(girlRepository.save(girl));
}
    /*
    * 通过ID查找一个女生
    * */
    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }
     /*
    * 更新一个女生
    * */
    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return  girlRepository.save(girl);
    }

     /*
    * 删除一个女生
    * */
   @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
       girlRepository.delete(id);
   }
   //通过年纪来查询女生列表
    @GetMapping(value="girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value="/girls/two")
    public void girlTwo(){
      girlService.insertTwo();
    }
    @GetMapping(value="girls/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception {
        girlService.getAge(id);
    }
}
