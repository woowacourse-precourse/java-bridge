package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("유저의 움직임을 테스트 한다.")
    @ParameterizedTest
    @MethodSource("generatedMoveTestData")
    void move(List<String> userWantedDirection, Status expectedStatus) {
        BridgeGame bridgeGame = setUpBridge();
        for (String movedDirection : userWantedDirection) {
            bridgeGame.move(movedDirection);
        }

        int expectedLocation = userWantedDirection.size();
        assertThat(bridgeGame.getStatus()).isEqualTo(expectedStatus);
        assertThat(bridgeGame.getNowLocation()).isEqualTo(expectedLocation);
    }

    @DisplayName("유저가 다시 게임을 실행하는 경우를 테스트 한다.")
    @ParameterizedTest
    @MethodSource("generatedRetryTestData")
    void retry(List<String> userWantedDirection) {
        BridgeGame bridgeGame = setUpBridge();
        for (String movedDirection : userWantedDirection) {
            bridgeGame.move(movedDirection);
        }
        //움직이고 난후 Fail 상태에서 Retry 하여 변경 되는 것을 확인
        bridgeGame.retry();
        assertThat(bridgeGame.getStatus()).isEqualTo(Status.PLAYING);
        assertThat(bridgeGame.getNowLocation()).isEqualTo(0);
        assertThat(bridgeGame.getChallengesCnt()).isEqualTo(2);
    }

    BridgeGame setUpBridge() {
        return new BridgeGame(Arrays.asList("U", "D", "U"));
    }

    static Stream<Arguments> generatedMoveTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "D", "U"), Status.ENDING),
                Arguments.of(Arrays.asList("U", "U"), Status.FAIL),
                Arguments.of(List.of("U"), Status.PLAYING)
        );
    }

    static Stream<Arguments> generatedRetryTestData() {
        return Stream.of(
                Arguments.of(List.of("D")),
                Arguments.of(Arrays.asList("U", "U"))
        );
    }
}