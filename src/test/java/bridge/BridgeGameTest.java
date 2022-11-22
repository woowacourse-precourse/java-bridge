package bridge;

import bridge.command.RestartCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    static final int MAX_BRIDGE_SIZE = 20;

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    GameStatus gameStatus = new GameStatus(false, false);
    BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(MAX_BRIDGE_SIZE)), gameStatus);

    @DisplayName("사용자가 U과 D을 선택하였을때 이를 순서대로 기록하는지 테스트")
    @Test
    void U과_D를_선택하였을때_입력순서대로_List에_기록() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getMovingPositions()).isEqualTo(List.of("U", "D"));
    }

    @DisplayName("사용자가 U나 D가 아닌 다른 문자를 입력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"X", "Z", "u", "d", "K", "ESC", "12"})
    void 사용자가_지정되지_않은_방향을_입력한_경우_예외발생(String key) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bridgeGame.move(key));
    }

    @DisplayName("사용자가 다리를 맞춸을땐 O를, 틀렸을 땐 X를 결과에 추가한다.")
    @Test
    void 실제_다리와_사용자의_입력이_동일한지_확인() {
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        BridgeGame bridgeGame1 = new BridgeGame(bridge, new GameStatus(false, false));
        for (int i = 0; i < 3; i++) {
            bridgeGame1.move("U");
            bridgeGame1.comparedBridge();
        }
        assertThat(bridgeGame1.getResult()).isEqualTo(List.of("O", "O", "X"));
    }

    @DisplayName("비이상적인 실행으로 다리의 크기보다 사용자의 입력받은 크기가 더 클떄 예외 발생")
    @Test
    void 다리의_크기보다_이동경로의_크기가_더_크면_예외발생() {
        for (int i = 0; i <= MAX_BRIDGE_SIZE; i++) {
            bridgeGame.move("U");
        }
        assertThatIllegalStateException()
                .isThrownBy(() -> bridgeGame.comparedBridge())
                .withMessage("다리의 크기보다 입력받은 개수가 클 수 없습니다.");
    }

    @DisplayName("사용자가 R을 눌렀을때 브릿지를 제외하고 초기화한다.")
    @Test
    void 사용자가_R을_입력할시_다리를_제외하고_초기화() {
        //given
        String input = "R";
        //when
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        GameStatus gameStatus = new GameStatus(false, false);
        BridgeGame bridgeGame1 = new BridgeGame(bridge, gameStatus);
        for (int i = 0; i < 3; i++) {
            bridgeGame1.move("U");
            bridgeGame1.comparedBridge();
        }
        bridgeGame1.retry(input);
        //then
        assertThat(bridgeGame1.getMovingPositions()).isEqualTo(List.of());
        assertThat(bridgeGame1.getResult()).isEqualTo(List.of());
        assertThat(gameStatus.isClear()).isFalse();
        assertThat(gameStatus.isFailure()).isFalse();
    }

    @DisplayName("사용자가 Q를 눌렀을 때 GameStatus의 clear를 true로 변경한다.")
    @Test
    void 사용자가_Q를_입력할시_CLEAR를_TRUE로_변경() {
        //given
        String input = "Q";
        //when
        bridgeGame.retry(input);
        //then
        assertThat(gameStatus.isClear()).isTrue();
    }

    @DisplayName("사용자가 지나치게 많은 재시도를 할 시 Overflow에 의한 예외발생")
    @Test
    void 사용자가_지나치게_많은_RETRY를_할시_예외발생() {
        //given
        //when
        for (int i = 0; i < Integer.MAX_VALUE - 1; i++) {
            bridgeGame.retry("R");
        }
        //then
        assertThatThrownBy(() -> bridgeGame.retry("R")).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("사용자가 R, Q가 아닌 다른 명령어를 입력했을 시 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"r", "RQ", "u", "d", "K", "ESC", "12"})
    void 사용자가_R_Q가_아닌_다른_명령어를_입력시_예외발생(String command) {
        assertThatThrownBy(() -> bridgeGame.retry(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재시도는 \""
                        + RestartCommand.RESTART.getCommand()
                        + "\" , 종료는 \""
                        + RestartCommand.QUIT.getCommand() + "\"를 누르셔야 합니다.");
    }
}