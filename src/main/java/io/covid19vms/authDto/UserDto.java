package io.covid19vms.authDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.covid19vms.entity.User;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private int id;
    private String email;
    private String name;
    private String role;
    private String token;

    public UserDto() {
    }

    public UserDto(Optional<User> user, String token) {
        user.ifPresent(u -> {
            this.id = u.getId();
            this.email =  u.getEmail();
            this.name = u.getUserName();
            this.role = u.getUserRole().getRoleName().name();
            this.token = token;
        });
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
   }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
