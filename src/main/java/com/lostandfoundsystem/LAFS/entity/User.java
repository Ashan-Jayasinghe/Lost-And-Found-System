package com.lostandfoundsystem.LAFS.entity;

import com.lostandfoundsystem.LAFS.entity.enums.Role;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "user")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class),
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @Column(name = "user_id", length = 50,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "user_name", length = 150, nullable = false)
    private String userName;

    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Type(type = "json")
    @Column(name = "contact_numbers", columnDefinition = "json",length = 10)
    private ArrayList<String> contactNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 100, nullable = false)
    private Role role;

    // One-to-many relationship with Item
    @OneToMany(mappedBy = "user")
    private Set<Item> items;

    // One-to-many relationship with Report
    @OneToMany(mappedBy = "user")
    private Set<Report> reports;

    public User(String userName, String email, ArrayList<String> contactNumber, Role role) {
        this.userName = userName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.role = role;
    }
}
