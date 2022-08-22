package nlu.fashionshopapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Orders extends BaseEntity  {

	Calendar createDateOrder;
	String phoneNumber;
	String nameSender;
	double totalBill;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id")
	List<OrderItem> orderDetails = new ArrayList<OrderItem>();
	@ManyToOne(fetch = FetchType.LAZY)
	User user;

}