package com.lostandfoundsystem.LAFS.dto.request;

import com.lostandfoundsystem.LAFS.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDTO {
    private String email;
    private String password;
}
