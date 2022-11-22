package bridge;

import bridge.domain.Bridge;
import bridge.type.BridgeGameCommandType;
import bridge.type.BridgeSideType;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridge = new Bridge();

        bridge.registerBridge(List.of(BridgeSideType.UPPER_SIDE.getSide(), BridgeSideType.LOWER_SIDE.getSide(), BridgeSideType.LOWER_SIDE.getSide()));
        bridgeGame.registerBridge(List.of(BridgeSideType.UPPER_SIDE.getSide(), BridgeSideType.LOWER_SIDE.getSide(), BridgeSideType.LOWER_SIDE.getSide()));
    }

    @DisplayName("이동한 칸이 맞을 경우 `O`를 틀릴경우 `X`를 다리 출력 객체에 추가하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"U:[ O ]:[   |   ]", "D:[   ]:[ X | O ]"}, delimiter = ':')
    void moveTest(String bridgeSide, String upperBridgeMap, String lowerBridgeMap) {
        assertThat(bridgeGame.move(bridgeSide).getUpperBridgeToString()).isEqualTo(upperBridgeMap);
        assertThat(bridgeGame.move(bridgeSide).getLowerBridgeToString()).isEqualTo(lowerBridgeMap);
    }

    @DisplayName("재시작시 새로운 출력 객체를 생성해 초기화하는 테스트")
    @Test
    void retryTest() {
        bridgeGame.move(BridgeSideType.UPPER_SIDE.getSide());
        assertThat(bridgeGame.move(BridgeSideType.LOWER_SIDE.getSide()).getLowerBridgeToString().length())
                .isEqualTo(9);//두 번 다리를 건넌만큼의 다리 출력 객체를 가진다.(즉 string의 길이가 9)

        bridgeGame.retry(BridgeGameCommandType.RESTART);
        assertThat(bridgeGame.move(BridgeSideType.UPPER_SIDE.getSide()).getLowerBridgeToString().length())
                .isEqualTo(5);//초기화 후 한번 다리를 건넌만큼의 다리 출력 객체를 가진다.(즉 string의 길이가 5)
    }

    @DisplayName("게임 중간에 틀리면 끝나는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    void isFinishByWrongSelectTest(String bridgeSide, boolean result) {
        bridgeGame.move(bridgeSide);
        assertThat(bridgeGame.isFinish(bridgeSide))
                .isEqualTo(result);
    }

    @DisplayName("모두 성공했을 경우와 실패했을 경우 결과 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"D:성공", "U:실패"}, delimiter = ':')
    void isFinishSuccessTest(String bridgeSide, String result) {
        for (int loopCount = 0; loopCount < bridge.getBridge().size(); loopCount++) {
            bridgeGame.move(bridge.getBridge().get(loopCount));
        }
        bridgeGame.isFinish(bridgeSide);
        bridgeGame.getChallengeCount();
        assertThat(bridgeGame.getChallengeResultToString())
                .isEqualTo(result);
    }
}
