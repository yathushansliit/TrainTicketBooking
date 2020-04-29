package com.yathushan.mailservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class MailServiceController {
    @Autowired
    CampingItemService campingItemService;

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public CampingItem save(@RequestBody CampingItem campingItem){
        return campingItemService.addItem(campingItem);
    }

    @RequestMapping(value = "fetchCampingItem/{id}")
    public CampingItem fetch(@PathVariable int id) {
        return campingItemService.findItem(id);
    }

    @RequestMapping(value = "/fetchAllItems", method = RequestMethod.GET)
    public List<CampingItem> fetchAllItems(){
        return campingItemService.fetchAllItems();
    }


}
