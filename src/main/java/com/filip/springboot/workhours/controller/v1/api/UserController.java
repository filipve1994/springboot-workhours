package com.filip.springboot.workhours.controller.v1.api;

import com.filip.springboot.workhours.service.UserService;
import com.filip.springboot.workhours.controller.v1.request.UserSignupRequest;
import com.filip.springboot.workhours.dto.model.user.UserDto;
import com.filip.springboot.workhours.dto.response.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Arpit Khandelwal.
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(value="brs-application", description="Operations pertaining to user management in the BRS application")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Handles the incoming POST API "/v1/user/signup"
     *
     * @param userSignupRequest
     * @return
     */
    @PostMapping("/signup")
    public Response signup(@RequestBody @Valid UserSignupRequest userSignupRequest) {
        return Response.ok().setPayload(registerUser(userSignupRequest, false));
    }

    /**
     * Register a new user in the database
     *
     * @param userSignupRequest
     * @return
     */
    private UserDto registerUser(UserSignupRequest userSignupRequest, boolean isAdmin) {
        UserDto userDto = new UserDto()
                .setEmail(userSignupRequest.getEmail())
                .setPassword(userSignupRequest.getPassword())
                .setFirstName(userSignupRequest.getFirstName())
                .setLastName(userSignupRequest.getLastName())
                .setMobileNumber(userSignupRequest.getMobileNumber())
                .setEnabled(true)
                .setAdmin(isAdmin);

        return userService.signup(userDto);
    }
}
