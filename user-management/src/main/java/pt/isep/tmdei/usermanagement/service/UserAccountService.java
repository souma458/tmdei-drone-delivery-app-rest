package pt.isep.tmdei.usermanagement.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.usermanagement.repository.UserAccountRepository;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

}
