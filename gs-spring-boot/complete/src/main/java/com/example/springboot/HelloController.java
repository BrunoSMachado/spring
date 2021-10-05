package com.example.springboot;


import com.example.exceptions.AccountNotFoundException;
import com.example.exceptions.WrongPinException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class HelloController {

	private final AccountRepository repositoryA;
	private ATM atm;

	HelloController(AccountRepository repositoryA, ATMRepository repositoryATM){
		this.repositoryA = repositoryA;
		this.atm = new ATM(5000, 10, 30, 30, 20);

	}

	@GetMapping("/")
	public String unitTest(){
		return "Unit Test";
	}

	@PostMapping("/balance")
	public BalanceResponse balance(@RequestBody BalanceRequest balanceRequest) throws WrongPinException, AccountNotFoundException{
		if(repositoryA.findById(balanceRequest.getAccountNumber()).isPresent()){
			Account a = repositoryA.findById(balanceRequest.getAccountNumber()).get();
			if(a.checkPin(balanceRequest.getPin())){
				return new BalanceResponse(a.getBalance(), a.getBalance() + a.getOverdraft());
			}
			else{
				throw new WrongPinException(balanceRequest.getAccountNumber());
			}
		}
		else{
			throw new AccountNotFoundException(balanceRequest.getAccountNumber());
		}
	}

	@PostMapping("/withdraw")
	public WithdrawResponse withdraw(@RequestBody WithdrawRequest withdrawRequest) throws Exception {
		if(repositoryA.findById(withdrawRequest.getAccountNumber()).isPresent()) {
			Account a = repositoryA.findById(withdrawRequest.getAccountNumber()).get();
			if (a.checkPin(withdrawRequest.getPin())) {
				ATM temp = atm.withdraw(withdrawRequest.getWithdraw());
				a.withdraw(withdrawRequest.getWithdraw());
				repositoryA.save(a);
				return new WithdrawResponse(a.getBalance(), temp.getBill50(), temp.getBill20(), temp.getBill10(), temp.getBill5());
			} else {
				throw new WrongPinException(withdrawRequest.getAccountNumber());
			}
		} else{
			throw new AccountNotFoundException(withdrawRequest.getAccountNumber());
		}
	}

	@GetMapping("/accounts")
	public List<Account> all() {
		return repositoryA.findAll();
	}

	@PostMapping("/account")
	public Account newAccount(@RequestBody Account newAccount) {
		return repositoryA.save(newAccount);
	}


}
