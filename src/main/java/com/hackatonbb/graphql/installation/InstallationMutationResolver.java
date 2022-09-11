package com.hackatonbb.graphql.installation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hackatonbb.OperationStatus;
import com.hackatonbb.dict.DictOperationName;
import com.hackatonbb.entity.Installation;
import com.hackatonbb.mapper.SmartMapper;
import com.hackatonbb.repository.InstallationRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class InstallationMutationResolver implements GraphQLMutationResolver {

    private final InstallationRepository installationRepository;

    public InstallationMutationResolver(InstallationRepository installationRepository) {
        this.installationRepository = installationRepository;
    }

    @Transactional
    @PreAuthorize("hasAuthority('INSTALLATION_ADD_PRIVILEGE')")
    public OperationStatus addInstallation(InstallationInput installationInput) {
        return saveInstallation(null, installationInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('INSTALLATION_MODIFY_PRIVILEGE')")
    public OperationStatus updateInstallation(@NotNull Integer installationInputId, InstallationInput installationInput) {
        return saveInstallation(installationInputId, installationInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('INSTALLATION_DELETE_PRIVILEGE')")
    public OperationStatus deleteInstallation(@NotNull Integer installationId) {
        Installation installation = installationRepository.findById(installationId).orElseThrow(EntityNotFoundException::new);

        OperationStatus opStatus = new OperationStatus(Installation.class.getSimpleName(), DictOperationName.DELETE.getCode());
        opStatus.setRecordId(installationId);

        installationRepository.delete(installation);

        return opStatus.setSuccess(!installationRepository.existsById(installationId));
    }

    protected OperationStatus saveInstallation(Integer installationId, InstallationInput installationInput) {
        boolean adding = (installationId == null);
        Installation installation = (adding ? new Installation() : installationRepository.findById(installationId).orElseThrow(EntityNotFoundException::new));

        OperationStatus opStatus = new OperationStatus(Installation.class.getSimpleName(), adding ? DictOperationName.ADD.getCode() : DictOperationName.UPDATE.getCode());

        SmartMapper.transferData(installationInput, installation);

        Installation installationSaved = installationRepository.save(installation);
        Integer id = installationSaved.getInstallationId();
        opStatus.setRecordId(id).setSuccess(id != null);
        return opStatus;
    }
}
