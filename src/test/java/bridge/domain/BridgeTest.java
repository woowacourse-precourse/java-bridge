package bridge.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    private static Bridge bridge;

    @BeforeAll
    static void setup() {
        bridge = new Bridge(List.of("U", "U", "D"));
    }

    @Test
    void 정답이면_Bridge와_History_일치() {
        //given
        History history = new History(List.of("U", "U", "D"));
        //when
        boolean isCorrect = bridge.isCorrect(history);
        //then
        assertThat(isCorrect).isTrue();
    }

    @Test
    void 정답아니면_Bridge와_History_부분적_일치() {
        //given
        History history = new History(List.of("U", "U"));
        //when
        boolean isContinue = bridge.isContinue(history);
        //then
        assertThat(isContinue).isTrue();
    }
}