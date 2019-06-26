package pl.coderslab.donation;

import pl.coderslab.category.Category;
import pl.coderslab.institution.Institution;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer quantity;

    @ManyToMany
    @NotEmpty
    @JoinTable(name="donation_categories")
    private List<Category> categories = new ArrayList<Category>();


    @ManyToOne
    @NotEmpty
    private Institution institution;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    private String ZipCode;
    @NotEmpty
    private LocalDate pickUpDate;
    @NotEmpty
    private LocalTime pickUpTime;
    @NotEmpty
    private String pickUpComment;
}
