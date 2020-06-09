package com.franco.Capstone.controllers;


import com.franco.Capstone.models.User;
import com.franco.Capstone.models.Vehicle;
import com.franco.Capstone.models.data.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping
    public String index(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("username", user.getUsername());
        return "index";
    }

    @GetMapping("add")
    public String displayAddVehiclesForm(Model model) {
        model.addAttribute(new Vehicle());
        return "add";
    }

    @PostMapping("add")
    public String processAddVehiclesForm(@ModelAttribute @Valid Vehicle newVehicle,
                                         Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        Vehicle save = vehicleRepository.save(newVehicle);
        return "redirect:";
    }

    @GetMapping("view/{vehicleId}")
    public String displayViewVehicle(Model model, @PathVariable int vehicleId) {

        Optional optVehicle = vehicleRepository.findById(vehicleId);
        if (!optVehicle.isEmpty()) {
            Vehicle vehicle = (Vehicle) optVehicle.get();
            model.addAttribute("vehicle", vehicle);
            return "view";
        } else {
            return "redirect:/";
        }
    }
}

