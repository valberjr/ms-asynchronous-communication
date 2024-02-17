package com.ms.user.controllers;

import com.ms.user.dtos.UserRecord;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(
            @RequestBody
            @Valid
            UserRecord userRecord
    ) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecord, userModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(userModel));
    }
}
