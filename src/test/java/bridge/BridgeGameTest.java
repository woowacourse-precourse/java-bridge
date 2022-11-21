package bridge;

import bridge.dto.BridgeStatusDto;
import bridge.dto.SuccessOrFailureDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private static BridgeGame getBridgeGame(ArrayList<String> bridge,ArrayList<String> footprints) {
        BridgeGame bridgeGame = new BridgeGame(bridge, footprints);
        return bridgeGame;
    }

    @Test
    void 하단이동_테스트() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("D").getBridge()).isEqualTo("[   ]\n[ O ]\n");
    }

    @Test
    void 상단이동_테스트() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("U","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("U").getBridge()).isEqualTo("[ O ]\n[   ]\n");
    }

    @Test
    void 하단이동_테스트_실패() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("U","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("D").getBridge()).isEqualTo("[   ]\n[ X ]\n");
    }

    @Test
    void 상단이동_테스트_실패() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("U").getBridge()).isEqualTo("[ X ]\n[   ]\n");
    }

    @Test
    void 잘못된_입력() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        assertThatThrownBy(()->bridgeGame.move("T")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다시시작_한다_선택() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        boolean retry = bridgeGame.retry("R");
        assertThat(retry).isTrue();
    }

    @Test
    void 다시시작_안한다_선택() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        boolean retry = bridgeGame.retry("Q");
        assertThat(retry).isFalse();
    }

    @Test
    void 다시시작_잘못된_입력() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        assertThatThrownBy(()->bridgeGame.retry("D")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최종점_도착_성공() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>(Arrays.asList("D","D","D")));
        assertThat(bridgeGame.isOverallSuccess()).isTrue();
    }

    @Test
    void 최종점_도착_하지않음() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>(Arrays.asList("D")));
        assertThat(bridgeGame.isOverallSuccess()).isFalse();
    }

    @Test
    void 성공시의_DTO() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>(Arrays.asList("D")));
        BridgeStatusDto bridgeStatusDto = new BridgeStatusDto(new SuccessOrFailureDto("[   ]\n[ O ]\n","성공"),1);
        assertThat(bridgeGame.makeSuccessBridgeStatusDto()).isEqualTo(bridgeStatusDto);
    }

    @Test
    void 실패시의_DTO() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>(Arrays.asList("U")));
        BridgeStatusDto bridgeStatusDto = new BridgeStatusDto(new SuccessOrFailureDto("[ X ]\n[   ]\n","실패"),1);
        assertThat(bridgeGame.makeFailBridgeStatusDto()).isEqualTo(bridgeStatusDto);
    }

    @Test
    void 부분게임성공() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>(Arrays.asList("D")));
        assertThat(bridgeGame.isUnitSuccess()).isTrue();
    }

    @Test
    void 부분게임실패() {
        BridgeGame bridgeGame = getBridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>(Arrays.asList("U")));
        assertThat(bridgeGame.isUnitSuccess()).isFalse();
    }
}