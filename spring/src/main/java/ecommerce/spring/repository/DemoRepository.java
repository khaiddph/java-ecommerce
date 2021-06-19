package ecommerce.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.spring.enties.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
