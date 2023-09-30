package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.repository.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Product addProductToCategory(Integer productId, Integer categoryId)throws ProductException,CategoryException {
		log.debug("Calling findbyId method from ProductJpa Repository");
		Optional<Product> opt= productRepo.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException("No product found");
		}
		Product product=opt.get();
		Optional<Category> cat= categoryRepo.findById(categoryId);
		if(cat.isEmpty())throw new CategoryException("No category found");
		Category category=cat.get();
		product.setCategory(category);
		return productRepo.save(product);
	}
	
	
@Override
public Product addProduct(Product product, Integer categoryId) throws ProductException {
    validateProductNotNull(product);
    logDebug("Calling save method from ProductJpa Repository");
    Category category = getCategoryById(categoryId);
    product.setCategory(category);
    Product savedProduct = saveProduct(product);
    logInfo("Product saved successfully");
    return savedProduct;
}

@Override
public Product updateProduct(int productId, Product product) throws ProductException {
    log.debug("Updating product with ID: " + productId);
    
    Product existingProduct = productRepo.findById(productId)
            .orElseThrow(() -> new ProductException("Product not found!"));

    existingProduct.setCategory(existingProduct.getCategory());
    Product updatedProduct = productRepo.save(product);
    
    log.info("Product updated successfully");
    
    return updatedProduct;
}


@Override
public String cancelProduct(Integer productId) throws ProductException {
    Product product = productRepo.findById(productId)
            .orElseThrow(() -> new ProductException("Product not found!"));

    log.debug("Calling delete method from ProductJpa Repository");
    productRepo.delete(product);
    log.info("Product deleted successfully");
    
    return "Product deleted successfully.";
}

@Override
public List<Product> showAllProduct() throws ProductException {
    List<Product> products = productRepo.findAll();
    
    if (products.isEmpty()) {
        throw new ProductException("No products found!");
    }
    
    return products;
}



@Override
public Product showProductById(Integer productId) throws ProductException {
    log.debug("Calling findbyId method from ProductJpa Repository");
    Product product = productRepo.findById(productId)
            .orElseThrow(() -> new ProductException("Product not found!"));

    log.info("Product found");
    return product;
}






	
	

}
