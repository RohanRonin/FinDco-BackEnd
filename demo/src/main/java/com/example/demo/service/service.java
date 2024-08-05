package com.example.demo.service;

import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.entity.EventsDetails;
import com.example.demo.entity.NewsDetails;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface service {
    List<User> getAllDetails();

    User postAllDetails(AuthenticationDTO user);
    User findByEmail(String mail);
    List<NewsDetails> getAllNews();

    NewsDetails getNewsById(int id);

    NewsDetails createNews(NewsDetails newsDetails);
    List<EventsDetails> getAllEvents();

    EventsDetails getEventById(int id);

    EventsDetails createEvent(EventsDetails eventDetails);
}