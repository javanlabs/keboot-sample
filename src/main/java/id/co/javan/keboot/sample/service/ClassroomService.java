package id.co.javan.keboot.sample.service;

import id.co.javan.keboot.core.service.EntityCrudService;
import id.co.javan.keboot.sample.form.ClassroomForm;
import id.co.javan.keboot.sample.model.Classroom;

public interface ClassroomService extends EntityCrudService<Classroom, Long, ClassroomForm> {
}
