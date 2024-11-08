package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.request.UserRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.UserResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController extends BaseController{

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //register user is for any user who registers without any role
    @PostMapping(value = "/api/user/register")
    public BaseResponseDTO authenticate(@RequestBody @Valid UserRequestDTO model) throws PKException {
        userService.registerUser(model);
        return response();
    }

    //Fetch All Users
    @GetMapping(value = "/api/user/find-all-users")
    public BaseResponseDTO getAllUsers() throws PKException {
       List<UserResponseDTO> userResponseDTOList =  userService.getAllUsers();
        return response(userResponseDTOList);
    }

    //Find User By ID
    @GetMapping(value = "/api/user/find-user-by-Id/{userId}")
    public BaseResponseDTO getUserById(@PathVariable Long userId) throws PKException {
        UserResponseDTO userById =  userService.findUserById(userId);
        return response(userById);
    }

    //Inserting a new user
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
    @PostMapping(value = "/api/user/add-user")
    public BaseResponseDTO addUser(@RequestBody @Valid UserRequestDTO model) throws PKException {
       UserResponseDTO user =  userService.addUser(model);
        return response(user);
    }

    //Update an existing user
    @PostMapping(value = "/api/user/update-user/{userId}")
    public BaseResponseDTO updateUser(@RequestBody @Valid UserRequestDTO model,@PathVariable Long userId) throws PKException {
        UserResponseDTO user = userService.updateUser(model,userId);
        return response(user);
    }

    //Activating an inactive user
    @GetMapping(value = "/api/user/active-user/{userId}")
    public BaseResponseDTO activeUser(@PathVariable Long userId) throws PKException {
        UserResponseDTO user = userService.activeUser(userId);
        return response(user);
    }

    //Deactivating an active user
    @GetMapping(value = "/api/user/deActivate-user/{userId}")
    public BaseResponseDTO deActivateUser(@PathVariable Long userId) throws PKException {
        UserResponseDTO user = userService.deActivateUser(userId);
        return response(user);
    }

    //Deleting a user
    @DeleteMapping(value = "/api/user/delete-user/{userId}")
    public BaseResponseDTO deleteUser(@PathVariable Long userId) throws PKException {
        userService.deleteUser(userId);
        return response();
    }
}
