package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    void 정상작동(){
        User user = new User();
        user.setUserBridge("D");
        List<String> check = new ArrayList<>();
        check.add("D");
        Assertions.assertThat(user.getUserBridge()).isEqualTo(check);
    }

    @Test
    void init(){
        User user = new User();
        user.setUserBridge("D");
        user.init();
        Assertions.assertThat(user.getUserBridge()).isEqualTo(new ArrayList<>());
    }
}
