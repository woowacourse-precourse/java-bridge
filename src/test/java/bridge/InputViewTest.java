package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
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
    void 사용자_입력_오류(String inputSize) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputSize.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }
}