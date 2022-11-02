package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "product_type")
public class ProductType extends BaseEntity{

    // @Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// @Column(unique=true, nullable=false, precision=100) //precision -> como de grande permitimos que sea ese entero
	// private long id;

    @Size(min = 3, max = 50)
    @Column(nullable=false, unique = true)
    String name;
}
