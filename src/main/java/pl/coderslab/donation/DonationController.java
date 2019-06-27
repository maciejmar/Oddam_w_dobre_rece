package pl.coderslab.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.institution.Institution;
import pl.coderslab.institution.InstitutionRepository;
import pl.coderslab.institution.InstitutionService;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("index")
public class DonationController {
   private DonationService donationService;
   private DonationRepository donationRepository;
   private InstitutionRepository institutionRepository;
   private CategoryRepository categoryRepository;
   public int donationsBagsCount = 0;

    @Autowired
    public DonationController(DonationService donationService) {

        this.donationService = donationService;
        this.donationRepository = donationRepository;

    }
    public String countQuantities(Model model) {
        List<Donation> donations = donationService.findAll();


        model.addAttribute("donationsBagsCount", donationsBagsCount);
            return "index";
        }

        @GetMapping("/donation")
    public String donationForm (Model model){
        model.addAttribute("donation", new Donation ());
        return "form";
        }
        @PostMapping ("/donation")
    public String donationForm (@ModelAttribute Donation donation){
        donationRepository.save(donation);
        return "form-confirmation";
        }

        @ModelAttribute ("institutions")
    public List<Institution> getInstitution(){

        return institutionRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}


