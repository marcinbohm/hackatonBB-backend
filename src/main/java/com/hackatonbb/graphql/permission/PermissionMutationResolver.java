package com.hackatonbb.graphql.permission;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hackatonbb.OperationStatus;
import com.hackatonbb.dict.DictOperationName;
import com.hackatonbb.entity.Permission;
import com.hackatonbb.mapper.SmartMapper;
import com.hackatonbb.repository.PermissionRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class PermissionMutationResolver implements GraphQLMutationResolver {

    private final PermissionRepository permissionRepository;

    public PermissionMutationResolver(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Transactional
    @PreAuthorize("hasAuthority('PERMISSION_ADD_PRIVILEGE')")
    public OperationStatus addPermission(PermissionInput permissionInput) {
        return savePermission(null, permissionInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('PERMISSION_MODIFY_PRIVILEGE')")
    public OperationStatus updatePermission(@NotNull Integer permissionInputId, PermissionInput permissionInput) {
        return savePermission(permissionInputId, permissionInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('PERMISSION_DELETE_PRIVILEGE')")
    public OperationStatus deletePermission(@NotNull Integer permissionId) {
        Permission permission = permissionRepository.findById(permissionId).orElseThrow(EntityNotFoundException::new);

        OperationStatus opStatus = new OperationStatus(Permission.class.getSimpleName(), DictOperationName.DELETE.getCode());
        opStatus.setRecordId(permissionId);

        permissionRepository.delete(permission);

        return opStatus.setSuccess(!permissionRepository.existsById(permissionId));
    }

    protected OperationStatus savePermission(Integer permissionId, PermissionInput permissionInput) {
        boolean adding = (permissionId == null);
        Permission permission = (adding ? new Permission() : permissionRepository.findById(permissionId).orElseThrow(EntityNotFoundException::new));

        OperationStatus opStatus = new OperationStatus(Permission.class.getSimpleName(), adding ? DictOperationName.ADD.getCode() : DictOperationName.UPDATE.getCode());

        SmartMapper.transferData(permissionInput, permission);

        Permission permissionSaved = permissionRepository.save(permission);
        Integer id = permissionSaved.getPermissionId();
        opStatus.setRecordId(id).setSuccess(id != null);
        return opStatus;
    }
}
