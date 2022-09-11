package com.hackatonbb.resource.user.registration;

import com.hackatonbb.OperationStatus;
import com.hackatonbb.resource.user.registration.model.RegistrationDTO;

public interface RegistrationService {
    OperationStatus registerUser(RegistrationDTO registrationDTO);
}
