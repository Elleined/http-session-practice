package com.httpsessionpractice.HTTP.Session.Practice.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/http-session")
public class HttpSessionController {

    @GetMapping
    public String goToHttpSessionPage(HttpSession session,
                                      Model model) {

        // Read value in session
        String sessionName = (String) session.getAttribute("name");
        System.out.println("Reading the session name is " + sessionName);

        model.addAttribute("name", sessionName);
        return "http-session";
    }

    @PostMapping("/save-value-to-session")
    public String saveValueToSession(@RequestParam String name,
                            HttpSession session) {

        // Save Value in session
        session.setAttribute("name", name);
        return "redirect:/http-session";
    }

    @GetMapping("/invalidate-session")
    public String invalidateSession(HttpSession session) {
        String validSessionName = (String) session.getAttribute("name");
        System.out.println("Before invalidating the session name is " + validSessionName);

        // Invalidate the session
        session.invalidate();

        // This will throw an exception means session is invalidated
        String invalidSessionName = (String) session.getAttribute("name");
        System.out.println("After invalidating the session name is " + invalidSessionName);

        return "redirect:/http-session";
    }

    @GetMapping("/remove-session-attribute")
    public String removeSessionAttribute(HttpSession session) {
        String unRemovedAttribute = (String) session.getAttribute("name");
        System.out.println("Before removing the session name is " + unRemovedAttribute);

        // Removing session attribute
        session.removeAttribute("name");

        String removedSessionAttribute = (String) session.getAttribute("name");
        System.out.println("Before invalidating the session name is " + removedSessionAttribute);

        return "redirect:/http-session";
    }
}
