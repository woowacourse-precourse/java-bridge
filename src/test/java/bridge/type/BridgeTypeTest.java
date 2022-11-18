package bridge.type;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTypeTest {
    @ParameterizedTest(name = "타입 생성 테스트")
    @MethodSource("타입_생성_데이터")
    void 타입_생성(int id, BridgeType result) {
        assertThat(BridgeType.create(id)).isEqualTo(result);
    }

    static Stream<Arguments> 타입_생성_데이터() {
        return Stream.of(
                Arguments.of(-2, BridgeType.UNKNOWN),
                Arguments.of(-1, BridgeType.UNKNOWN),
                Arguments.of(0, BridgeType.DOWN),
                Arguments.of(1, BridgeType.UP),
                Arguments.of(2, BridgeType.UNKNOWN)
        );
    }

    @ParameterizedTest(name = "타입 이름 가져오기")
    @MethodSource("타입_이름_가져오기_데이터")
    void 타입_이름_가져오기(BridgeType bridgeType, String result) {
        assertThat(bridgeType.getTypeName()).isEqualTo(result);
    }

    static Stream<Arguments> 타입_이름_가져오기_데이터() {
        return Stream.of(
                Arguments.of(BridgeType.UNKNOWN, "N"),
                Arguments.of(BridgeType.DOWN, "D"),
                Arguments.of(BridgeType.UP, "U")
        );
    }
}