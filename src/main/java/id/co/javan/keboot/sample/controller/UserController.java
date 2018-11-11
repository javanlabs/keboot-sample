package id.co.javan.keboot.sample.controller;

import id.co.javan.keboot.core.controller.EntityCrudController;
import id.co.javan.keboot.sample.form.UserForm;
import id.co.javan.keboot.sample.model.User;
import id.co.javan.keboot.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
public class UserController extends EntityCrudController<User, Long, UserForm> {
    @Autowired
    public UserController(UserService userService) {
        this.entityCrudService = userService;
    }

    @Override
    @GetMapping(value = "/user")
    public Page<User> list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        return super.list(page, size, keyword);
    }

    @Override
    @PostMapping(value = "/user")
    public User create(HttpServletRequest request, @Valid UserForm userForm, BindingResult bindingResult) throws Exception {
        return super.create(request, userForm, bindingResult);
    }

    @Override
    @GetMapping(value = "/user/{id}")
    public User view(@PathVariable("id") Long id) {

        return super.view(id);
    }

    @Override
    @PostMapping(value = "/user/{id}")
    public User update(@PathVariable("id") Long id, HttpServletRequest request, @Valid UserForm userForm, BindingResult bindingResult) throws Exception {

        return super.update(id, request, userForm, bindingResult);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {

        return super.delete(id);
    }
}
