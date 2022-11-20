package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    private Round round = new Round();

    @DisplayName("현재 첫 라운드이면 true를 반환한다.")
    @Test
    void checkFirstRoundReturnTrue() {
        // when
        boolean firstRound = round.checkRoundFirst();

        // then
        Assertions.assertThat(firstRound).isTrue();
    }
}