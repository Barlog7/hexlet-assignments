package exercise.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Setter
@Getter
public class GuestCreateDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Size(min = 11, max = 13)
    @Pattern(regexp = "^[+][0-9]*")
    private String phoneNumber;
    @NotBlank
    @Size(min = 4, max = 4)
    private String clubCard;

    @FutureOrPresent
    private LocalDate cardValidUntil;
}
// END
