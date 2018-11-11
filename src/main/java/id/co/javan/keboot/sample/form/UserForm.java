package id.co.javan.keboot.sample.form;

import id.co.javan.keboot.core.form.EntityCrudForm;
import id.co.javan.keboot.sample.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UserForm implements EntityCrudForm<User> {

    @NotEmpty
    private String fullname;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birth_date;

    @Override
    public User toCreateEntity() {
        User user = new User();
        user.setFullname(fullname);
        user.setBirthDate(birth_date);

        return user;
    }

    @Override
    public User toUpdateEntity(User oldEntity) {
        oldEntity.setFullname(fullname);
        oldEntity.setBirthDate(birth_date);

        return oldEntity;
    }
}
