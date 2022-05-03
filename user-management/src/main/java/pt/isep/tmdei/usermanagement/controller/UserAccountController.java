package pt.isep.tmdei.usermanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.usermanagement.model.response.GetAccountResponseDTO;
import pt.isep.tmdei.usermanagement.service.UserAccountService;

@Controller
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService service;

    @GetMapping("/account/{username}")
    public ResponseEntity<GetAccountResponseDTO> getAccount(@PathVariable(value = "username") String username) {
        return new ResponseEntity<GetAccountResponseDTO>(service.getAccount(username), HttpStatus.OK);
    }

}