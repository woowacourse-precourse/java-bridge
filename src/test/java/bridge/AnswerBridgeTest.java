package bridge;

import bridge.model.AnswerBridge;
import bridge.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerBridgeTest {

    AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));

    @DisplayName("유저의 선택과 answerBridge 비교 결과 테스트")
    @Test
    void compareToTest() {
        User user = new User();

        List<Boolean> firstResult = answerBridge.compareTo(user);
        assertThat(firstResult).isEmpty();

        user.addChoice("U");
        List<Boolean> secondResult = answerBridge.compareTo(user);
        assertThat(secondResult).isEqualTo(List.of(true));

        user.addChoice("D");
        List<Boolean> thirdResult = answerBridge.compareTo(user);
        assertThat(thirdResult).isEqualTo(List.of(true, true));

        user.addChoice("D");
        List<Boolean> fourthResult = answerBridge.compareTo(user);
        assertThat(fourthResult).isEqualTo(List.of(true, true, false));
    }
}
