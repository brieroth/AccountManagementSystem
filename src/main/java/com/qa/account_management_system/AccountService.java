package com.qa.account_management_system;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.account_management_system.Account;

public interface AccountService extends JpaRepository<Account, Long>{
	

}

