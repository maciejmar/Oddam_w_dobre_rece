package pl.coderslab.donation;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.institution.Institution;
import pl.coderslab.institution.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {
    private DonationService donationService;
    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;
    private CategoryRepository categoryRepository;


    public DonationController(DonationRepository donationRepository, DonationService donationService,
                              InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {

        this.donationService = donationService;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;

    }

    public String countQuantities(Model model) {
        List<Donation> donations = donationService.findAll();

        model.addAttribute("donationsBagsCount", donations);
        return "index";
    }

    @GetMapping("/donation")
    public String donationForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donation")
    public String donationForm(@ModelAttribute Donation donation) {
        donationRepository.save(donation);
        return "form-confirmation";
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitution() {

        return institutionRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}


