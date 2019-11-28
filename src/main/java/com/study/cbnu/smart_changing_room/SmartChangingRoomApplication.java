package com.study.cbnu.smart_changing_room;

import com.study.cbnu.smart_changing_room.property.FileUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileUploadProperties.class
})
public class SmartChangingRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartChangingRoomApplication.class, args);
    }

}
