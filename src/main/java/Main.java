import config.DbConfig;
import model.User;
import model.UserService;
import model.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DbConfig.class);
        UserService us = context.getBean(UserService.class);
        //User user = us.readUser(1L);
        us.createUser(new User("Иван"    , "Иванов"    ,(byte) 25) );
        us.createUser(new User("Сергей"  , "Сергеев"   ,(byte) 45) );
        us.createUser(new User("Митрофан", "Митрофанов",(byte) 78) );
        us.createUser(new User("Петр"    , "Петров"    ,(byte) 12) );
        List<User> lu = us.getAllUsers();
        for (User user: lu) {
            System.out.println(user.getName());
        }
    }
}
