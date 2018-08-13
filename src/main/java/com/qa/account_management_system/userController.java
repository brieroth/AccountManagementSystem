package com.qa.account_management_system;
import com.qa.account_management_system.Account;
import com.qa.account_management_system.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/Account/")
public class userController {
	@Autowired
	AccountService accountService;
		

	@GetMapping
	public List<Account> list(){
		return accountService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create (@RequestBody Account account) {
		
		
		accountService.save(account);
	}
	
	@GetMapping("/{id}")
	public Account get(@PathVariable ("id") long id) {
		return accountService.getOne(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable (value="id") long id, @RequestBody Account account) {
	 Account acc = accountService.findOne(id);
	 acc.setFirstname(account.getFirstname());
	 acc.setSurname(account.getSurname());
	 acc.setAccountNumber(account.getAccountNumber());
	 Account updateAccount = accountService.save(acc);
	 return ResponseEntity.ok().body(updateAccount);
	}
	

}
