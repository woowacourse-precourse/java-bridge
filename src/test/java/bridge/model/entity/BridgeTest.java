package bridge.model.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @DisplayName("Birdge 생성시 사이즈 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 다리생성시_사이즈_테스트_작성(int size) {
        Bridge bridge = new Bridge(size);
        assertThat(bridge.getAnswer().size()).isEqualTo(size);
    }

}