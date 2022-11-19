package bridge.model.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @DisplayName("Birdge 생성시 사이즈 확인")
    @Test
    void 다리생성시_사이즈_테스트_작성() {
        List<String> answer = List.of("U", "D", "U", "D");
        Bridge bridge = Bridge.of(answer);
        int expectSize = 4;
        assertThat(bridge.getAnswer().size()).isEqualTo(expectSize);
    }

}