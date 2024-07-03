package gift;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.getAllProducts();
    }

    @PostMapping("/api/products")
    public void addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") Integer price,
            @RequestParam("imageurl") String imageUrl) {
        productRepository.addProduct(name, price, imageUrl);
    }

    @PatchMapping("/api/products/{id}")
    public Product updateProduct(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("price") Integer price,
            @RequestParam("imageurl") String imageUrl) {
        return productRepository.updateProduct(id, name, price, imageUrl);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteProduct(id);
    }
}
