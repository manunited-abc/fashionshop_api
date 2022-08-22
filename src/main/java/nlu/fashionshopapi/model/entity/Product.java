package nlu.fashionshopapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Product  extends BaseEntity  {

	String name;
	String description;
	double price;
	@ElementCollection(fetch = FetchType.EAGER)
	List<String> images = new ArrayList<String>();
	@ManyToOne(fetch = FetchType.LAZY)
	Category category;
}