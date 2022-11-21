package bridge.view;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputViewTest extends NsTest {
    private InputView inputView = new InputView();

    @DisplayName("다리 길이 입력 받기 테스트")
    @ParameterizedTest
    @CsvSource({"3,true", "20,true", "2,false", "21,false", "3a,false", "four,false"})
    void validateBridgeSizeTest(String input, boolean result) {
        Assertions.assertThat(inputView.validateBridgeSize(input)).isEqualTo(result);
    }

    @DisplayName("이동할 칸 입력 받기 테스트")
    @ParameterizedTest
    @CsvSource({"U,true", "D,true", "1,false", "UP,false", "u,false", "d,false"})
    void validateMoveTest(String input, boolean result) {
        Assertions.assertThat(inputView.validateMove(input)).isEqualTo(result);
    }

    @DisplayName("게임 재시작 여부 입력 받기 테스트")
    @ParameterizedTest
    @CsvSource({"R,true", "Q,true", "1,false", "RETRY,false", "r,false", "q,false", "R1, false"})
    void validateGameCommandTest(String input, boolean result) {
        Assertions.assertThat(inputView.validateGameCommand(input)).isEqualTo(result);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
