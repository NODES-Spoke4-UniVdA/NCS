package com.example.nodes.controller;

import com.example.nodes.entity.District;
import com.example.nodes.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/district/add")
    public String showAddDistrictForm(Model model) {
        model.addAttribute("district", new District());
        model.addAttribute("hubs", districtService.findAllHubs());
        model.addAttribute("districts", districtService.findAllDistricts());
        return "add-district";
    }

    @PostMapping("/district/add")
    public String addDistrict(@ModelAttribute District district, Model model) {
        districtService.saveDistrict(district);
        model.addAttribute("success", "District added successfully!");
        return "redirect:/district/add";
    }

    @GetMapping("/district/toggle-active/{id}")
    public String toggleDistrictActive(@PathVariable Long id) {
        districtService.toggleDistrictActive(id);
        return "redirect:/district/add";
    }
}