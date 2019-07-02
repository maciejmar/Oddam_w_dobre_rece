package pl.coderslab.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
    @Transactional
    public class DonationService {

        private DonationRepository donationRepository;

        @Autowired
        public DonationService(DonationRepository donationRepository) {
            this.donationRepository = donationRepository;
        }

        public List<Donation> findAll() {
            return donationRepository.findAll();
        }

    }

