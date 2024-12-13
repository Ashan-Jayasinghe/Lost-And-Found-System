package com.lostandfoundsystem.LAFS.dto.request;

import com.lostandfoundsystem.LAFS.entity.Item;
import com.lostandfoundsystem.LAFS.entity.Report;
import com.lostandfoundsystem.LAFS.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSaveDTO {
    private String userName;
    private String email;
    private ArrayList<String> contactNumber;
    private Role role;
    private String password;

}
