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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
