package com.young.photoshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.young.photoshare.mapper")
public class PhotoShareControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoShareControllerApplication.class, args);
    }

}
