package com.lostandfoundsystem.LAFS.service.implementations;

import com.lostandfoundsystem.LAFS.dto.request.UserLoginDTO;
import com.lostandfoundsystem.LAFS.dto.request.UserSaveDTO;
import com.lostandfoundsystem.LAFS.dto.response.UserDetailsDTO;
import com.lostandfoundsystem.LAFS.dto.response.paginatedResponse.PaginatedUserListDTO;
import com.lostandfoundsystem.LAFS.entity.User;
import com.lostandfoundsystem.LAFS.entity.enums.Role;
import com.lostandfoundsystem.LAFS.repository.UserRepo;
import com.lostandfoundsystem.LAFS.service.interfaces.UserService;
import com.lostandfoundsystem.LAFS.utility.StandardResponse;
import com.lostandfoundsystem.LAFS.utility.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String signup(UserSaveDTO userSaveDTO) {

        if(!userRepo.existsUserByEmail(userSaveDTO.getEmail())) {
//            User user = new User(
//                    userSaveDTO.getUserName(),
//                    userSaveDTO.getEmail(),
//                    userSaveDTO.getContactNumber(),
//                    userSaveDTO.getRole()
//            );
            User user = userMapper.userSaveDTOToUserEntity(userSaveDTO);
            userRepo.save(user);
            return "Hello " + userSaveDTO.getUserName();
        }else{
            return "User already exists";
//            throw new Exception("User Exists");
        }
    }

    @Override
    public String login(UserLoginDTO userLoginDTO) {

        if(userRepo.existsUserByEmail(userLoginDTO.getEmail())) {
            User user = userRepo.getUserByEmail(userLoginDTO.getEmail());
            if(user.getPassword().equals(userLoginDTO.getPassword())) {
                return "Login successful";
            }else{
                return "Wrong password";
            }

        }else {
            return "wrong Email";
        }
    }

    @Override
    public UserDetailsDTO getProfile(long id) {
        if(userRepo.existsById(id)){
            User user = userRepo.findById(id).get();
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
            userDetailsDTO = userMapper.UserEntityToUserDetailsDTO(user);
            return userDetailsDTO;
        }else {
            throw new EmptyResultDataAccessException(1);
        }

    }

    @Override
    public String deleteUser(long id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "User deleted Successfully : " + id;
        }else {
            throw new EmptyResultDataAccessException(1);
        }
    }

    @Override
    public PaginatedUserListDTO getAllUsers(int page, int size) {
       Page<User> users = userRepo.findAll(PageRequest.of(page,size));
       long totalUsersCount = userRepo.count();
       if(users.getSize()>0){
           PaginatedUserListDTO paginatedUserListDTO = new PaginatedUserListDTO(
                   userMapper.UserPageToUserListDTO(users),
                   totalUsersCount
           );

           return paginatedUserListDTO;

       }else {
           throw new EmptyResultDataAccessException(1);
       }

    }




}
