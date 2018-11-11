package id.co.javan.keboot.sample.controller;

import id.co.javan.keboot.core.controller.EntityCrudController;
import id.co.javan.keboot.sample.form.ClassroomForm;
import id.co.javan.keboot.sample.model.Classroom;
import id.co.javan.keboot.sample.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
public class ClassroomController extends EntityCrudController<Classroom, Long, ClassroomForm> {
    @Autowired
    private ClassroomService classroomService;

    @Override
    @GetMapping(value = "/classroom")
    public Page<Classroom> list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        return super.list(page, size, keyword);
    }

    @Override
    @PostMapping(value = "/classroom")
    public Classroom create(HttpServletRequest request, @Valid ClassroomForm classroomForm, BindingResult bindingResult) throws Exception {
        return super.create(request, classroomForm, bindingResult);
    }

    @Override
    @GetMapping(value = "/classroom/{id}")
    public Classroom view(@PathVariable("id") Long id) {

        return super.view(id);
    }

    @Override
    @PostMapping(value = "/classroom/{id}")
    public Classroom update(@PathVariable("id") Long id, HttpServletRequest request, @Valid ClassroomForm classroomForm, BindingResult bindingResult) throws Exception {

        return super.update(id, request, classroomForm, bindingResult);
    }

    @DeleteMapping(value = "/classroom/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {

        return super.delete(id);
    }
}
