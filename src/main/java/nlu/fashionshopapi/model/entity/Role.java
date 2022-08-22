package nlu.fashionshopapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nlu.fashionshopapi.model.role.ERole;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Role  extends BaseEntity {

	@Enumerated(EnumType.STRING)
	ERole name;
}
