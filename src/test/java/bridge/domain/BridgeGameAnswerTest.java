package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameAnswerTest {

    private BridgeGameAnswer bridgeGameAnswer;
    private static final List<String> answer = List.of("U", "D", "U", "D");

    public BridgeGameAnswerTest() {
        bridgeGameAnswer = new BridgeGameAnswer(answer);
    }

    @DisplayName("정답을 확인하는 기능 테스트")
    @Test
    public void is_answer_test() {
        String collect = "U";
        String wrong = "D";
        int index = 0;
        boolean answer = true;
        boolean wrongAnswer = false;
        assertAll(
                () -> assertEquals(bridgeGameAnswer.isAnswer(collect, index), answer),
                () -> assertEquals(bridgeGameAnswer.isAnswer(wrong, index), wrongAnswer)
        );
    }

    @DisplayName("정답을 가져오는 테스트")
    @Test
    public void check_all_collect_result() {
        List<List<String>> answer = new ArrayList<>();
        answer.add(List.of(" O |", "   |"));
        answer.add(List.of("   |", " O |"));
        answer.add(List.of(" O |", "   |"));
        answer.add(List.of("   ", " O "));
        List<String> history = List.of("U", "D", "U", "D");
        List<List<String>> return_answer = bridgeGameAnswer.getMapByHistory(history);
        assertEquals(answer, return_answer);
    }

    @DisplayName("정답을 틀렸을때 테스트")
    @Test
    public void check_wrong_result() {
        List<List<String>> answer = new ArrayList<>();
        answer.add(List.of(" O |", "   |"));
        answer.add(List.of("   |", " O |"));
        answer.add(List.of(" O |", "   |"));
        answer.add(List.of(" X ", "   "));
        List<String> history = List.of("U", "D", "U", "U");
        List<List<String>> return_answer = bridgeGameAnswer.getMapByHistory(history);
        assertEquals(answer, return_answer);
    }
}