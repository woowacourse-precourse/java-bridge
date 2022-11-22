package bridge;

import bridge.domain.Moving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {
    private final Moving moving = new Moving();

    @DisplayName("이동 칸과 건널 수 있는 다리의 위치의 동일 여부에 따라 값을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"D,D,"+true, "U,D,"+false})
    void checkRight(String input, String bridge, boolean expected){
        moving.checkRight(input,bridge);
        assertThat(moving.isRight()).isEqualTo(expected);
    }

    @DisplayName("값이 동일하지 않으면 X를 저장한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U","D"})
    void checkUp(String input){
        moving.setRight(false);
        moving.checkUp(input);
        assertThat(moving.getUp().equals(Arrays.asList("X"," ")));
    }

    @DisplayName("값이 동일하면 O를 저장한다.")
    @ParameterizedTest
    @ValueSource(strings = {"D","D","U"})
    void checkDown(String input){
        moving.setRight(true);
        moving.checkDown(input);
        assertThat(moving.getDown().equals(Arrays.asList("O","O"," ")));
    }
}
