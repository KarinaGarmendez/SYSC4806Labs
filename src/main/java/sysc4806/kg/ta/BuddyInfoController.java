package sysc4806.kg.ta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuddyInfoController {

    @GetMapping("/buddy")
    public String getBuddy(@RequestParam(name="name", required=false, defaultValue="Buddy") String name, Model model) {
        model.addAttribute("name", name);
        return "buddy";
    }
}
