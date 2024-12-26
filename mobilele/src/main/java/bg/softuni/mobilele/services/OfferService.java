package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.dtos.AddOfferDTO;
import bg.softuni.mobilele.models.entities.ModelEntity;
import bg.softuni.mobilele.models.entities.OfferEntity;
import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.users.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelRepository modelRepository;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, CurrentUser currentUser, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }

    public void addOffer(AddOfferDTO dto) {
        OfferEntity newOffer = new OfferEntity();

        newOffer.setEngine(dto.getEngine());
        newOffer.setTransmission(dto.getTransmission());
        newOffer.setImageUrl(dto.getImageUrl());
        newOffer.setPrice(dto.getPrice());
        newOffer.setYear(dto.getYear());
        newOffer.setMileage(dto.getYear());
        newOffer.setMileage(dto.getMileage());

        Optional<UserEntity> optionalUser = userRepository.findByEmail(currentUser.getEmail());
        Optional<ModelEntity> optionalModel = modelRepository.findById(dto.getModelId());

        newOffer.setModel(optionalModel.get());
        newOffer.setSeller(optionalUser.get());

        this.offerRepository.save(newOffer);
    }
}
