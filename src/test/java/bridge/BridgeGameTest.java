package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import repository.BridgeRepository;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    BridgeRepository bridgeRepository;
    BridgeGame bridgeGame;

    @BeforeEach
    public void beforeEach() {
        bridgeRepository = new BridgeRepository();
        bridgeGame = new BridgeGame(bridgeRepository);
    }

    @DisplayName("잘못된 다리 길이 입력에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "2", "21", "15.", "2.5", " ", "십오", "four", ""})
    void 다리_길이_입력_예외_발생(String bridgeSize) {
        assertThatThrownBy(() -> bridgeGame.generateBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 이동할 칸 입력에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" ", "UU", "위", "up", "u", "d", ""})
    void 이동칸_입력_예외_발생(String direction) {
        assertThatThrownBy(() -> bridgeGame.move(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 성공 확인")
    @Test
    void 이동_성공() {
        List<String> bridge = List.of("U", "D", "D", "U", "D");
        List<String> progress = List.of("U", "D", "D", "U", "D");
        bridgeRepository.saveBridge(bridge);

        IntStream.range(0, progress.size())
                .forEach(i -> {
                    bridgeRepository.saveProgress(progress.get(i));
                    assertThat(bridgeGame.canMove()).isEqualTo(true);
                });
    }

    @DisplayName("이동 실패 확인")
    @Test
    void 이동_실패() {
        List<String> bridge = List.of("U", "D", "D", "U", "D");

        bridgeRepository.saveBridge(bridge);
        bridgeRepository.saveProgress("D");

        assertThat(bridgeGame.canMove()).isEqualTo(false);
    }
}
