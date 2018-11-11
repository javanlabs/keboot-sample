package id.co.javan.keboot.sample.repository;

import id.co.javan.keboot.core.repository.EntityCrudRepository;
import id.co.javan.keboot.sample.model.User;

public interface UserRepository extends EntityCrudRepository<User, Long> {
}
