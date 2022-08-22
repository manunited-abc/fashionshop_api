package nlu.fashionshopapi.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nlu.fashionshopapi.model.entity.Role;
import nlu.fashionshopapi.model.role.ERole;
import nlu.fashionshopapi.payload.request.RoleRequest;
import nlu.fashionshopapi.repository.RoleRepository;
import nlu.fashionshopapi.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role createRole(RoleRequest roleRequest) {
		Role role = new Role();
		role.setCreateBy("admin");
		role.setCreateDate(Calendar.getInstance());
		role.setModifiedBy("admin");
		role.setModifiedDate(Calendar.getInstance());
		role.setName(ERole.valueOf(roleRequest.getNameRole()));
		roleRepository.save(role);
		return role;
		
	}

}
