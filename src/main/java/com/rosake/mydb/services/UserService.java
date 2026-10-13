package com.rosake.mydb.services;

import com.rosake.mydb.entities.Address;
import com.rosake.mydb.entities.Category;
import com.rosake.mydb.entities.Product;
import com.rosake.mydb.entities.User;
import com.rosake.mydb.repositories.CategoryRepository;
import com.rosake.mydb.repositories.ProductRepository;
import com.rosake.mydb.repositories.ProfileRepository;
import com.rosake.mydb.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;


    @Transactional
    public void showEntityState()
    {
        var user = User.builder()
                .name("John Doe")
                .email("jdoe@example.com")
                .password("password")
                .build();

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient/Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient/Detached");
    }
    @Transactional
    public void showRelatedEntities(){
        //var user = userRepository.findById(2L).orElseThrow();
        //System.out.println(user.getEmail());

        var profile = profileRepository.findById((2L)).orElseThrow();
        //System.out.println((profile.getBio()));
        System.out.println((profile.getUser().getEmail()));
    }

    @Transactional
    public void PersistRelated(){
        var user = User.builder()
                .name("Jane Doe")
                .email("jane@example.com")
                .password("password")
                .build();

        var address = Address.builder()
                .street("Vine Street")
                .city("Cincinnati")
                .state("Ohio")
                .zip("45202")
                .build();

        user.addAddress(address);
        userRepository.save(user);


    }
    @Transactional
    public void deleteRelated(){
        //userRepository.deleteById(6L);
        var user = userRepository.findById(7L).orElseThrow();
        var address = user.getAddresses().get(0);
        user.removeAddress(address);
        userRepository.save(user);
    }
    @Transactional
    public void createCategoryandProduct() {
        var category = Category.builder()
                .name("Electronics")
                .build();

        categoryRepository.save(category);

        var product = Product.builder()
                .name("Camera")
                .description("A small digital camera with high resolution")
                .price(new BigDecimal("99.99"))
                .category(category)
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void createProduct()
    {
        var product = Product.builder()
                .name("Headphones")
                .description("Noise-cancelling over-ear headphones")
                .price(new BigDecimal("199.99"))
                .category(categoryRepository.findById(1L).orElseThrow())
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct()
    {
        productRepository.deleteById(2L);
    }
}
