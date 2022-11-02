package org.springframework.samples.petclinic.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService service;

	private static final String CREATE_OR_EDIT_PRODUCT = "products/createOrUpdateProductForm"; // -> nombre que tomara la screen
    public static final String PRODUCT_LISTING = "/products/listadoProductos";

    @GetMapping() //sirve para crear una vista
    public ModelAndView showAllProducts(){
        ModelAndView results = new ModelAndView(PRODUCT_LISTING); //Creamos una nueva vista llamada RoomLisitng
        //Deberemos pasarle todas las salas que haya creadas a la vista -> lo haremos inyectando al serviico
        results.addObject("products", service.getAllProducts()); //hemos añadido al result los valores que nos devuelve el servicio getRooms
        return results;
    }


    @GetMapping("/create")
    public ModelAndView createProduct(){
        ModelAndView result = new ModelAndView(CREATE_OR_EDIT_PRODUCT);
        result.addObject("product", new Product()); //necesaria para represetar los atributos del producto
        result.addObject("productType", service.findAllProductTypes()); //para representar los tipos de los atributos
        return result;
    }

    @PostMapping("/create")
    public ModelAndView saveCreateProdcut(Product product, BindingResult br){
        ModelAndView results = new ModelAndView(CREATE_OR_EDIT_PRODUCT);
        if(!br.hasErrors()){
            service.save(product);
        }else{
            results.addObject("mensaje", "No se ha podido crear el producto");

        }
        return showAllProducts();
    }
    
}
