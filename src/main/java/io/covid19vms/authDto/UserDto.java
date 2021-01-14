package io.covid19vms.authDto;

import io.covid19vms.entity.User;

import java.util.Optional;

public class UserDto {
    private int id;
    private String email;
    private String role;
    private String token;

    public UserDto() {
    }

    public UserDto(Optional<User> user, String token) {
        user.ifPresent(u -> {
            this.id = u.getId();
            this.email =  u.getEmail();
            this.role = u.getUserRole().getRoleName().name();
            this.token = token;

            System.out.println(token);
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
