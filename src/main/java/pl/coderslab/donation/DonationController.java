package pl.coderslab.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.institution.Institution;
import pl.coderslab.institution.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("index")
public class DonationController {
   private DonationService donationService;
   public int donationsBagsCount = 0;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService= donationService;
    }
    public String countQuantities(Model model) {
        List<Donation> donations = donationService.findAll();


        model.addAttribute("donationsBagsCount", donationsBagsCount);
            return "index";
        }
}


