package id.co.javan.keboot.sample.service.impl;

import id.co.javan.keboot.core.service.impl.EntityCrudServiceImpl;
import id.co.javan.keboot.sample.form.ClassroomForm;
import id.co.javan.keboot.sample.model.Classroom;
import id.co.javan.keboot.sample.repository.ClassroomRepository;
import id.co.javan.keboot.sample.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomServiceImpl extends EntityCrudServiceImpl<Classroom, Long, ClassroomForm, ClassroomRepository> implements ClassroomService {

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.repository = classroomRepository;
    }

    @Override
    public Specification<Classroom> getSearchFilter(Object... filters) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filters.length > 0 && filters[0] != null && !StringUtils.isEmpty(filters[0].toString())) {
                String keyword = filters[0].toString().trim().toLowerCase();
                predicates.add(
                        builder.like(builder.lower(root.get("name")), "%" + keyword + "%")
                );
            }
            query.orderBy(builder.desc(root.get("id")));

            return builder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
