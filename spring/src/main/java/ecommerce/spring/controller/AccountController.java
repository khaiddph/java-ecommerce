// package ecommerce.spring.controller;

// import java.util.Collection;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import ecommerce.spring.enties.Account;
// import ecommerce.spring.repository.AccountRepository;
// import ecommerce.spring.service.Impl.AccountServiceImpl;

// @RestController
// @CrossOrigin
// @RequestMapping("/api")
// public class AccountController {

// @Autowired
// private AccountServiceImpl accountServiceImpl;

// @Autowired
// private AccountRepository accountRepository;

// @GetMapping("/account")
// public Page<Account> getAll(Pageable pageable) {
// return this.accountRepository.findAll(pageable);
// }

// @GetMapping("/account/search")
// public Collection<Account> searchAccount(@RequestParam String keyword) {
// return this.accountRepository.searchAccounts(keyword);
// }

// @PostMapping("/account")
// public Account saveAccount(@RequestBody Account account) {
// return this.accountServiceImpl.save(account);
// }

// @PutMapping("/account/{user_name}")
// public ResponseEntity<Account> editAccount(@PathVariable String user_name,
// @RequestBody Account Account) {
// return ResponseEntity.ok(accountServiceImpl.edit(user_name, Account));
// }

// @DeleteMapping("/account/{user_name}")
// public void deleteAccount(@PathVariable String user_name) {
// this.accountServiceImpl.remove(user_name);
// }
// }
