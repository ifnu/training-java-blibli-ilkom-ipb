/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ifnu.b.fatkhan
 */
@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @Column(name="ID")
    private Integer id;
    
    @Column(name="TITLE", nullable = false, length = 200)
    private String title;
    
    @Column(name="PRICE", nullable = false)
    private BigDecimal price;
    
    @Column(name="DESCRIPTION", nullable = false)
    private String description;
    
    @Column(name="SPECIFICATION", nullable = false)
    private String specification;
    
    @Column(name="RELATED_INFORMATION", nullable = false)
    private String relatedInformation;
    
    @Column(name="IMAGE_URL", nullable = false)
    private String imageUrl;

    //membuat url product, misalnya : 
    //http://localhost:8080/training-java/apple-macbook-pro-md101-silver-notebook-1718262
    //apple-macbook-pro-md101-silver-notebook => title.toLowerCase then replace all space with -
    //1718262 => product id
    public String getProductUrl(){
        String url = getTitle().toLowerCase().replaceAll(" ", "-") 
                + "-" + id;
        return url;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getRelatedInformation() {
        return relatedInformation;
    }

    public void setRelatedInformation(String relatedInformation) {
        this.relatedInformation = relatedInformation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
}
