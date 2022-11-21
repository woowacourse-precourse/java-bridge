package bridge.domain;

import bridge.constant.Message;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {

    private final String NEVER_MOVE_MAP_EXPECTED =
            Message.START_BRACKET+ Message.END_BRACKET + Message.NEW_LINE
                    + Message.START_BRACKET+ Message.END_BRACKET + Message.NEW_LINE;
    private BridgeMap bridgeMap;

    @BeforeEach
    private void setup() {
        bridgeMap = new BridgeMap();
    }

    @DisplayName("여러 이동상태 확인")
    @ParameterizedTest
    @CsvSource({"U,U,false,false,[ O | O ],[   |   ]", "U,U,false,true,[ O | X ],[   |   ]",
            "U,D,false,false,[ O |   ],[   | O ]", "U,D,false,true,[ O |   ],[   | X ]"})
    public void 이동상태_테스트(String direction1, String direction2,
            boolean status1, boolean status2, String upside, String downside) {
        List<String> directions = List.of(direction1, direction2);
        List<Boolean> gameStatus = List.of(status1, status2);

        for (int i = 0; i < directions.size(); i++) {
            bridgeMap.update(directions.get(i), gameStatus.get(i));
        }
        String expected = upside + Message.NEW_LINE + downside + Message.NEW_LINE;
        assertThat(bridgeMap.toString()).isEqualTo(expected);
    }

    @DisplayName("이동하지 않았을 때 이동 상태")
    @Test
    public void 이동없을_시_이동상태_테스트() {
        assertThat(bridgeMap.toString()).isEqualTo(NEVER_MOVE_MAP_EXPECTED);
    }
}
