package Tarento.com.Controller;

import Tarento.com.Entity.Product.Product;
import Tarento.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);

    }
    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return service.saveProduct(products);

    }
    @GetMapping("/products")
    public  List<Product>findProducts(){
    return service.getProducts();


    }
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
    return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);//last 3 is get Api
    }
    @PostMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
