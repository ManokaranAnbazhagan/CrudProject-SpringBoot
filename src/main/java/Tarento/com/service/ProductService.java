package Tarento.com.service;

import Tarento.com.Entity.Product.Product;
import Tarento.com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }


    public List<Product> saveProduct(List<Product> products) {
        return repository.saveAll(products);//This two are the post methods
    }
    public List<Product> getProducts(){
        return repository.findAll();
    }
    //if we want single product values then do this we get only one values
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);//this will return null or same values

    }
    public Product getProductByName(String name){
        return repository.findByName(name);
}
    public String deleteProduct(int id){
repository.deleteById(id);
return "product remove ! !"+id;
}
public Product updateProduct(Product product){
Product existingProduct=repository.findById(product.getId()).orElse(null);
existingProduct.setName(product.getName());
existingProduct.setQuantity(product.getQuantity());
existingProduct.setPrice(product.getPrice());
return repository.save(existingProduct);
}
}





