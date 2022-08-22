package nlu.fashionshopapi.model.entity;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		String createBy;
		Calendar createDate;
		String modifiedBy;
		Calendar modifiedDate;
}
