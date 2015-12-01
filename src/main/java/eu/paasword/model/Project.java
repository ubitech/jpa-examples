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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Panagiotis Gouvas (pgouvas@ubitech.eu)
 */
@Entity
public class Project {
    
    @Id
    @GeneratedValue    
    private Long id;
    
    @Column(nullable = false)    
    private String name;    
    
    /*
    * Example of Unidirectional-Many-To-Many relationship
    *----------------------------------------------------
    * The following is an example of a Many to Many relationship between <Project> entity and <User> entity.
    * If the <User> entity DOES NOT CONTAIN a reciprocal a @ManyToMany annotation then the relationship is addressed as 
    * Unidirectional-Many-To-Many owned by <Project> entity
    * If the <User> entity contains one; then the relationship is addressed as Bidirectional-Many-To-Many owned by <Project> entity
    */    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="project_user", joinColumns=@JoinColumn(name="projectid"), inverseJoinColumns=@JoinColumn(name="userid"))  
    private Set<User> users;    

    
    /*
    * Example of Bidirectional-Many-To-Many relationship
    *----------------------------------------------------
    * The following is an example of a Many to Many relationship between <Project> entity and <Inventoryitem> entity.
    * The difference with the previous example is that the <Inventoryitem> entity also contains ManyToMany annotation.
    * This way the Inventoryitem can also traverse the relationship
    */    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="project_inventoryitem", joinColumns=@JoinColumn(name="projectid"), inverseJoinColumns=@JoinColumn(name="inventoryitemid"))  
    private Set<Inventoryitem> inventoryitems;       
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }   
    
}
