package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveTest {

    private final static int UP_NUMBER = 1;
    private final static int DOWN_NUMBER = 0;
    private final static int ODD_NUMBER = 2;

    @DisplayName("위를 의미하는 숫자 1로  위치 '위'를 의미하는 'U'를 반환합니다.")
    @Test
    void UP_MOVE_생성_테스트() {
        int number = UP_NUMBER;

        String command = Move.getPositionByNumber(number);

        assertThat(command).isEqualTo("U");
    }
    
    @DisplayName("아래를 의미하는 숫자 0으로 위치 '아래'를 의미하는 'D'를 반환합니다.")
    @Test
    void DOWN_MOVE_생성_테스트() {
        int number = DOWN_NUMBER;

        String command = Move.getPositionByNumber(number);

        assertThat(command).isEqualTo("D");
    }

    @DisplayName("1 혹은 2가 아닌 숫자가 넘겨지면 예외를 발생시킵니다.")
    @Test
    void MOVE_COMMAND_생성_예외() {
        int number = ODD_NUMBER;

        assertThatCode(()->Move.getPositionByNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DOES_NOT_EXIST_POSITION_OF_NUMBER);
    }

    @DisplayName("문자 U가 주어지면 Move.UP을 반환합니다.")
    @Test
    void MOVE_UP_반환_테스트() {
        String userCommand = "U";

        Move move = Move.findByCommand(userCommand);

        assertThat(move).isEqualTo(Move.UP);
    }

    @DisplayName("문자 D가 주어지면 Move.DOWN을 반환합니다.")
    @Test
    void MOVE_DOWN_반환_테스트() {
        String userCommand = "D";

        Move move = Move.findByCommand(userCommand);

        assertThat(move).isEqualTo(Move.DOWN);
    }

    @DisplayName("'U' 혹은 'D'가 아닌 문자가 넘겨지면 예외를 발생시킵니다.")
    @Test
    void MOVE_생성_예외() {
        String userCommand = "A";

        assertThatCode(()->Move.findByCommand(userCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DOES_NOT_EXIST_GAME_COMMAND);
    }

}