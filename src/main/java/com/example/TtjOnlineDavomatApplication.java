package com.example;

import com.example.service.DavomatService;
import com.example.service.DavomatServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class TtjOnlineDavomatApplication {

    public static void main( String[] args ) {
        SpringApplication.run(TtjOnlineDavomatApplication.class, args);
    }

}
