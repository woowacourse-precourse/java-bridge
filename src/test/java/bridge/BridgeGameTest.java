package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("게임 상태가 진행 중일 때 - PROGRESSION 반환")
    @Test
    void givenBridgeListAndUserAnswerList_whenCompareEach_thenReturnProgressProgression() {
        //Given
        List<String> bridge = List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D");  // size : 12
        List<String> userAnswer = List.of("U", "D", "U", "D");

        //When
        Progress progress = compareBridgeAndUser(bridge, userAnswer, userAnswer.size() - 1);

        //Then
        assertThat(progress).isEqualTo(Progress.PROGRESSION);
    }

    @DisplayName("게임 상태가 진행 중일 때 - SUCCESS 반환")
    @Test
    void givenBridgeListAndUserAnswerList_whenCompareEach_thenReturnProgressSuccess() {
        //Given
        List<String> bridge = List.of("U", "D", "U", "D");
        List<String> userAnswer = List.of("U", "D", "U", "D");

        //When
        Progress progress = compareBridgeAndUser(bridge, userAnswer, userAnswer.size() - 1);

        //Then
        assertThat(progress).isEqualTo(Progress.SUCCESS);
    }

    @DisplayName("게임 상태가 진행 중일 때 - FAILURE 반환")
    @Test
    void givenBridgeListAndUserAnswerList_whenCompareEach_thenReturnProgressFailure() {
        //Given
        List<String> bridge = List.of("U", "D", "U", "D");
        List<String> userAnswer = List.of("U", "D", "U", "U");

        //When
        Progress progress = compareBridgeAndUser(bridge, userAnswer, userAnswer.size() - 1);

        //Then
        assertThat(progress).isEqualTo(Progress.FAILURE);
    }

    private Progress compareBridgeAndUser(List<String> bridge, List<String> userAnswer, int currentIndex) {
        if (bridge.get(currentIndex).equals(userAnswer.get(currentIndex))) {
            if (userAnswer.size() == bridge.size()) {
                return Progress.SUCCESS;
            }
            return Progress.PROGRESSION;
        }
        return Progress.FAILURE;
    }

}
