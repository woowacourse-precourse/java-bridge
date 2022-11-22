package view;

import bridge.domain.BridgeGame;
import bridge.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @DisplayName("다리생성입력_숫자아니면_실패")
    @ValueSource(strings = {"a", "b", "!"})
    @ParameterizedTest()
    void 다리생성_입력_숫자_실패_테스트(String size) {
        assertThatThrownBy(() -> InputException.validateInputLength(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
