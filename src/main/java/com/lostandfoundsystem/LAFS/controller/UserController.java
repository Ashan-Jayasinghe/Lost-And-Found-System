package com.lostandfoundsystem.LAFS.controller;

import com.lostandfoundsystem.LAFS.dto.request.UserLoginDTO;
import com.lostandfoundsystem.LAFS.dto.request.UserSaveDTO;
import com.lostandfoundsystem.LAFS.dto.response.UserDetailsDTO;
import com.lostandfoundsystem.LAFS.dto.response.paginatedResponse.PaginatedUserListDTO;
import com.lostandfoundsystem.LAFS.service.interfaces.UserService;
import com.lostandfoundsystem.LAFS.utility.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping(
            path = {"/signup"}
    )
    public ResponseEntity<StandardResponse> signup(@RequestBody UserSaveDTO userSaveDTO){

        String message = userService.signup(userSaveDTO);
        StandardResponse standardResponse = new StandardResponse(
                200, "success", message
        );
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                standardResponse,
                HttpStatus.CREATED
        );
        return response;
    }

    @PostMapping(
            path = {"/login"}
    )
    public ResponseEntity<StandardResponse> login(@RequestBody UserLoginDTO userLoginDTO){
        String message = userService.login(userLoginDTO);
        StandardResponse standardResponse = new StandardResponse(
                200,"success", message
        );
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                standardResponse,
                HttpStatus.OK
        );
        return response;
    }

    @GetMapping(
            path = {"/profile"},
            params = {"user_id"}
    )
    public ResponseEntity<StandardResponse> getProfile(
            @RequestParam( value = "user_id")  long id
    ){
        UserDetailsDTO userDetailsDTO = userService.getProfile(id);
        StandardResponse standardResponse = new StandardResponse(
                200,"success", userDetailsDTO
        );
        ResponseEntity responseEntity = new ResponseEntity(
                standardResponse,
                HttpStatus.FOUND
        );
        return responseEntity;

    }

    @GetMapping(
            path = {"/users"},
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getUsers(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        PaginatedUserListDTO paginatedUserListDTO = userService.getAllUsers(page,size);
        StandardResponse standardResponse = new StandardResponse(
                200,"success", paginatedUserListDTO
        );
        ResponseEntity responseEntity = new ResponseEntity(
                standardResponse,
                HttpStatus.FOUND
        );
        return responseEntity;
    }

    @DeleteMapping(
            path = "/delete-user",
            params = "user_id"
    )
    public ResponseEntity<StandardResponse> deleteUser(
            @RequestParam( value = "user_id") long id
    ){
        String response = userService.deleteUser(id);
        StandardResponse standardResponse = new StandardResponse(
                200,"success", response
        );
        ResponseEntity responseEntity = new ResponseEntity(
                standardResponse,
                HttpStatus.OK
        );
        return responseEntity;

    }
}
