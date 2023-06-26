package com.kcp.openid.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class SampleController {

	@RequestMapping("/hello")
	public String hello() {
		log.info("Hello KeyCloak!");
	    return "hello";
	}
		
	@RequestMapping("/app1")
	public String tracingTest() {
		log.info("This is permitAll!");
		down();
	    return "app1";
	}	
	
	public void down() {
		String fileUrl  = "http://localhost:8081/auth/realms/LocalOpenIDRealm/.well-known/openid-configuration";
        String fileName = "configuration.txt";                 // 파일명 (랜덤생성)
        //int    index    = fileUrl.lastIndexOf(".");                     // . 위치 뒤에서부터 찾기
        //String ext      = fileUrl.substring(index);                     // 파일 확장자 추출
        Path   target   = Paths.get("D:/temp/", fileName); // 파일 저장 경로
	
        try {
            URL url = new URL(fileUrl);
            
            InputStream in = url.openStream();
            System.out.println("--------------------------");
            System.out.println(in.toString());
            System.out.println("--------------------------");
            Files.copy(in, target); // target 경로로 파일 복사
            in.close();
            System.out.println("download ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
