package com.wad.firstmvc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements UserDetails {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Event> events = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<ShoppingItem> shoppingItems = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Task> tasks = new ArrayList<>();
    @Setter
    @Getter
    @Id
    @GeneratedValue()
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @Setter
    @Getter
    private String username;
    private String password;
    private String familyMember;
    @Setter
    @Getter
    private String gender;
    private int age;
    private Role role;
    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "family_id")
    private Family family;
    @Getter
    @Setter
    @ManyToOne
    private AvatarImage avatarImage;

    public User(String username, String password, String gender) {
        this.username = username;
        this.password = password;
        this.gender = gender;
    }


    public User() {
    }


    public User(Long id, String username, String password, String gender, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }

    public User(Long id, String username, String password, String gender, Role role, Family family) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.family = family;
    }

    public User(Long id, String username, String password, String gender, Role role, Family family, AvatarImage avatarImage) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.family = family;
        this.avatarImage = avatarImage;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addShoppingItem(ShoppingItem shoppingItem) {
        shoppingItems.add(shoppingItem);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return this.role.equals(Role.ROLE_ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
