package com.hackatonbb.resource.user.registration;

import com.hackatonbb.VerificationStatus;
import com.hackatonbb.resource.user.registration.model.RegistrationDTO;

public interface RegistrationVerificationService {
    VerificationStatus verifyUserRegistration(RegistrationDTO registrationDTO);
}
