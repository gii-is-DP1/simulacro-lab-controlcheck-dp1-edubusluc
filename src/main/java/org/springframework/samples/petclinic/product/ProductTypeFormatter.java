package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    //el formatter debe mostrar los productos usando la cadena de su nombre, y debe obtener un tipo de producto dado su nombre buscándolo en la BD. Si no se puede formatear debe lanzar una execpcion.

    @Autowired
    private ProductService ps;

    @Override
    public String print(ProductType object, Locale locale) {
        String nombre = object.getName();
        return nombre;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType p = this.ps.getProductType(text);
        if(p == null){
            throw new ParseException(text, 0);
        }else{
            return p;
        }
    }
    
}
