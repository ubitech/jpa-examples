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
package eu.paasword.dao;

import eu.paasword.model.Project;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Panagiotis Gouvas (pgouvas@ubitech.eu)
 */
@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Long> {
    /*
    * First we will add methods that generate automatically queries based on reflection
    * See: http://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/jpa.repositories.html 
    * for more details
    */
    List<Project> findByName(String projectname);
    
    List<Project> findByNameLike(String projectname);    
    
    List<Project> findByNameLikeOrderByBudgetDesc(String projectname);     
    
    List<Project> findByNameAndBudget(String projectname,int budget);    
    
    List<Project> findByBudgetGreaterThan(int budget);
    
    List<Project> findByBudgetLessThan(int budget);    
    
    List<Project> findByBudgetIsNull();     
    
    List<Project> findByIsfinishedTrue();     
    
    List<Project> findByIsfinished(boolean isfinished);       

    List<Project> findByStartdateBefore(Date date);       

    List<Project> findByStartdateAfterAndIsfinishedFalseAndBudgetLessThan(Date date, int budget);      
    
    /*
    * Now we will continue with NamedQueries in order to perform queries that
    */
    
    @Query("select p from Project p INNER JOIN p.users u where u.id =?1 ")
    List<Project> findProjectsWhereASpecificUserIsInvolved(Long userid);

    @Query("select p from Project p INNER JOIN p.users u where u.usertype.id =?1 ")
    List<Project> findProjectsWhereASpecificUserTypeIsInvolved(Long usertypeid);    
    
    @Query("select DISTINCT(p) from Project p INNER JOIN p.users u where u.usertype.id =?1 ")
    List<Project> findDistinctProjectsWhereASpecificUserTypeIsInvolved(Long usertypeid);    
    
}//EoI
