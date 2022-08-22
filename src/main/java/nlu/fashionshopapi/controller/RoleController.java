package nlu.fashionshopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nlu.fashionshopapi.model.entity.Role;
import nlu.fashionshopapi.payload.request.RoleRequest;
import nlu.fashionshopapi.service.RoleService;

@RestController
@RequestMapping("api/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	@PostMapping
	public ResponseEntity<?> createRole(@RequestBody RoleRequest roleRequest){
		Role role = roleService.createRole(roleRequest);
		return ResponseEntity.ok(role);
	}
}
