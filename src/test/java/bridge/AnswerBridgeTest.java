package bridge;

import bridge.model.AnswerBridge;
import bridge.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerBridgeTest {

    AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));

    // TODO: 리팩토링
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

    @DisplayName("유저가 끝까지 도달했을 경우 테스트")
    @Test
    void isApproachEndTest() {
        User user = new User();
        user.addChoice("U");
        user.addChoice("D");
        user.addChoice("U");

        boolean result = answerBridge.isApproachEnd(user.getChoices());
        assertThat(result).isTrue();
    }

    @DisplayName("유저가 현재 선택한 결과를 반환하는 함수 테스트")
    @Test
    void isCorrect() {
        User user = new User();
        user.addChoice("U");
        boolean result = answerBridge.isCorrect(user);
        assertThat(result).isTrue();

        user.addChoice("U");
        result = answerBridge.isCorrect(user);
        assertThat(result).isFalse();
    }
}
