package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {
    private Bridge bridge;
    @BeforeEach
    public void setUp() {
        bridge = Bridge.of(List.of("U","D"));
    }
    @ParameterizedTest
    @CsvSource({"1,U,KEEP","2,D,WIN","2,U,LOSE"})
    public void bridgeTest(int distance, String verticalStatus, String result) {
        assertThat(bridge.play(Position.of(distance,verticalStatus))).isEqualTo(Result.valueOf(result));
    }
}
