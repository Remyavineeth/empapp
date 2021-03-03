package com.archis.empapp.controller;

import com.archis.empapp.dto.Event;
import com.archis.empapp.eventservice.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService service;
    @RequestMapping(method = RequestMethod.GET,value = "/event/{id}")
    public ResponseEntity<Event> getNameByID(@PathVariable("id") Long id){


        return new ResponseEntity<Event>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/event/")
    public ResponseEntity<List<Event>> getEvents(){
return new ResponseEntity<List<Event>>(service.getAll(),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/event/")
    public ResponseEntity <String>create(@RequestBody Event event) {
service.create(event);
        return new ResponseEntity<String>("Account Created",HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/event/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody Event updateEvent) {
      if(service.findById(id)==null){
          return new ResponseEntity<String>("Account Not Found",HttpStatus.NOT_FOUND);

      }else{
          service.update(updateEvent);
return new ResponseEntity<String>("Account Updated successfully",HttpStatus.OK);
      }
    }
   @RequestMapping(method = RequestMethod.DELETE,value = "/event/{id}")
    public Object delete(@PathVariable Long id){
       if(service.findById(id)==null){
           return new ResponseEntity<String>("Account Not Found",HttpStatus.NOT_FOUND);

       }else{
           service.delete(id);
           return new ResponseEntity<String>("Account Deleted successfully",HttpStatus.OK);
       }

    }


}
