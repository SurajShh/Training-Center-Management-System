package com.suraj.TrainingCenterRegistry.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "training_centers")
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center Name is required")
    @Size(max = 40, message = "Center Name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center Code is required")
    @Size(min = 12, max = 12, message = "Center Code must be exactly 12 characters")
    @Column(unique=true)
    private String centerCode;

    @NotBlank(message = "Contact Phone is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    @Column(unique=true)
    private String contactPhone;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdOn;

    @Email
    @Column(unique=true)
    private String contactEmail;

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

}


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class Address {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}

