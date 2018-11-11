package id.co.javan.keboot.sample.service.impl;

import id.co.javan.keboot.core.service.impl.EntityCrudServiceImpl;
import id.co.javan.keboot.sample.form.UserForm;
import id.co.javan.keboot.sample.model.User;
import id.co.javan.keboot.sample.repository.UserRepository;
import id.co.javan.keboot.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends EntityCrudServiceImpl<User, Long, UserForm, UserRepository> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public Specification<User> getSearchFilter(Object... filters) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filters.length > 0 && filters[0] != null && !StringUtils.isEmpty(filters[0].toString())) {
                String keyword = filters[0].toString().trim().toLowerCase();
                predicates.add(
                        builder.like(builder.lower(root.get("fullname")), "%" + keyword + "%")
                );
            }
            query.orderBy(builder.desc(root.get("id")));

            return builder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
