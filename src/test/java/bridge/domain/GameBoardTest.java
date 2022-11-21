package bridge.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static bridge.constant.Constants.BridgeSign.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest extends NsTest {
    GameBoard gameBoard1;
    GameBoard gameBoard2;
    GameBoard gameBoard3;

    @BeforeEach
    void setup() {
        gameBoard1 = new GameBoard(List.of(PASS, EMPTY, FAIL));
        gameBoard2 = new GameBoard(List.of(EMPTY, PASS, EMPTY));
        gameBoard3 = new GameBoard(List.of(EMPTY, FAIL, PASS));
    }

    @DisplayName("이동 결과 입력 테스트")
    @Test
    void addMovingResultTest() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("[ O |   | X ]");
            assertThat(output()).contains("[   | O |   ]");
            assertThat(output()).contains("[   | X | O ]");
        });
    }

    @Override
    protected void runMain() {
        System.out.println(gameBoard1.createMap());
        System.out.println(gameBoard2.createMap());
        System.out.println(gameBoard3.createMap());
    }
}