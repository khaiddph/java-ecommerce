// package ecommerce.spring.repository;

// import java.util.Collection;
// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

// import ecommerce.spring.enties.Account;

// @Repository
// public interface AccountRepository extends JpaRepository<Account, String> {

// @Query("SELECT p FROM Account p WHERE CONCAT(p.user_name, p.email, p.phone,
// p.address) LIKE %?1%")
// Collection<Account> searchAccounts(String keyword);

// // Optional<Account> findAccount(String user_name);

// }
