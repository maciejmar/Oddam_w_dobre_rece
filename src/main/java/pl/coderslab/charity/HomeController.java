package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.donation.DonationRepository;
import pl.coderslab.institution.InstitutionRepository;


@Controller
public class HomeController {


    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;


    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository,
                          CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;

    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("donationsBagsCount", donationRepository.getNumberOfBags());
        model.addAttribute("donationsCount", institutionRepository.getNumberOfInstitutions());
        return "index";
    }
}