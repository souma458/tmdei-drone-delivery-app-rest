package pt.isep.tmdei.usermanagement.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.usermanagement.model.response.GetAccountResponseDTO;
import pt.isep.tmdei.usermanagement.repository.UserAccountRepository;
import pt.isep.tmdei.usermanagement.service.exception.AccountNotFoundException;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository repository;

    public GetAccountResponseDTO getAccount(final String username) {
        var account = repository.findById(username).orElseThrow(
                () -> new AccountNotFoundException("Account with username " + username + " does not exist"));

        return new GetAccountResponseDTO(account);
    }

}
