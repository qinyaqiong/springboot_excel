package com.sjh;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sjh
 * @date 2020/5/6
 */
@SpringBootApplication
@MapperScan("com.sjh.mapper")
@Slf4j
public class SpringBootApplicationExcel{

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationExcel.class,args);
        log.info("txglXmStart-success==========");
    }

}
