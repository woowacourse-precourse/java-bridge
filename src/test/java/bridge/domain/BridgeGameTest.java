package bridge.domain;

import bridge.domain.vo.BridgeGameResult;
import bridge.domain.vo.Moving;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.vo.BridgeGameResult.confirmGameResult;
import static bridge.domain.vo.Moving.recordMoving;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("유저가 입력한 값에 따라서 생성된 bridge와의 일치 여부 결정된다.")
    @ParameterizedTest
    @MethodSource("moveTestData")
    void moveTest(String movingInput, String bridgeRoomInput, boolean answer) {
        Moving userMoving = recordMoving(movingInput);
        Moving bridgeRoom = recordMoving(bridgeRoomInput);

        assertThat(bridgeGame.computeGameResult(userMoving, bridgeRoom).getIsMatched())
                .isEqualTo(answer);
    }

    @DisplayName("BridgeGameResult가 총 다리의 길이만큼 들어있으며, 마지막 BridgeGameResult의 isMatched가 true이면 true을, 그 외에는 false를 return한다.")
    @ParameterizedTest
    @MethodSource("isSuccessTestData")
    void isSuccessTest(List<BridgeGameResult> bridgeGameResults, int bridgeSize, boolean answer) {

        assertThat(bridgeGame.isSuccess(bridgeGameResults, bridgeSize))
                .isEqualTo(answer);
    }

    @DisplayName("bridgeIndex와 bridgeSize가 같으면 false를, 그 외에는 bridgeGameResult의 isMatched를 return한다.")
    @ParameterizedTest
    @MethodSource("isContinueTestData")
    void isContinueTest(BridgeGameResult bridgeGameResult, List<Integer> bridgeIndexInfo, boolean answer) {
        int bridgeIndex = bridgeIndexInfo.get(0);
        int bridgeSize = bridgeIndexInfo.get(1);

        assertThat(bridgeGame.isContinue(bridgeGameResult, bridgeIndex, bridgeSize))
                .isEqualTo(answer);
    }

    static Stream<Arguments> moveTestData() {
        return Stream.of(
                Arguments.of("D", "D", true),
                Arguments.of("U", "D", false),
                Arguments.of("U", "U", true),
                Arguments.of("D", "U", false),
                Arguments.of("D", "D", true)
        );
    }

    static Stream<Arguments> isSuccessTestData() {
        List<BridgeGameResult> successCase = List.of(confirmGameResult(true, "U"), confirmGameResult(true, "U"), confirmGameResult(true, "D"));
        List<BridgeGameResult> failCaseOne = List.of(confirmGameResult(true, "D"), confirmGameResult(false, "U"));
        List<BridgeGameResult> failCaseTwo = List.of(confirmGameResult(true, "D"), confirmGameResult(true, "U"), confirmGameResult(false, "U"));
        return Stream.of(
                Arguments.of(successCase, 3, true),
                Arguments.of(failCaseOne, 3, false),
                Arguments.of(failCaseTwo, 3, false)
        );
    }

    static Stream<Arguments> isContinueTestData() {
        return Stream.of(
                Arguments.of(confirmGameResult(true, "U"), List.of(3,4), true),
                Arguments.of(confirmGameResult(true, "U"), List.of(3,3), false),
                Arguments.of(confirmGameResult(false, "U"), List.of(3,3), false)
        );
    }
}