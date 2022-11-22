package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StageTest {

    @DisplayName("매 라운드마다 게임의 결과를 구할 수 있다. - FAIL")
    @Test
    void returnCompareResultOfPlayerMoved() {
        Stage stage = new Stage(1, "U");
        PlayResult result = stage.choose("D");
        assertThat(result).isEqualTo(PlayResult.FAIL);
    }
}
