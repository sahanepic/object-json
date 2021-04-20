package com.sahanbcs.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahanbcs.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
public class Serve {

    @GetMapping("/")
    public String hello(){


        Employee employee = new Employee(1, "Lokesh", "Gupta", new Date(1981,8,18));
        ObjectMapper mapper = new ObjectMapper();
        String str ="";
        try
        {
             mapper.writeValue(new File("target/employee.json"), employee);
               str = mapper.writeValueAsString(employee);
               System.out.println(str);
        } catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }




        return "<h1>Hello Sahan  T " + str +" </h1>";
    }


    @GetMapping("/jsontoobject")
    public String hellotoobj(){


        Employee employee ;
//        = new Employee(1, "Lokesh", "Gupta", new Date(1981,8,18));

        String json = "{\"id\":1,\"firstName\":\"Lokesh\",\"lastName\":\"Gupta\"}";
        ObjectMapper mapper = new ObjectMapper();
        String str ="";
        try
        {
//            employee = mapper.readValue(new File("target/employee.json"), Employee.class);
            employee = mapper.readValue(json, Employee.class);
            str =employee.toString();
//                    mapper.writeValueAsString(employee);
            System.out.println(employee.toString());
        } catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }




        return "<h1>Hello Sahan  T " + str +" </h1>";
    }

}
