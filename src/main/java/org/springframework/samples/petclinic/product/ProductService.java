package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private ProductRepository productRepo;

    @Autowired 
    public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;

	}
    //debemos obtener una lista con todos los productos
    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getProductsCheaperThan(double price) {
        return productRepo.findByPriceLessThan(price);
    }

    @Transactional(readOnly = true)
    public ProductType getProductType(String name) {
        return productRepo.findProductType(name);
    }

    @Transactional
	public void save(Product product) {
		productRepo.save(product);
	}

    @Transactional(readOnly = true)
    public Object findAllProductTypes() {
        return productRepo.findAllProductTypes();
    }




    
}
