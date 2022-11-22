package bridge.vo;

import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserStatusTest {

    private InputView inputView = new InputView();
    private UserStatus userStatus = new UserStatus();

    @DisplayName("플레이어가 이동한 방향을 저장한다.")
    @Test
    void 플레이어의_이동_방향_저장() {
        String userDirectInputs = "U\nD\nU\nU\n";
        initInputStream(userDirectInputs);

        for (int length = 0; length < userDirectInputs.length() / 2; length++) {
            userStatus.addCrossedHistory(inputView.readMoving());
        }

        Assertions.assertThat(userStatus.getCurrentCrossedBridge()).containsExactly("U", "D", "U", "U");
    }

    void initInputStream(String userDirectInputs) {
        InputStream in = new ByteArrayInputStream(userDirectInputs.getBytes());
        System.setIn(in);
    }
}
