package be.ipl.pfe.controllers;

import be.ipl.pfe.models.Account;
import be.ipl.pfe.services.AccountService;
import be.ipl.pfe.utils.JsonUtils;
import be.ipl.pfe.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> register (@Valid @RequestBody Account account) {
        Account registeredAccount = this.accountService.register(account);
        Map<String, Object> response = new HashMap<>();
        response.put("token", JwtUtils.createJWT(registeredAccount.getId(), registeredAccount.getUsername()));
        response.put("account", registeredAccount);
        return response;
    }

    @PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@Valid @RequestBody  Account account){
        Account loggedAccount = this.accountService.login(account);
        return JsonUtils.stringToJson("token", JwtUtils.createJWT(loggedAccount.getId(), loggedAccount.getUsername()));
    }
}
