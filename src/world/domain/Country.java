/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Me
 */
@Entity
public class Country implements Serializable {


    @Id
    private String code;
    

    private String name;
    private String continent;
    private String region;
    private Long population;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "capital")
    private City capital;
    
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities;
    
    
    public Country() {
        
    }
    

    
    public void setCities(List<City> cities) {
        
        this.cities = cities;
    }
    
    public List<City> getCities() {
        
        return this.cities;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" + "code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region + ", population=" + population + ", capital=" + capital + '}';
    }
    


    

    
}
