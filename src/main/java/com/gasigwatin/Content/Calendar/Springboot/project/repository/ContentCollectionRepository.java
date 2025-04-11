package com.gasigwatin.Content.Calendar.Springboot.project.repository;
import com.gasigwatin.Content.Calendar.Springboot.project.model.Content;
import com.gasigwatin.Content.Calendar.Springboot.project.model.Status;
import com.gasigwatin.Content.Calendar.Springboot.project.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//1. Here we are creating this class, we are not talking to a database yet,
     //we are just keeping a collection of pieces of content in-memory, so that we can work with them in our application

//2. And to be able to do that we will first create a List of Content (that is final and )

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();


//3. Here we are creating a constructor

    public ContentCollectionRepository() {
    }

//4. Here we are creating a couple methods

    //the first method is to list our content; basically it will return content.

    public List<Content> findAll(){
        return contentList;

    }

    //the second method is to find a way to get a single piece of content;
    //the method will return an Optional; this is just way to avoid dealing with null values
    //it is basically what a spring data repository looks like
    //we are going to take in an integer id, because our content has an id,
    // and when we are looking for a particular content, we will ask for it by its ID.
    //Here we are going to get that array list of content, by filtering using the id of the content,
    // and check if it equals the ID that was just passed in, and if yes,
    // go ahead and find that first and that returns an optional of type T.

    public Optional<Content> findByid(Integer id){

        return contentList.stream().filter(c->c.id().equals(id)).findFirst();

    }

    public void save(Content content){
        contentList.removeIf(c-> c.id().equals(content.id()));
        contentList.add(content);

    }

    @PostConstruct
    public void init() {

        Content content = new Content(
                1,
                "Meine erste Artikel",
                "Mein Beste Freunde",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);

    }

    public boolean existsById(Integer id){
        return contentList.stream().filter(c->c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        contentList.removeIf(c->c.id().equals(id));

    }


}
