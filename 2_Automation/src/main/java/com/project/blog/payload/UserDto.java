package com.project.blog.payload;

import com.project.blog.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min = 4, message = "User name must be contain 4 characters")
    private String name;

    @Email
    @Size(message = "Email Address is not valid")
    private String email;

    @NotEmpty
    @Size(max = 14, min = 4,message = "Password should be of minimum 4 characters amd maximum can contains 14 characters")
    private String password;

    @NotEmpty
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

}
