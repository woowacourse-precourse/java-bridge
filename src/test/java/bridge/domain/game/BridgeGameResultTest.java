package bridge.domain.game;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BridgeGameResultTest {

    BridgeGameResult bridgeGameResult;

    @BeforeAll
    void 초기화() {
        bridgeGameResult = new BridgeGameResult();
    }

    @Nested
    @DisplayName("사용자가 올바른 값을 입력했을 경우")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Valid {

        @Nested
        @DisplayName("사용자가 U 이동 옵션을 선택했는데 정답인 경우")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class U {

            @BeforeAll()
            void moveU() {
                bridgeGameResult.update("U", true);
            }

            @Test
            @DisplayName("상위 다리의 상태는 [O]")
            void 상위() {
                //given
                // when
                List<String> result = bridgeGameResult.getUpperBridge();
                // then
                assertThat(result).isEqualTo(List.of("O"));
            }

            @Test
            @DisplayName("하위 다리의 상태는 [ ]")
            void 하위() {
                //given
                // when
                List<String> result = bridgeGameResult.getDownBridge();
                // then
                assertThat(result).isEqualTo(List.of(" "));
            }

            @Nested
            @DisplayName("이어서 사용자가 D 이동옵션을 선택했는데 오답인 경우")
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class Invalid {

                @BeforeAll()
                void moveU() {
                    bridgeGameResult.update("D", false);
                }

                @Test
                @DisplayName("상위 다리의 상태는 [O, ]")
                void 상위() {
                    //given
                    // when
                    List<String> result = bridgeGameResult.getUpperBridge();
                    // then
                    assertThat(result).isEqualTo(List.of("O", " "));
                }

                @Test
                @DisplayName("하위 다리의 상태는 [ , X]")
                void 하위() {
                    //given
                    // when
                    List<String> result = bridgeGameResult.getDownBridge();
                    // then
                    assertThat(result).isEqualTo(List.of(" ", "X"));
                }
            }

        }
    }

}