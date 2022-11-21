package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DirectionTest {

    @DisplayName("U는 위 방향을 의미한다.")
    @Test
    void directionUp() {
        //given
        String direction = "U";

        //when
        Direction up = Direction.UP;

        //then
        assertThat(up.getDirection()).isEqualTo(direction);
    }

    @DisplayName("D는 아래 방향을 의미한다.")
    @Test
    void directionDown() {
        //given
        String direction = "D";

        //when
        Direction down = Direction.DOWN;

        //then
        assertThat(down.getDirection()).isEqualTo(direction);
    }

    @DisplayName("0은 아래 방향을 생성하는 코드이다.")
    @Test
    void generateCodeDown() {
        //given
        int code = 0;

        //when
        Direction down = Direction.DOWN;

        //then
        assertThat(down.getGenerateCode() == code).isTrue();
    }

    @DisplayName("1은 위 방향을 생성하는 코드이다.")
    @Test
    void generateCodeUp() {
        //given
        int code = 1;

        //when
        Direction up = Direction.UP;

        //then
        assertThat(up.getGenerateCode() == code).isTrue();
    }

    @DisplayName("존재하는 방향이면 해당 방향을 반환한다.")
    @Test
    void getDirection() {
        //given
        Direction direction = Direction.UP;
        String input = direction.getDirection();

        //when
        Direction result = Direction.from(input);

        //then
        assertThat(result).isEqualTo(direction);
    }

    @DisplayName("존재하지 않는 방향이면 예외가 발생한다.")
    @ValueSource(strings = {"1", "@", " ", "u", "가"})
    @ParameterizedTest
    void getDirectionWithException(String input) {
        //then
        assertThatThrownBy(() -> Direction.from(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("존재하는 생성 코드면 해당 방향을 반환한다.")
    @Test
    void getDirectionByCode() {
        //given
        Direction direction = Direction.UP;
        int generateCode = direction.getGenerateCode();

        //when
        Direction result = Direction.by(generateCode);

        //then
        assertThat(result).isEqualTo(direction);
    }

    @DisplayName("존재하지 않는 생성 코드면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "999"})
    @ParameterizedTest
    void getDirectionByCodeWithException(int generateCode) {
        //then
        assertThatThrownBy(() -> Direction.by(generateCode)).isInstanceOf(
                IllegalStateException.class);
    }

}