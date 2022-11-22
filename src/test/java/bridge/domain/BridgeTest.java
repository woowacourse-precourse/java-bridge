package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

public class BridgeTest {
    private Bridge bridge;
    private PositionTable userTable;
    @BeforeEach
    public void setUp() {
        bridge = Bridge.of(List.of("U","D"));
        userTable = PositionTable.newInstance();

    }
    @DisplayName("다리의 길이가 3이상 20이하가 아닐경우 예외 발생")
    @ParameterizedTest
    @CsvSource({"U,KEEP","D,LOSE"})
    public void bridgeTest(String position, String result) {
        userTable.add(Position.of(position));
        assertThat(bridge.play(userTable)).isEqualTo(GameResult.valueOf(result));
    }
    @Test
    public void bridgeTest() {
        userTable.add(Position.of("U"));
        userTable.add(Position.of("D"));
        assertThat(bridge.play(userTable)).isEqualTo(GameResult.WIN);
    }
}
