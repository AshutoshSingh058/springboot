package com.example.demo.dto;


import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Title of the department cannot be blank")
    @Size(min = 3, max = 10, message = "Number of characters in title of department should be in the range: [3, 10]")
    private String title;

    @AssertTrue(message = "Department should be active")
    private Boolean isActive;

    @PastOrPresent(message = "createdAt field in Department cannot be in the future")
    private LocalDate createdAt;
}