/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sakondri.test;

import com.sakondri.dao.GeneralDao;
import com.sakondri.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * /
 **/


public class Test  {
 
   
    public static void main(String[] args){
        Map<String, Object> params = new HashMap<>();
        params.put("id",10l);
        List<Person> persons = new ArrayList<>();
        persons= GeneralDao.getGeneralDao().selectList("Person.selectById", params);
       
       
       
       
        
    }
   
     
     
 
    
}