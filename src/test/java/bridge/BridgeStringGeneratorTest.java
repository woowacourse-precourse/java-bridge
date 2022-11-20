package bridge;

import bridge.generator.BridgeStringGenerator;
import bridge.generator.FailBridgeStringGenerator;
import bridge.generator.SuccessBridgeStringGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeStringGeneratorTest {

    @Test
    void 실패_다리_문자_생성() {
        assertThat(new FailBridgeStringGenerator().generate(List.of("D","U","U"))).isEqualTo(
                "[   | O | X ]\n" +
                "[ O |   |   ]\n");
    }

    @Test
    void 성공_다리_문자_생성() {
        assertThat(new SuccessBridgeStringGenerator().generate(List.of("D","U","U"))).isEqualTo(
                "[   | O | O ]\n" +
                "[ O |   |   ]\n");
    }

    @Test
    void 단일_실패_다리_문자_생성() {
        assertThat(new FailBridgeStringGenerator().generate(List.of("D"))).isEqualTo(
                "[   ]\n" +
                "[ X ]\n");
    }

    @Test
    void 단일_성공_다리_문자_생성() {
        assertThat(new SuccessBridgeStringGenerator().generate(List.of("D"))).isEqualTo(
                "[   ]\n" +
                "[ O ]\n");
    }
}