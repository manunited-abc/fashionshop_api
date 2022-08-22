package nlu.fashionshopapi.model.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Entity
@Table(name = "users")
public class User extends BaseEntity  {


	String name;

	String email;

	String phone;

	String avatar;

	String password;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	List<Address> addresses = new ArrayList<Address>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	List<Role> roles = new ArrayList<Role>();
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	List<Orders> orders = new ArrayList<Orders>();

}