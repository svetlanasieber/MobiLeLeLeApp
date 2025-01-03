package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.models.entities.BaseEntity;
import bg.softuni.mobilele.models.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
