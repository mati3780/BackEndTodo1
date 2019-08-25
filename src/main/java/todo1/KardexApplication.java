package todo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import todo1.model.Brand;
import todo1.model.Product;
import todo1.repository.BrandRepository;
import todo1.repository.ProductRepository;

@SpringBootApplication
public class KardexApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(KardexApplication.class);

	private static final String VASO = "VASO";
	private static final String CAMISETA = "CAMISETA";
	private static final String COMICS = "COMICS";
	private static final String JUGUETE = "JUGUETE";
	private static final String ACCESORIO = "ACCESORIO";
	
	
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
    private BrandRepository brandRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(KardexApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
        // Insert inicial de products
		insertProducts();
	}



	private void insertProducts() {

		log.info("Inicio carga de products...");

		Brand brandDC = new Brand();
		brandDC.setId(1L);
		brandDC.setDescription("DC Comics");
		brandDC = brandRepository.save(brandDC);

		Brand brandMarvel = new Brand();
		brandMarvel.setId(2L);
		brandMarvel.setDescription("Marvel");
		brandMarvel = brandRepository.save(brandMarvel);

		Brand brandAlternativa = new Brand();
		brandAlternativa.setId(3L);
		brandAlternativa.setDescription("Alternativo");
		brandAlternativa = brandRepository.save(brandAlternativa);

		Product productVasoDC = new Product();
		productVasoDC.setCode(1L);
		productVasoDC.setBrand(brandDC);
		productVasoDC.setDescription(VASO);
		productRepository.save(productVasoDC);

		Product productCamisetaDC = new Product();
		productCamisetaDC.setCode(2L);
		productCamisetaDC.setBrand(brandDC);
		productCamisetaDC.setDescription(CAMISETA);
		productRepository.save(productCamisetaDC);

		Product productComicsDC = new Product();
		productComicsDC.setCode(3L);
		productComicsDC.setBrand(brandDC);
		productComicsDC.setDescription(COMICS);
		productRepository.save(productComicsDC);

		Product productJugueteDC = new Product();
		productJugueteDC.setCode(4L);
		productJugueteDC.setBrand(brandDC);
		productJugueteDC.setDescription(JUGUETE);
		productRepository.save(productJugueteDC);

		Product productAccesorioDC = new Product();
		productAccesorioDC.setCode(5L);
		productAccesorioDC.setBrand(brandDC);
		productAccesorioDC.setDescription(ACCESORIO);
		productRepository.save(productAccesorioDC);

		Product productVasoMarvel = new Product();
		productVasoMarvel.setCode(6L);
		productVasoMarvel.setBrand(brandMarvel);
		productVasoMarvel.setDescription(VASO);
		productRepository.save(productVasoMarvel);

		Product productCamisetaMarvel = new Product();
		productCamisetaMarvel.setCode(7L);
		productCamisetaMarvel.setBrand(brandMarvel);
		productCamisetaMarvel.setDescription(CAMISETA);
		productRepository.save(productCamisetaMarvel);

		Product productComicsMarvel = new Product();
		productComicsMarvel.setCode(8L);
		productComicsMarvel.setBrand(brandMarvel);
		productComicsMarvel.setDescription(COMICS);
		productRepository.save(productComicsMarvel);

		Product productJugueteMarvel = new Product();
		productJugueteMarvel.setCode(9L);
		productJugueteMarvel.setBrand(brandMarvel);
		productJugueteMarvel.setDescription(JUGUETE);
		productRepository.save(productJugueteMarvel);

		Product productAccesorioMarvel = new Product();
		productAccesorioMarvel.setCode(10L);
		productAccesorioMarvel.setBrand(brandMarvel);
		productAccesorioMarvel.setDescription(ACCESORIO);
		productRepository.save(productAccesorioMarvel);

		Product productVasoAlt = new Product();
		productVasoAlt.setCode(11L);
		productVasoAlt.setBrand(brandAlternativa);
		productVasoAlt.setDescription(VASO);
		productRepository.save(productVasoAlt);

		Product productCamisetaAlt = new Product();
		productCamisetaAlt.setCode(12L);
		productCamisetaAlt.setBrand(brandAlternativa);
		productCamisetaAlt.setDescription(CAMISETA);
		productRepository.save(productCamisetaAlt);

		Product productComicsAlt = new Product();
		productComicsAlt.setCode(13L);
		productComicsAlt.setBrand(brandAlternativa);
		productComicsAlt.setDescription(COMICS);
		productRepository.save(productComicsAlt);

		Product productJugueteAlt = new Product();
		productJugueteAlt.setCode(14L);
		productJugueteAlt.setBrand(brandAlternativa);
		productJugueteAlt.setDescription(JUGUETE);
		productRepository.save(productJugueteAlt);

		Product productAccesorioAlt = new Product();
		productAccesorioAlt.setCode(15L);
		productAccesorioAlt.setBrand(brandAlternativa);
		productAccesorioAlt.setDescription(ACCESORIO);
		productRepository.save(productAccesorioAlt);

		log.info("Fin de carga de product...");
	}

}
