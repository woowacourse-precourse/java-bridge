package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.dto.BridgeCrossingDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    // given
    List<String> bridgeTest = new ArrayList<>(List.of("U", "D", "D"));
    Bridge bridge = new Bridge(bridgeTest);
    BridgeGame bridgeGame = new BridgeGame(bridge);

    @Test
    void 이동한_상태_테스트() {
        // when
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getCrossStatus())
            .isEqualTo(BridgeCrossingStatus.PROGRESS.getStatus());
        assertThat(bridgeCrossingDTO.getTryCount())
            .isEqualTo(1);
    }

    @Test
    void 재시작_후_상태_테스트() {
        // when
        bridgeGame.retry();
        bridgeGame.retry();
        bridgeGame.move("U");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getCrossStatus())
            .isEqualTo(BridgeCrossingStatus.PROGRESS.getStatus());
        assertThat(bridgeCrossingDTO.getTryCount())
            .isEqualTo(3);
    }

    @Test
    void 게임_진행_중인_위치_테스트() {
        // given
        List<String> expectedUpperTrack = new ArrayList<>(List.of("O", " "));
        List<String> expectedDownTrack = new ArrayList<>(List.of(" ", "O"));

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getFootPrint())
            .isEqualTo(new ArrayList<>(List.of(expectedUpperTrack, expectedDownTrack)));
    }

    @Test
    void 게임_성공인_위치_테스트() {
        // given
        List<String> expectedUpperTrack = new ArrayList<>(List.of("O", " ", " "));
        List<String> expectedDownTrack = new ArrayList<>(List.of(" ", "O", "O"));

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getFootPrint())
            .isEqualTo(new ArrayList<>(List.of(expectedUpperTrack, expectedDownTrack)));
    }

    @Test
    void 게임_실패인_위치_테스트() {
        // given
        List<String> expectedUpperTrack = new ArrayList<>(List.of("O", " ", "X"));
        List<String> expectedDownTrack = new ArrayList<>(List.of(" ", "O", " "));

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getFootPrint())
            .isEqualTo(new ArrayList<>(List.of(expectedUpperTrack, expectedDownTrack)));
    }

    @Test
    void 게임_재시작_후_진행_중인_위치_테스트() {
        // given
        List<String> expectedUpperTrack = new ArrayList<>(List.of("O", " "));
        List<String> expectedDownTrack = new ArrayList<>(List.of(" ", "O"));

        // when
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getFootPrint())
            .isEqualTo(new ArrayList<>(List.of(expectedUpperTrack, expectedDownTrack)));
    }

    @Test
    void 재시작_후_게임_성공인_위치_테스트() {
        // given
        List<String> expectedUpperTrack = new ArrayList<>(List.of("O", " ", " "));
        List<String> expectedDownTrack = new ArrayList<>(List.of(" ", "O", "O"));

        // when
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getFootPrint())
            .isEqualTo(new ArrayList<>(List.of(expectedUpperTrack, expectedDownTrack)));
    }

    @Test
    void 재시작_후_게임_실패인_위치_테스트() {
        // given
        List<String> expectedUpperTrack = new ArrayList<>(List.of("O", " ", "X"));
        List<String> expectedDownTrack = new ArrayList<>(List.of(" ", "O", " "));

        // when
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getFootPrint())
            .isEqualTo(new ArrayList<>(List.of(expectedUpperTrack, expectedDownTrack)));
    }
}
