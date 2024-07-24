package org.example.recette_springboot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private int id;
    @NotNull(message = "the field must be filled in")
    @NotBlank
    @Size(min =10,max = 25)
    private String name;
    @NotNull(message = "the field must be filled in")
    @NotBlank
    private String description;
}
