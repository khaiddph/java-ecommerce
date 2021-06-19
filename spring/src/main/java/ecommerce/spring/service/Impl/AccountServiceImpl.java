// package ecommerce.spring.service.Impl;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import ecommerce.spring.enties.Account;
// import ecommerce.spring.repository.AccountRepository;
// import ecommerce.spring.service.AccountService;

// @Service
// public class AccountServiceImpl implements AccountService<Account> {

// @Autowired
// private AccountRepository accountRepository;

// @Override
// public Page<Account> getAll(Pageable pageable) {
// return this.accountRepository.findAll(pageable);
// }

// // @Override
// // public Optional<Account> findById(String user_name) {
// // return this.accountRepository.findById(user_name);
// // }

// @Override
// public Account save(Account account) {
// return this.accountRepository.save(account);
// }

// @Override
// public Account edit(String user_name, Account account) {
// Account currentAccount = this.accountRepository.findById(user_name)
// .orElseThrow(() -> new RuntimeException("account not found"));
// currentAccount.setEmail(account.getEmail());
// currentAccount.setAddress(account.getAddress());
// currentAccount.setPassword(account.getPassword());
// currentAccount.setPhone(account.getPhone());
// return this.accountRepository.save(account);
// }

// @Override
// public void remove(String user_name) {
// this.accountRepository.deleteById(user_name);
// }

// }
