/*
 *  Copyright 2015-2016 PaaSword project, http://www.paasword.eu/
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.paasword.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Panagiotis Gouvas (pgouvas@ubitech.eu)
 */
@Entity
public class Inventoryitem {
    @Id
    @GeneratedValue    
    private Long id;
    
    @Column(nullable = false)    
    private String itemname;     

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Inventoryitemtype inventoryitemtype;

    /*
    * Example of not-owning party in Bidirectional-Many-To-Many relationship.
    * Please note that the non-owning party has to declare the "mappedBy" field
    * which should be mapped to the reciprocal attribute which owns the relationship
    * (i.e. Project.inventoryitems in our case)
    */
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="inventoryitems")
    private Set<Project> projects;        
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Inventoryitemtype getInventoryitemtype() {
        return inventoryitemtype;
    }

    public void setInventoryitemtype(Inventoryitemtype inventoryitemtype) {
        this.inventoryitemtype = inventoryitemtype;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }    
    
}
