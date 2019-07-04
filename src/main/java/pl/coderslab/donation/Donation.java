package pl.coderslab.donation;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.category.Category;
import pl.coderslab.institution.Institution;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



    @Entity
    public class Donation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        private Long quantity;
        @ManyToMany
        @NotEmpty
        @JoinTable(name = "donation_categories")
        private List<Category> categories = new ArrayList<>();
        @NotNull
        @ManyToOne
        private Institution institution;
        @NotNull
        private String street;
        @NotNull
        private String city;
        @NotNull
        private String zipCode;
        @NotNull
        private String phoneNumber;
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate pickUpDate;
        @NotNull
        @DateTimeFormat(pattern = "HH:mm")
        private LocalTime pickUpTime;
        @NotNull
        private String pickUpComment;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getQuantity() {
            return quantity;
        }

        public void setQuantity(Long quantity) {
            this.quantity = quantity;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public Institution getInstitution() {
            return institution;
        }

        public void setInstitution(Institution institution) {
            this.institution = institution;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public LocalDate getPickUpDate() {
            return pickUpDate;
        }

        public void setPickUpDate(LocalDate pickUpDate) {
            this.pickUpDate = pickUpDate;
        }

        public LocalTime getPickUpTime() {
            return pickUpTime;
        }

        public void setPickUpTime(LocalTime pickUpTime) {
            this.pickUpTime = pickUpTime;
        }

        public String getPickUpComment() {
            return pickUpComment;
        }

        public void setPickUpComment(String pickUpComment) {
            this.pickUpComment = pickUpComment;
        }

    }
