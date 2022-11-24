package bridge.domain;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    List<String> bridgeFrame;

    @BeforeEach
    void setup() {
        bridgeFrame = new ArrayList<>(List.of("U", "U", "D"));
    }

    @DisplayName("정해준 인덱스 상의 스트링 값을 비교한다")
    @CsvSource(value = {"1:U:true", "0:D:false"}, delimiter = ':')
    @ParameterizedTest
    void compareStringAndReturnBooleanValue(int index, String command, boolean expected) {
        Bridge bridge = Bridge.from(bridgeFrame);

        assertThat(bridge.compare(command, index)).isEqualTo(expected);
    }

    @DisplayName("다음 건널 위치를 맞췄을때의 게임 결과를 반환한다.")
    @CsvSource(value = {"0:U", "1:U"}, delimiter = ':')
    @ParameterizedTest
    void returnMatchedPathResult(int index, String expected) {
        Bridge bridge = Bridge.from(bridgeFrame);
        GameResult result = bridge.getMatchedPathResult(index + 1);

        assertThat(result.getResult().get(index)).isEqualTo(expected);
        assertThat(result.getNextViewStatus()).isEqualTo(ViewStatus.DETERMINE_MOVE);
    }

    @DisplayName("모든 위치를 맞추었을 때 게임 결과를 반환한다.")
    @CsvSource(value = {"2:D"}, delimiter = ':')
    @ParameterizedTest
    void returnAllMatchedPathResult(int index, String expected) {
        Bridge bridge = Bridge.from(bridgeFrame);
        GameResult result = bridge.getMatchedPathResult(index + 1);

        assertThat(result.getResult().get(index)).isEqualTo(expected);
        assertThat(result.getNextViewStatus()).isEqualTo(ViewStatus.WIN);
    }

    @DisplayName("다음 건널 위치를 틀렸을 때의 게임 결과를 반환한다.")
    @CsvSource(value = {"0:D", "1:D", "2:U"}, delimiter = ':')
    @ParameterizedTest
    void returnUnMatchedPathResult(int index, String expected) {
        Bridge bridge = Bridge.from(bridgeFrame);
        GameResult result = bridge.getUnMatchedPathResult(index + 1);

        assertThat(result.getResult().get(index)).isNotEqualTo(expected);
        assertThat(result.getNextViewStatus()).isEqualTo(ViewStatus.DETERMINE_RETRY);
    }
}