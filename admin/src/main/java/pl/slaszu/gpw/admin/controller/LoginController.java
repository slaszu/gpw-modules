package pl.slaszu.gpw.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
public class LoginController {

    @Autowired
    private InMemoryClientRegistrationRepository inMemoryClientRegistrationRepository;

    @GetMapping("/login_oauth")
    public String loginOauthAction(Model model) {
        HashMap<String, String> oauthLinks = new HashMap<>();


        this.inMemoryClientRegistrationRepository.forEach(clientRegistration -> {
            oauthLinks.put(
                clientRegistration.getClientName(),
                OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI.concat("/").concat(
                    clientRegistration.getClientName().toLowerCase()
                )
            );
        });

        model.addAttribute("date", LocalDateTime.now().toString());
        model.addAttribute("oauthLinks", oauthLinks);
        return "login_oauth";
    }
}
