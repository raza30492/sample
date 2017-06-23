package com.jazasoft.sample.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jazasoft.sample.Role;
import com.jazasoft.sample.validation.StringEnum;
import org.springframework.hateoas.core.Relation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Relation(collectionRelation = "users",value = "user")
public class UserDto {

    private Long id;

    @NotNull
    @Size(min = 5, max = 100)
    private String name;

    @NotNull
    @Pattern(regexp=".+@.+\\..+", message="Incorrect email!")
    private String email;

    @JsonIgnore
    private String password;

    @NotNull
    @StringEnum(enumClass = Role.class)
    private String role;

    @NotNull
    @Pattern(regexp="[0-9]{10}", message="Incorrect mobile")
    private String mobile;

    public UserDto() {
    }

    public UserDto(String name, String email, String role, String mobile) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserDto{" + "id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", mobile=" + mobile + '}';
    }
}