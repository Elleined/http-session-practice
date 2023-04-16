package com.httpsessionpractice.HTTP.Session.Practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"receiver", "message"})
@RequestMapping("/session-attribute")
public class SessionAttributeController {

    @GetMapping
    public String goToSessionAttribute(Model model) {

        // Reading session attribute with the help @SessionAttribute
        // You dont need to explicitly add these to model it will be added automatically to be used in view
        String receiver = (String) model.getAttribute("receiver");
        String message = (String) model.getAttribute("message");

        System.out.println("Receiver in get mapping " + receiver);
        System.out.println("Message in get mapping " + message);

        return "session-attribute";
    }

    @PostMapping("/save-session-attribute")
    public String saveSessionAttribute(@RequestParam String receiver,
                                       @RequestParam String message,
                                       Model model) {

        System.out.println("Receiver in post mapping: " + receiver);
        System.out.println("Message in post mapping" + message);

        // Saving session attribute with the help @SessionAttribute
        model.addAttribute("receiver", receiver);
        model.addAttribute("message", message);
        return "redirect:/session-attribute";
    }

}
