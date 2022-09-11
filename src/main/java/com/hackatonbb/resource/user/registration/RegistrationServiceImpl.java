package com.hackatonbb.resource.user.registration;

import com.hackatonbb.OperationStatus;
import com.hackatonbb.VerificationStatus;
import com.hackatonbb.dict.DictOperationName;
import com.hackatonbb.entity.User;
import com.hackatonbb.mapper.SmartMapper;
import com.hackatonbb.repository.UserRepository;
import com.hackatonbb.resource.user.registration.model.RegistrationDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final RegistrationVerificationService registrationVerificationService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserRepository userRepository,
                                   RegistrationVerificationService registrationVerificationService,
                                   PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.registrationVerificationService = registrationVerificationService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public OperationStatus registerUser(RegistrationDTO registrationDTO) {

        OperationStatus operationStatus = new OperationStatus()
                .setOperationName(DictOperationName.ADD.getCode())
                .setTargetClassName(User.class.getSimpleName());

        VerificationStatus verificationStatus = registrationVerificationService
                .verifyUserRegistration(registrationDTO);

        if (!verificationStatus.isAccepted())
            return operationStatus.setSuccess(false)
                    .addMessage(verificationStatus.getMessage());
        else {
            User user = new User();

            user.setPassword(registrationDTO.getPassword());
            user.setCompanyId(registrationDTO.getCompanyId());
            user.setFirstname(registrationDTO.getFirstname());
            user.setLastname(registrationDTO.getLastname());
            user.setEmail(registrationDTO.getEmail());
            user.setLogin(registrationDTO.getLogin());
            user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

            User userSaved = userRepository.save(user);
            Integer id = userSaved.getUserId();
            operationStatus.setRecordId(id).setSuccess(id != null);

            return operationStatus;
        }
    }
}
