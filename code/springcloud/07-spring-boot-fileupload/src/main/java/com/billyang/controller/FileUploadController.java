package com.billyang.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yangcan14944
 *Springboot �ļ��ϴ�
 *
 */
@RestController  //���з����ķ���ֵ��Ҫ��jsonת�� @Controller+@ResponseBody
public class FileUploadController {

      /*
       * �����ļ��ϴ�
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
