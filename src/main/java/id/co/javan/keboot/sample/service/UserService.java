package id.co.javan.keboot.sample.service;

import id.co.javan.keboot.core.service.EntityCrudService;
import id.co.javan.keboot.sample.form.UserForm;
import id.co.javan.keboot.sample.model.User;

public interface UserService extends EntityCrudService<User, Long, UserForm> {
}
