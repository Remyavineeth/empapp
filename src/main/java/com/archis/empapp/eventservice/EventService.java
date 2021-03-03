package com.archis.empapp.eventservice;

import com.archis.empapp.dto.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventService {
    Map<Long, Event> database=new HashMap<>();
    public Event findById(Long id){
        return database.get(id);
    }
    public List<Event> getAll(){
        return new ArrayList<>(database.values());
    }

    public void create(Event event){
        database.put(event.getEvent_id(),event);
    }
    public void update (Event updateEvent){
        Event eventToBeUpdated=database.get(updateEvent.getEvent_id());
        eventToBeUpdated.setEvent_name(updateEvent.getEvent_name());
        eventToBeUpdated.setEvent_description(updateEvent.getEvent_description());
    }
    public void delete (Long id){
        database.remove(id);
    }
}
