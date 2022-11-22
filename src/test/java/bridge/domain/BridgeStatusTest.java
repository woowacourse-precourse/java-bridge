package bridge.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("다리 상태 도메인 로직 테스트")
public class BridgeStatusTest {
    private final BridgeStatus bridgeStatus = new BridgeStatus();

    @BeforeEach
    void initBridgeStatus() {
        bridgeStatus.init();
    }

    @DisplayName("이동 방향과 성공 여부에 맞게 상태가 업데이트 되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("BridgeStatusData")
    void checkInitBridgeStatus(Direction direction, PlayerStatus status, String expectedBridgeStatus) {
        bridgeStatus.update(direction, status);
        assertThat(bridgeStatus.toString()).isEqualTo(expectedBridgeStatus);
    }

    @DisplayName("이동 결과에 맞는 블록을 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"PLAYING:O", "FAIL:X", "SUCCESS:EMPTY"}, delimiter = ':')
    void checkGetBlockByStatus(PlayerStatus status, BridgeBlock expectedBlock) {
        BridgeBlock block = bridgeStatus.getBlockByStatus(status);
        assertThat(block).isEqualTo(expectedBlock);
    }

    static Stream<Arguments> BridgeStatusData() {
        return Stream.of(
                Arguments.of(Direction.of("U"), PlayerStatus.PLAYING, "[ O ]\n[   ]\n"),
                Arguments.of(Direction.of("D"), PlayerStatus.PLAYING, "[   ]\n[ O ]\n"),
                Arguments.of(Direction.of("U"), PlayerStatus.FAIL, "[ X ]\n[   ]\n"),
                Arguments.of(Direction.of("D"), PlayerStatus.FAIL, "[   ]\n[ X ]\n")
        );
    }
}
