package com.hackatonbb.graphql.installation;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hackatonbb.entity.Installation;
import com.hackatonbb.repository.InstallationRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class InstallationQueryResolver implements GraphQLQueryResolver {

    private final InstallationRepository installationRepository;

    public InstallationQueryResolver(InstallationRepository installationRepository) {
        this.installationRepository = installationRepository;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('INSTALLATION_READ_PRIVILEGE')")
    public Installation getInstallation(@NotNull Integer installationId) {
        return installationRepository.findById(installationId).orElseThrow(EntityNotFoundException::new);
    }
}
