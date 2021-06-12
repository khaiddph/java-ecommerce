package ecommerce.spring.enties;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Account {

    @Id
    private String user_name;

    private String email;

    private String password;

    private String address;

    private Long phone;

    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Orders> orders;
}
