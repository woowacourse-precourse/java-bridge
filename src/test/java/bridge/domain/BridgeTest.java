package bridge.domain;

import bridge.domain.Bridge;
import bridge.domain.MoveDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {
    private static final String INVALID_LENGTH_RANGE_MESSAGE = "[ERROR] 다리 길이는 3이상 20이하의 숫자를 입력해주세요.";

    @DisplayName("다리 길이가 3미만일 경우 예외가 발생하는지 테스트")
    @Test
    void validateLengthRangeByUnder3() {
        assertThatThrownBy(() -> {
                      new Bridge(List.of("U", "D"));
                  })
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining(INVALID_LENGTH_RANGE_MESSAGE);
    }

    @DisplayName("다리 길이가 20초과일 경우 예외가 발생하는지 테스트")
    @Test
    void validateLengthRangeByOver20() {
        List<String> bridgeAnswers = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            bridgeAnswers.add("U");
        }

        assertThatThrownBy(() -> {
            new Bridge(bridgeAnswers);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LENGTH_RANGE_MESSAGE);
    }

    @DisplayName("다리 정답 리스트의 n번째 정답 값과 사용자가 n번째에 입력한 값이 정답과 일치하는지 테스트")
    @Test
    void isAnswer() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        MoveDirection direction = new MoveDirection("U");
        int index = 2;
        //when
        boolean answer = bridge.isAnswer(direction, index);
        //then
        assertThat(answer)
                .isTrue();
    }

    @DisplayName("사용자가 오답에 해당하는 이동 방향을 입력했을 때 거짓을 반환하는지 테스트")
    @Test
    void isWrongAnswer() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        MoveDirection direction = new MoveDirection("D");
        int index = 0;
        //when
        boolean isAnswer = bridge.isAnswer(direction, index);
        //then
        assertThat(isAnswer).isFalse();
    }
}