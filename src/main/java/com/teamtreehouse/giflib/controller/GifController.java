package com.teamtreehouse.giflib.controller;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class GifController {

//curl -i -X GET localhost:8080/hello
//curl -i -X GET localhost:8080/gif{"id":"1"}
    @GetMapping("/hello")
    public String getHello(){
        return "HIIIII!!!";
    }

    @RequestMapping("/")
    public String listGifs(){
        return "home";
    }
    @RequestMapping("/test2")
    @ResponseBody
    public String listGifs2(){
        return "Test2";
    }

    @RequestMapping("/gif{id}")
    public String gifDet(@PathVariable String id){
/*        Gif gif=new Gif("bot", LocalDate.of(2015,2,13),
                "pedro",true);
        modelMap.put("gif",gif);*/
        String _id=id;
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://t1:t1@cluster0-e7a1k.mongodb.net/test?retryWrites=true");

        MongoClient mongoClient =  new MongoClient(uri);

        MongoDatabase database = mongoClient.getDatabase("MicroDB1");
        MongoCollection mocal = database.getCollection("MicroCollection1");
        //FindIterable<mongoDoc> tt= mocal.find("ii":_id);


        return mocal.find().first().toString();
    }
}