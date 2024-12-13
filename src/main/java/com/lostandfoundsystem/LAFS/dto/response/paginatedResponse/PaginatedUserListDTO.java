package com.lostandfoundsystem.LAFS.dto.response.paginatedResponse;

import com.lostandfoundsystem.LAFS.dto.response.UserDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedUserListDTO {
    private List<UserDetailsDTO> userDetailsDTOS;
    private long totalUsers;
}
