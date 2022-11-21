package bridge;

import bridge.model.AnswerBridge;
import bridge.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerBridgeTest {

    AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));
    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @DisplayName("유저의 선택과 answerBridge 비교 결과 테스트 - ")
    @Test
    void compareToTest_empty() {
        List<Boolean> firstResult = makeSituation("U");
        assertThat(firstResult).isEqualTo(List.of(true));

        List<Boolean> secondResult = makeSituation("D");
        assertThat(secondResult).isEqualTo(List.of(true, true));

        List<Boolean> thirdResult = makeSituation("D");
        assertThat(thirdResult).isEqualTo(List.of(true, true, false));
    }

    private List<Boolean> makeSituation(String choice) {
        user.addChoice(choice);
        return answerBridge.compareTo(user.getChoices());
    }

    @DisplayName("유저가 끝까지 도달했을 경우 테스트")
    @Test
    void isApproachEndTest() {
        user.addChoice("U");
        user.addChoice("D");
        user.addChoice("U");
        boolean result = answerBridge.isApproachEndPoint(user.getChoices());
        assertThat(result).isTrue();
    }

    @DisplayName("유저가 현재 선택한 결과를 반환하는 함수 테스트")
    @Test
    void isCorrect() {
        user.addChoice("U");
        boolean result = answerBridge.isCorrectChoice(user.getStep(), user.getLastChoice());
        assertThat(result).isTrue();

        user.addChoice("U");
        result = answerBridge.isCorrectChoice(user.getStep(), user.getLastChoice());
        assertThat(result).isFalse();
    }
}
