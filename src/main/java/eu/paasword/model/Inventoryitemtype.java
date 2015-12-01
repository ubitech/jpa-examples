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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Panagiotis Gouvas (pgouvas@ubitech.eu)
 */
@Entity
public class Inventoryitemtype {

    @Id
    @GeneratedValue    
    private Long id;
    
    @Column(nullable = false)
    private String itemtypename;      
    
    /*
    * Example of One-To-Many relationship
    *-------------------------------------
    * In each One-to-Many usage there is one foreign key that is declared by the other part (i.e. the Many part)
    * In this type of relationship it is crucial to provide the "mappedBy" field which is the variable-name of the 
    * reciprocal relationship (i.e. Inventoryitem.inventoryitemtype in our case).
    * Please note that OneToMany relationship are too 'expensive' since they initialize a set in memory.
    * Therefore they MUST BE DECLARED ALWAYS Lazy unless there is a critical reason that impose eager fetches
    */
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "inventoryitemtype")
    private Set<Inventoryitem> inventoryitems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemtypename() {
        return itemtypename;
    }

    public void setItemtypename(String itemtypename) {
        this.itemtypename = itemtypename;
    }

    public Set<Inventoryitem> getInventoryitems() {
        return inventoryitems;
    }

    public void setInventoryitems(Set<Inventoryitem> inventoryitems) {
        this.inventoryitems = inventoryitems;
    }       
    
}
