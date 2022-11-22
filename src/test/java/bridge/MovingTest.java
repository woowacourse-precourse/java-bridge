package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.enums.BridgeMoving;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MovingTest {
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void 정상값_view(String str) {
        List<String> cellNames = Stream.of(BridgeMoving.values())
                .map(BridgeMoving::name)
                .collect(Collectors.toList());
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(str.getBytes()));
        assertThat(cellNames).contains(inputView.readMoving());
    }

    @ValueSource(strings = {"1", "hello", "A"})
    @ParameterizedTest
    void 틀린값_view(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
