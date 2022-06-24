package com.example.testtask.model.service.dataservice.role;

import com.example.testtask.repo.RoleRepository;
import org.springframework.stereotype.Service;

@Service("roleDataServiceImpl")
public class RoleDataServiceImpl implements RoleDataService {

    private final RoleRepository roleRepository;

    public RoleDataServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void deleteRoleById(Integer roleId) {
        roleRepository.deleteById(roleId);
    }
}
