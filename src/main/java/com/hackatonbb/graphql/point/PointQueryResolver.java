package com.hackatonbb.graphql.point;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hackatonbb.entity.Point;
import com.hackatonbb.repository.PointRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class PointQueryResolver implements GraphQLQueryResolver {

    private final PointRepository pointRepository;

    public PointQueryResolver(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('POINT_READ_PRIVILEGE')")
    public Point getPoint(@NotNull Integer pointId) {
        return pointRepository.findById(pointId).orElseThrow(EntityNotFoundException::new);
    }
}
