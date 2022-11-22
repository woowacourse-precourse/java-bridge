package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeResultTest {
    private BridgeResult bridgeResult;

    @BeforeEach
    void init() {
        bridgeResult = new BridgeResult();
    }

    @Test
    @DisplayName(value = "모두 맞춘경우")
    void addSideIndiesTest1() {
        assertSimpleTest(() -> {
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "D");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "D");

            assertThat(bridgeResult.getMap())
                    .contains("[ O |   | O |   ]" + System.lineSeparator() + "[   | O |   | O ]");
        });
    }

    @Test
    @DisplayName(value = "중간에 틀린 경우")
    void addSideIndiesTest2() {
        assertSimpleTest(() -> {
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");

            assertThat(bridgeResult.getMap())
                    .contains("[ O | X ]" + System.lineSeparator() + "[   |   ]");
        });
    }

    @Test
    @DisplayName(value = "O를 출력해야하는 경우")
    void getPrintIndexTest1() {
        assertSimpleTest(() -> assertThat(bridgeResult.getPrintIndex("U", "U", "U"))
                .contains("O"));
    }

    @Test
    @DisplayName(value = "X를 출력해야 하는 경우")
    void getPrintIndexTest2() {
        assertSimpleTest(() -> assertThat(bridgeResult.getPrintIndex("U", "D", "U"))
                .contains("X"));
    }

    @Test
    @DisplayName(value = "공백을 출력해야 하는 경우")
    void getPrintIndexTest3() {
        assertSimpleTest(() -> assertThat(bridgeResult.getPrintIndex("U", "U", "D"))
                .contains(" "));
    }

    @Test
    @DisplayName(value = "정상적인 retry()")
    void retryResultTest1() {
        assertSimpleTest(() -> {
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.retryResult();
            assertThat(bridgeResult.getMap())
                    .contains("[ O ]" + System.lineSeparator() + "[   ]");
        });
    }

    @Test
    @DisplayName(value = "비정상적인 retry()")
    void retryResultTest2() {
        assertSimpleTest(() -> {
            bridgeResult.retryResult();
            assertThat(bridgeResult.getMap())
                    .contains("[  ]" + System.lineSeparator() + "[  ]");
        });
    }

    @Test
    @DisplayName(value = "정답일때 출력")
    void getResultTest1() {
        assertSimpleTest(() -> {
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "D");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "D");

            assertThat(bridgeResult.getResult(4))
                    .contains("최종 게임 결과" + System.lineSeparator()
                            + "[ O |   | O |   ]" + System.lineSeparator() + "[   | O |   | O ]" + System.lineSeparator()
                            + System.lineSeparator()
                            + "게임 성공 여부: 성공" + System.lineSeparator()
                            + "총 시도한 횟수: 1");
        });
    }

    @Test
    @DisplayName(value = "종료했을때 출력")
    void getResultTest2() {
        assertSimpleTest(() -> {
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");

            assertThat(bridgeResult.getResult(4))
                    .contains("최종 게임 결과" + System.lineSeparator()
                            + "[ O | X ]" + System.lineSeparator() + "[   |   ]" + System.lineSeparator()
                            + System.lineSeparator()
                            + "게임 성공 여부: 실패" + System.lineSeparator()
                            + "총 시도한 횟수: 1");
        });
    }

    @Test
    @DisplayName(value = "재시도가 포함된 출력")
    void getResultTest3() {
        assertSimpleTest(() -> {
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "D");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "U");
            bridgeResult.retryResult();
            bridgeResult.addSideIndies(List.of("U", "D", "U", "D"), "D");

            assertThat(bridgeResult.getResult(4))
                    .contains("최종 게임 결과" + System.lineSeparator()
                            + "[ O |   | O |   ]" + System.lineSeparator() + "[   | O |   | O ]" + System.lineSeparator()
                            + System.lineSeparator()
                            + "게임 성공 여부: 성공" + System.lineSeparator()
                            + "총 시도한 횟수: 2");
        });
    }
}