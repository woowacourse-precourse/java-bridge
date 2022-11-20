package bridge.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {
    private Round round;

    @BeforeEach
    void setUp() {
        round = new Round();
    }

    @Test
    @DisplayName("다리의 끝에 도달하지 않은 경우 게임 중이라는 상태를 반환한다.")
    void isReturnTrueWhenNotArrived() {
        //given
        boolean compareResult = true;
        int destinationIndex = 1;

        //when
        boolean result = round.isRoundPlaying(destinationIndex);

        //then
        assertThat(result).isEqualTo(compareResult);
    }

    @Test
    @DisplayName("다리의 끝에 도달한 경우 게임이 끝났다는 상태를 반환한다.")
    void isReturnFalseWhenArrived() {
        //given
        boolean compareResult = false;
        int destinationIndex = 0;
        String direction = "U";
        List<Integer> accessibleIndex = List.of(0);

        //when
        round.updateStatusAfterMove(direction, accessibleIndex);
        boolean result = round.isRoundPlaying(destinationIndex);

        //then
        assertThat(result).isEqualTo(compareResult);
    }
}
