package com.lostandfoundsystem.LAFS.dto.response;

import com.lostandfoundsystem.LAFS.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsDTO {
    private String userName;
    private String email;
    private ArrayList<String> contactNumber;
    private Role role;
}
