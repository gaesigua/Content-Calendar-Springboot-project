package com.gasigwatin.Content.Calendar.Springboot.project.controller;

//1. We named this class ContentController as a convention
      // The convention is we take the resource that we are working on, that is "content" and the suffix of "Controller"
      // Most developers use this naming convention

//2. The second step is we will going to mark our class with a RestController annotation and import it
      //this will tell Java to go ahead and create an instance of the controller class behind the scene and stick it into the application context

//3. The next step is we will use the RequestMapping annotation, that gives us a way to give the path for the controller


import com.gasigwatin.Content.Calendar.Springboot.project.model.Content;
import com.gasigwatin.Content.Calendar.Springboot.project.model.Status;
import com.gasigwatin.Content.Calendar.Springboot.project.model.Type;
import com.gasigwatin.Content.Calendar.Springboot.project.repository.ContentCollectionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    //2. Let's create a private Content collection repository
        //basically we are dependent on this class below for our controller to work;
        // in other words, that is a dependency.
        // and we will make this an argument to our constructor and we will call that contentCollectionRepository

    private final ContentCollectionRepository repository;

    //1. Let's create a constructor here

    @Autowired
    public ContentController(ContentCollectionRepository repository){

        //What this will do: we are no longer responsible for creating new instances of our classes
        //We are putting that task on the framework; the framework is going to handle that for us.

        //a. now we will modify this: repository = new ContentCollectionRepository();

        this.repository = repository;
    }

    // Now Let's make a request and find all the pieces of content in the system
    // and how do we do this? first we write a method, that says we want a list of content
    //and how are we going to get all the pieces of content? by using the repository we injected into the controller for us and
    // then use that findAll method; and that will return a list of content

    //and then we will need to make the method available to the outside
    // using a specialized version of the RequestMapping annotation we used earlier, and it is called GetMapping
    //GetMapping says I want to go ahead and handle GetRequest, and we will leave the path empty because we have a RequestMapping already on the class itself,

    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }


}
