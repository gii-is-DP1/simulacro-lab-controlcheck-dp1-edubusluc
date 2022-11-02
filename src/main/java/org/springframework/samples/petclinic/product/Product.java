package org.springframework.samples.petclinic.product;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;


import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    //Podemos evitarnos esto añadiendo que la clase se extienda a baseEntity 
    // @Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// @Column(unique=true, nullable=false, precision=100) //precision -> como de grande permitimos que sea ese entero
	// private long id;

    @Size(min = 3, max = 50)
    @Column(nullable=false)
    @NotNull
    String name;

    @Min(0)
    @Column(nullable=false)
    @NotNull
    double price;

    //Debemos crear una relacion N a 1 UNIDIRECCIONAL Product hacia ProductType
    //lo haremos sobre el atributo productType productType -> como se de size, min... se tratase
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "product_type_id") //sirve para darle nombre a la columna del script
    ProductType productType;

    
}
