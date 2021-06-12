package ecommerce.spring.enties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private Float price;

    private Integer quantity;

    private Float totalPrice;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name")
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;

    // @JsonIgnore
    // @OneToMany(mappedBy = "orders")
    // private List<OrderDetail> ordersDetails;
}
