package be.ipl.pfe.services;

import be.ipl.pfe.exceptions.AlreadyExistsException;
import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.exceptions.LoginException;
import be.ipl.pfe.exceptions.NotFoundException;
import be.ipl.pfe.models.Account;
import be.ipl.pfe.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account register(Account account) {
        if (account.getDoctor() == null && account.getEstablishment() == null)
            throw new InvalidParameterException("doctor or establishment", "non-null");
        if (this.accountRepository.existsByUsername(account.getUsername()))
            throw new AlreadyExistsException("username");
        account.hashPassword();
        Account createdAccount = this.accountRepository.save(account);
        return createdAccount;
    }

    public Account login(Account account) {
        Account accountFound = this.accountRepository.findByUsername(account.getUsername());
        if (account == null) throw new NotFoundException("account", "username", account.getUsername());
        if (!accountFound.checkPassword(account.getPassword())) throw new LoginException();
        return accountFound;
    }
}
