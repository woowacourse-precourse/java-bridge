package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class InputViewTest {

    private static final InputView inputView = new InputView();

    @DisplayName("다리 사이즈를 입력받아서 반환")
    @Test
    void inputBridgeSize() {
        InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","21","4j"})
    @DisplayName("올바르지 않은 입력값")
    void 사용자_다리생성_입력_오류(String inputSize) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputSize.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 입력을 받으면 예외 반환")
    @ValueSource(strings = {"x", "d", "d3"})
    @ParameterizedTest
    void 사용자_다리이동입력_오류(String inputShape) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputShape.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }
}