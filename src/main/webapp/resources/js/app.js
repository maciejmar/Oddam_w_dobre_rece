document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // TODO: get data from inputs and show them in summary
        }

    }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
//bag elements

    var bagsNumber = ""
    var bagInput = $("#bagInput")
    var bagSummary = $("#bagSummary")
    var bag_btn = $(#bag - btn)
//values
    var institution = ""
    var street = ""
    var city = ""
    var zipCode = ""
    var phoneNumber = ""
    var date = ""
    var time = ""
    var comment = ""
    //inputs
    var categoriesInput = $(".catInput")
    var institutionInput = $(".instInput")
    var streetInput = $(#streetInput)
    //buttons
    var cat_btn = $("#cat-btn")

    var catNames = $(".cat-name")
    var institutionName = $("#instituionName")
//summary
    var instSum = $("#instSum")
    var citySum
    var streetSum = $("#streetSum")
    var phone

    bagInput.on("change", function () {
        bagsNumber = "Oddałeś " + bagInput.val() + " worków" + "<br>"
        console.log(bagInput.val());
        console.log(bagsNumber)

    });


    categoriesInput.on("click", function () {
        for (var i = 0; i < categoriesInput.length; i++) {
            if (categoriesInput[i].checked == 1) {
                console.log(catNames[i].innerText)
            } else {
                console.log(i + "unchecked")
            }
        }
    });

    cat_btn.on("click", function () {
        bagSummary.html("Rodzaje darowizny: <br>")
        for (var i = 0; i < categoriesInput.length; i++) {
            if (categoriesInput[i].checked) {
                bagSummary.append(catNames[i].innerText + "<br>")
            }
        }

    })

    bag_btn.on("click", function () {
        bagSummary.prepend(bagsNumber)
    })

    inst_input.on("click", function () {
        for (var i = 0; i < instInput.length; i++) {
            if (instInput[i].checked) {
                institution = institutionName[i].innerText
                console.log(institution)
                inst_sum.html("Dla fundacji " + institution)
            }
        }
    })
    street_input.on("change", function () {
        console.log("test")
        street = streetInput.val()
        street_sum.html(street)
        console.log(street)
    })

    $("#cityInput").on("change", function () {
        city = $("#cityInput").val()
        $("#citySum").html(city)
        console.log(city)
    })

    $("#zipCodeInput").on("change", function () {
        zipCode = $("#zipCodeInput").val()
        $("#zipCodeSum").html(zipCode)
        console.log(zipCode)
    })

    $("#phoneNumberInput").on("change", function () {
        phone = $("#phoneNumberInput").val()
        $("#phoneNumberSum").html(phoneNumber)
        console.log(phoneNumber)
    })


    $("#dateInput").on("change", function () {
        date = $("#dateInput").val()
        $("#dateSum").html(date)
        console.log(date)
    })

    $("#timeInput").on("change", function () {
        time = $("#timeInput").val()
        $("#timeSum").html(time)
        console.log(time)
    })

    $("#commentInput").on("change", function () {
        if ($("#commentInput").val() == "") {
            $("#commentSum").html("Brak uwag")
            console.log("Brak uwag")
        } else {
            comment = $("#commentInput").val()
            $("#commentSum").html(comment)
            console.log(comment)
        }
    })

});