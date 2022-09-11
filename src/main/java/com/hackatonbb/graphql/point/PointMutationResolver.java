package com.hackatonbb.graphql.point;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hackatonbb.OperationStatus;
import com.hackatonbb.dict.DictOperationName;
import com.hackatonbb.entity.Point;
import com.hackatonbb.graphql.point.PointInput;
import com.hackatonbb.mapper.SmartMapper;
import com.hackatonbb.repository.PointRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class PointMutationResolver implements GraphQLMutationResolver {

    private final PointRepository pointRepository;

    public PointMutationResolver(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Transactional
    @PreAuthorize("hasAuthority('POINT_ADD_PRIVILEGE')")
    public OperationStatus addPoint(PointInput pointInput) {
        return savePoint(null, pointInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('POINT_MODIFY_PRIVILEGE')")
    public OperationStatus updatePoint(@NotNull Integer pointInputId, PointInput pointInput) {
        return savePoint(pointInputId, pointInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('POINT_DELETE_PRIVILEGE')")
    public OperationStatus deletePoint(@NotNull Integer pointId) {
        Point point = pointRepository.findById(pointId).orElseThrow(EntityNotFoundException::new);

        OperationStatus opStatus = new OperationStatus(Point.class.getSimpleName(), DictOperationName.DELETE.getCode());
        opStatus.setRecordId(pointId);

        pointRepository.delete(point);

        return opStatus.setSuccess(!pointRepository.existsById(pointId));
    }

    protected OperationStatus savePoint(Integer pointId, PointInput pointInput) {
        boolean adding = (pointId == null);
        Point point = (adding ? new Point() : pointRepository.findById(pointId).orElseThrow(EntityNotFoundException::new));

        OperationStatus opStatus = new OperationStatus(Point.class.getSimpleName(), adding ? DictOperationName.ADD.getCode() : DictOperationName.UPDATE.getCode());

        SmartMapper.transferData(pointInput, point);

        Point pointSaved = pointRepository.save(point);
        Integer id = pointSaved.getPointId();
        opStatus.setRecordId(id).setSuccess(id != null);
        return opStatus;
    }
}
