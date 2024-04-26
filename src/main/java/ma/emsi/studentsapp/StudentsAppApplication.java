package ma.emsi.studentsapp;

import ma.emsi.studentsapp.entities.Product;
import ma.emsi.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args)  {

        SpringApplication.run(StudentsAppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"Computer",6000.0,2));
        //productRepository.save(new Product(null,"Printer",3000.0,4));
        //productRepository.save(new Product(null,"smartphone",2000.0,23));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.printf("**********\n");
        System.out.println(product.getId());
        System.out.printf(product.getName());
        System.out.printf(String.valueOf(product.getQuantity()));
        System.out.printf("\n************");
        System.out.println("--------------");
        List<Product> productList = productRepository.findByNameContains("a");
        productList.forEach(p-> {
            System.out.println(p);

        });


        System.out.println("----------------");
        List<Product> productList3 = productRepository.searchByPrice(2500);
        productList3.forEach(p-> {
            System.out.println(p);
        });

       /*System.out.println("----------------");
        List<Product> productList4 = productRepository.deleteProductById(21L);
        productList4.forEach(p-> {
            System.out.println(p);
        });*/


    }
}
