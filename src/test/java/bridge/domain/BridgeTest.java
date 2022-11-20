package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeTest {

    private Bridge bridge;
    private List<String> userMoved;

    @BeforeEach
    void initialize() {
        bridge = new Bridge(new ArrayList<>(List.of("U", "U", "D", "U", "D", "D", "D", "U")));
        userMoved = new ArrayList<>(List.of("U", "U", "D", "D", "D", "U", "D", "D"));
    }

    @DisplayName("canMove 메서드에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "0:true",
            "1:true",
            "2:true",
            "3:false",
            "4:true",
            "5:false",
            "6:true",
            "7:false"
    }, delimiter = ':')
    void canMoveTest(int idx, boolean expected) {
        assertThat(bridge.canMove(userMoved, idx)).isEqualTo(expected);
    }
}
