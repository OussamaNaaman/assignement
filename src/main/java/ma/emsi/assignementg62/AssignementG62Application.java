package ma.emsi.assignementg62;

import ma.emsi.assignementg62.entities.Product;
import ma.emsi.assignementg62.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication

public class AssignementG62Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssignementG62Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"yassine",20,50));
        productRepository.save(new Product(null,"adam",0,50000));
        productRepository.save(new Product(null,"oussama",2000000000,1));
        List<Product> listProd=productRepository.findAll();
        listProd.forEach(p->{
            System.out.println(p.toString());
        });

    }
}
