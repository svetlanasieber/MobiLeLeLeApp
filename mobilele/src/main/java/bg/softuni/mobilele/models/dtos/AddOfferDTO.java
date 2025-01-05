package bg.softuni.mobilele.models.dtos;


import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class AddOfferDTO {

    @NotNull
    @Positive
    private Long modelId;

    @NotNull
    private EngineEnum engine;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Min(1900)
    private Integer year;

    @NotNull
    private String description;

    @NotNull
    private TransmissionEnum transmission;

    private int mileage;

    @NotEmpty
    private String imageUrl;

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
