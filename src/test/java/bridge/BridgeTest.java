package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.Domain.Bridge;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void before() {
        List<String> answer = List.of("U", "D", "D");
        bridge = new Bridge(answer);
    }

    @AfterEach
    void after() {
        bridge.clear();
    }

    @DisplayName("현재 입력한 값이 이동할 수 있는 칸인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void matchAboutThisMovingTest(String input, boolean expected) {
        bridge.addMoving(input);
        assertThat(bridge.isMatchAboutLastMoving()).isEqualTo(expected);
    }

    @DisplayName("기존 입력된 값이 존재한 상태에서 현재 입력한 값이 이동할 수 있는 칸인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"D,true", "U,false"})
    void matchAboutLastMovingTest(String input, boolean expected) {
        bridge.clear();
        bridge.addMoving("U");
        bridge.addMoving(input);
        assertThat(bridge.isMatchAboutLastMoving()).isEqualTo(expected);
    }
}
