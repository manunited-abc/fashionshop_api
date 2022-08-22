package nlu.fashionshopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nlu.fashionshopapi.model.entity.Role;
import nlu.fashionshopapi.model.role.ERole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}