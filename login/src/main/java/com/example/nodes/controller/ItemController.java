package com.example.nodes.controller;

import com.example.nodes.entity.Item;
import com.example.nodes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    /*@GetMapping("/calendar")
    public String getCalendar(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "calendar";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Item> events = itemService.getAllEvents();
        model.addAttribute("events", events);
        return "calendar";
    }

     */

    @PostMapping("/addEvent")
    public String addEvent(@RequestParam String title, @RequestParam LocalDate date) {
        Item event = new Item();
        event.setTitle(title);
        //event.setDate(date);
        itemService.saveEvent(event);
        return "redirect:/";
    }

    @PostMapping("/deleteEvent")
    public String deleteEvent(@RequestParam Long id) {
        itemService.deleteEvent(id);
        return "redirect:/";
    }
}
