package ma.emsi.assignementg62;

import ma.emsi.assignementg62.entities.Product;
import ma.emsi.assignementg62.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

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
//        listProd.forEach(p->{
//            System.out.println(p.toString());
//        });
//        List<Product> p1=productRepository.Consulter();
//        for(var e :p1)
//        {
//            System.out.println(e);
//        }
//        System.out.println(productRepository.consulterProd(2));
//
        Optional<Product> produitmis = productRepository.findById(3l);
        produitmis.get().setName("souhail oueld lhkim");
        produitmis.get().setPrice(-50);
        produitmis.get().setQuantity(4000000);
        productRepository.save(produitmis.get());
                List<Product> p1=productRepository.Consulter();
        for(var e :p1)
        {
            System.out.println(e);
        }


    }
}
