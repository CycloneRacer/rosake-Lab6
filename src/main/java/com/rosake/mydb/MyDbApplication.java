package com.rosake.mydb;

import com.rosake.mydb.entities.Address;
import com.rosake.mydb.entities.Profile;
import com.rosake.mydb.entities.User;
import com.rosake.mydb.repositories.UserRepository;
import com.rosake.mydb.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class MyDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDbApplication.class, args);
    }

    @Bean
    CommandLineRunner createSampleProduct(UserService service) {
        return args -> service.deleteProduct();
    }

    //var repository = context.getBean(UserRepository.class);
    //var service = context.getBean(UserService.class);
    //service.showEntityState();
    //service.showRelatedEntities();
    //service.PersistRelated();
    //service.deleteRelated();
    /*  var user = User.builder()
            .name("John")
            .email("john@example.com")
            .password("Password")
            .build();

     var address = Address.builder()
            .city("Cincinnati")
            .state("Ohio")
            .street("123 Main St")
            .zip("45202")
            .build();*/

    /* var profile = Profile.builder()
            .id(1L)
            .bio("profile")
            .phone_number("555-555-5555")
            .date_of_birth(Date.valueOf("06/21/2004"))
            .loyalty_points(0)
            .build(); */

    /*  user.addAddress(address);
       repository.save(user);

       var users = repository.findAll();
       users.forEach(u -> System.out.println(u.getEmail()));

       repository.deleteById(1L);*/
}
