package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.dtos.BrandDTO;
import bg.softuni.mobilele.models.dtos.ModelDTO;
import bg.softuni.mobilele.models.entities.BrandEntity;
import bg.softuni.mobilele.models.entities.ModelEntity;
import bg.softuni.mobilele.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        return brandRepository.
                findAll().
                stream().
                map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {
        List<ModelDTO> models = brandEntity.
                getModels().
                stream().
                map(this::mapModel).
                toList();

        return new BrandDTO().
                setModels(models).
                setName(brandEntity.getName());
    }

    private ModelDTO mapModel(ModelEntity model) {

        return new ModelDTO().
                setId(model.getId()).
                setName(model.getName());
    }
}
