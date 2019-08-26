package todo1.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo1.dto.ProductDTO;
import todo1.exceptions.ProductNotFoundException;
import todo1.model.Product;
import todo1.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<ProductDTO> getAll() {
		List<Product> productList = productRepository.findAll();
		List<ProductDTO> productDTOList = new ArrayList<>();

		for (Product product:productList) {
			ProductDTO productDTO = new ProductDTO();
			modelMapper.map(product, productDTO);

			productDTOList.add(productDTO);
		}
		
		return productDTOList;
	}

	/**
	 * @param id identificador del Product
	 * @throws Exception Cuando no encuentra el producto.
	 */
	public ProductDTO getById(long id) {
		Product product = productRepository.findById(id)
							.orElseThrow(() -> new ProductNotFoundException(id));
		ProductDTO productDTO = new ProductDTO();
		modelMapper.map(product, productDTO);

		return productDTO;
	}
	
}
