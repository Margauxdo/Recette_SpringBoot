package org.example.recette_springboot.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    private int id;
    @NotNull(message = "the field must be filled in")
    @Size(min = 3,max= 15 )
    @NotBlank
    private String name;
    @NotNull(message = "the field must be filled in")
    @NotBlank
    List<String> ingredients;
    @NotNull(message = "the field must be filled in")
    @NotBlank
    private String instructions;
    private Category category;
}
