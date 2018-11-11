package id.co.javan.keboot.sample.form;

import id.co.javan.keboot.core.form.EntityCrudForm;
import id.co.javan.keboot.sample.model.Classroom;
import id.co.javan.keboot.sample.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClassroomForm implements EntityCrudForm<Classroom> {

    @NotEmpty
    private String name;

    @NotNull
    private User admin;

    @Override
    public Classroom toCreateEntity() {
        Classroom user = new Classroom();
        user.setName(name);
        user.setAdmin(admin);

        return user;
    }

    @Override
    public Classroom toUpdateEntity(Classroom oldEntity) {
        oldEntity.setName(name);
        oldEntity.setAdmin(admin);

        return oldEntity;
    }
}
