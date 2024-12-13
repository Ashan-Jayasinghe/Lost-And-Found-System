package com.lostandfoundsystem.LAFS.service.interfaces;

import com.lostandfoundsystem.LAFS.dto.request.UserLoginDTO;
import com.lostandfoundsystem.LAFS.dto.request.UserSaveDTO;
import com.lostandfoundsystem.LAFS.dto.response.UserDetailsDTO;
import com.lostandfoundsystem.LAFS.dto.response.paginatedResponse.PaginatedUserListDTO;
import com.lostandfoundsystem.LAFS.utility.StandardResponse;

public interface UserService {
    public String signup(UserSaveDTO userSaveDTO);

    public String login(UserLoginDTO userLoginDTO);

    public UserDetailsDTO getProfile(long id);

    public String deleteUser(long id);

    public PaginatedUserListDTO getAllUsers(int page, int size);
}
