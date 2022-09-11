package com.hackatonbb.graphql.user;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hackatonbb.OperationStatus;
import com.hackatonbb.dict.DictOperationName;
import com.hackatonbb.entity.User;
import com.hackatonbb.mapper.SmartMapper;
import com.hackatonbb.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserRepository userRepository;

    public UserMutationResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @PreAuthorize("hasAuthority('USER_ADD_PRIVILEGE')")
    public OperationStatus addUser(UserInput userInput) {
        return saveUser(null, userInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('USER_MODIFY_PRIVILEGE')")
    public OperationStatus updateUser(@NotNull Integer userInputId, UserInput userInput) {
        return saveUser(userInputId, userInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('USER_DELETE_PRIVILEGE')")
    public OperationStatus deleteUser(@NotNull Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        OperationStatus opStatus = new OperationStatus(User.class.getSimpleName(), DictOperationName.DELETE.getCode());
        opStatus.setRecordId(userId);

        userRepository.delete(user);

        return opStatus.setSuccess(!userRepository.existsById(userId));
    }

    protected OperationStatus saveUser(Integer userId, UserInput userInput) {
        boolean adding = (userId == null);
        User user = (adding ? new User() : userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));

        OperationStatus opStatus = new OperationStatus(User.class.getSimpleName(), adding ? DictOperationName.ADD.getCode() : DictOperationName.UPDATE.getCode());

        SmartMapper.transferData(userInput, user);

        User userSaved = userRepository.save(user);
        Integer id = userSaved.getUserId();
        opStatus.setRecordId(id).setSuccess(id != null);
        return opStatus;
    }
}
