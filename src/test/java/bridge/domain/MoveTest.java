package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void values() {
        for (Move m : Move.values()) {
            System.out.println(m);
        }
    }

    @DisplayName("정상 커맨드 입력")
    @ValueSource(strings = {"U", "D", "0", "1"})
    @ParameterizedTest
    void goodCommand(String c) {
        Move move = Move.from(c);
        if (c.equals("0")) {
            c = "D";
        }
        if (c.equals("1")) {
            c = "U";
        }
        assertThat(move.getDirection()).isEqualTo(c);
    }

    @DisplayName("정상 커맨드 숫자 입력")
    @ValueSource(ints = {0, 1})
    @ParameterizedTest
    void goodCommandInt(int n) {
        Move move = Move.from(n);
    }

    @DisplayName("비정상 커맨드 입력")
    @ValueSource(strings = {"A", "B", "C", "d", "E", "F", "Z", "u", "3", "4", "QQ", "RR", "", " ", "\n"})
    @ParameterizedTest
    void badCommand(String c) {
        assertThrows(IllegalArgumentException.class, () -> {
            Move move = Move.from(c);
        });
    }

    @DisplayName("비정상 커맨드 숫자 입력")
    @ValueSource(ints = {2, 3, 4, 5, 6})
    @ParameterizedTest
    void badCommandInt(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            Move move = Move.from(n);
        });
    }

}
