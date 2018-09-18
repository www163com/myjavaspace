package com.billyang.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yangcan14944
 *Springboot 文件上传
 *
 */
@RestController  //所有方法的返回值都要做json转化 @Controller+@ResponseBody
public class FileUploadController {

      /*
       * 处理文件上传
       * */
	@RequestMapping("/fileUploadController")
	public Map<String,Object> fileUpload(MultipartFile filename)throws Exception{
		System.out.println(filename.getOriginalFilename());
		filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
		Map<String,Object> map = new HashMap<>();
		map.put("msg", "ok");
		return map;
	}
}
