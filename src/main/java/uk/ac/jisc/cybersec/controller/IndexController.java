
package uk.ac.jisc.cybersec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.jisc.cybersec.secure.CustomUserDetails;

@Controller
class IndexController {
    
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String index(Model model, Authentication user) {
        if (user.getPrincipal() instanceof CustomUserDetails) {
            var userDetails = (CustomUserDetails) user.getPrincipal();
            log.debug("Logged in user has id '{}'", userDetails.getUser().getId());
            model.addAttribute("userId",userDetails.getUser().getId());
        }
        return "home";
    }
}
