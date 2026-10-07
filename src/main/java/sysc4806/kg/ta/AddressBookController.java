package sysc4806.kg.ta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@Controller
public class AddressBookController {
    private final AddressBook book = new AddressBook(Arrays.asList(
            new BuddyInfo("Sam", "1134532"),
            new BuddyInfo("Robin", "1765492"),
            new BuddyInfo("May", "07636282")));

    @GetMapping("/addresses")
    public String getAddresses(@RequestParam(name="name", required=false, defaultValue="Book") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("addresses", book);
//        return new AddressBook();
        return "addresses";
    }
}
