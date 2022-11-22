package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    // 사용자 입력
    static void putSystemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * readBridgeSize - 다리의 길이 입력받기
     */
    @DisplayName("다리의 길이는 3 이상 ~ 20 이하의 숫자")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void readBridgeSize_테스트(String bridgeLength) {
        putSystemInput(bridgeLength);
        assertThat(Integer.parseInt(bridgeLength)).isEqualTo(InputView.readBridgeSize());
    }

    @DisplayName("다리의 길이 입력에 대한 예외처리")
    @ValueSource(strings = {"-11", "0", "21", "1아랄라0", "아랄라", "aralla"})
    @ParameterizedTest
    void readBridgeSize_예외_테스트(String input) {
        putSystemInput(input);
        assertSimpleTest(() ->
                assertThatThrownBy(InputView::readBridgeSize)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    /**
     * readMoving - 사용자가 이동할 칸 입력받기
     */
    @DisplayName("사용자가 이동할 수 있는 칸은 U 또는 D")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void readMoving_테스트(String userMoveDirection) {
        putSystemInput(userMoveDirection);
        assertThat(userMoveDirection).isEqualTo(InputView.readMoving());
    }

    @DisplayName("사용자가 이동할 칸 입력에 대한 예외처리")
    @ValueSource(strings = {"0", "1", "UU", "DD", "UD", "DU", "읶"})
    @ParameterizedTest
    void readMoving_예외_테스트(String userMoveDirection) {
        putSystemInput(userMoveDirection);
        assertSimpleTest(() ->
                assertThatThrownBy(InputView::readMoving)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    /**
     * readGameCommand - 사용자의 게임 재시작 또는 종료 여부 입력받기
     */
    @DisplayName("사용자의 게임 재시작 또는 종료 여부 입력은 R 또는 Q")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void readGameCommand_테스트(String userMoveDirection) {
        putSystemInput(userMoveDirection);
        assertThat(userMoveDirection).isEqualTo(InputView.readGameCommand());
    }

    @DisplayName("사용자의 재시작 또는 종료 입력에 대한 예외처리")
    @ValueSource(strings = {"0", "1", "RR", "QQ", "RQ", "QR", "읶"})
    @ParameterizedTest
    void readGameCommand_예외_테스트(String userMoveDirection) {
        putSystemInput(userMoveDirection);
        assertSimpleTest(() ->
                assertThatThrownBy(InputView::readGameCommand)
                        .isInstanceOf(IllegalStateException.class));
    }

}
