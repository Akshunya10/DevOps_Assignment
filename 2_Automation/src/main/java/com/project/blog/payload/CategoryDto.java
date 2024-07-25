package com.project.blog.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(max = 20,message = "Title should be less than 20 character")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10, max = 100,message = "Description should be between 10 to 100 character")
    private String categoryDescription;
}
