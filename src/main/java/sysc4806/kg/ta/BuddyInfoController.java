package sysc4806.kg.ta;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BuddyInfoController {

    @GetMapping("/buddyInfoes")
    public String getBuddy(@RequestParam(name="name", required=false, defaultValue="Buddy") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("buddy", new BuddyInfo("Karina", "1234567"));
        return "buddy";
    }
}
