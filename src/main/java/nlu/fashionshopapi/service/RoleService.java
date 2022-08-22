package nlu.fashionshopapi.service;

import org.springframework.stereotype.Service;

import nlu.fashionshopapi.model.entity.Role;
import nlu.fashionshopapi.payload.request.RoleRequest;

@Service
public interface RoleService {
	public Role createRole(RoleRequest roleRequest);
}
