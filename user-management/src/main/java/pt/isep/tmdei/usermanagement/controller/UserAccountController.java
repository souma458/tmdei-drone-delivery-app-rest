package pt.isep.tmdei.usermanagement.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.usermanagement.service.UserAccountService;

@Controller
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

}
