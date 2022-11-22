package bridge.controller;

import bridge.InOutStreamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class BridgeGameControllerTest extends InOutStreamTest {

    private final String ERROR_MESSAGE = "[ERROR]";

    BridgeGameController controller;

    @BeforeEach
    void init() {
        controller = new BridgeGameController();
    }

    @Nested
    class SetDifficultyTest {

        @BeforeEach
        void initMore() {
            controller.start();
        }

        @Test
        void 정상범위_숫자_입력은_한_번에_된다() {
            input("3");
            assertThatNoException().isThrownBy(
                    () -> controller.setDifficulty()
            );
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        }

        @Test
        void 비정상입력은_정상입력을_받을때까지_반복된다() {
            input("2", "32", " ", "*", "", "4");
            assertThatNoException().isThrownBy(
                    () -> controller.setDifficulty()
            );
            assertThat(output()).contains(ERROR_MESSAGE);
        }
    }

    @Nested
    class PlayGameTest {
        @Test
        void 이동방향_정상입력은_한번에_된다() {
            assertRandomNumberInRangeTest(() -> {
                        input("3", "U", "U", "U");
                        controller.start();
                        controller.setDifficulty();
                        controller.playGame();
                    }, 1, 1, 1
            );
        }

        @Test
        void 다리_안전경로와_사용자입력이_다르면_게임오버() {
            assertRandomNumberInRangeTest(
                    () -> {
                        input("3", "U", "D");
                        controller.start();
                        controller.setDifficulty();
                        controller.playGame();
                    },
                    1, 1, 1
            );
        }

        @Test
        void 다리_안전경로와_갯수가_같아도_사용자입력이_다르면_게임오버() {
            assertRandomNumberInRangeTest(
                    () -> {
                        input("3", "U", "U", "D");
                        controller.start();
                        controller.setDifficulty();
                        controller.playGame();
                    },
                    1, 1, 1
            );
        }

        @Test
        void 이동방향_입력이_아니라면_맞는_입력을_받을때까지_반복() {
            assertRandomNumberInRangeTest(
                    () -> {
                        input("3", "R", "2", " ", "*", "", "U", "U", "U");
                        controller.start();
                        controller.setDifficulty();
                        controller.playGame();
                    },
                    1, 1, 1
            );
            assertThat(output()).contains(ERROR_MESSAGE);
        }
    }

    @Nested
    class AskRetryTest {


        @BeforeEach
        void initMore() throws IllegalAccessException {
            input("5");
            controller.start();
            controller.setDifficulty();
        }

        @Test
        void 게임_재시작_입력은_정상동작한다() {
            assertSimpleTest(() -> {
                input("R");
                boolean result = controller.askRetry();
                assertThat(result).isTrue();
            });
        }

        @Test
        void 게임_종료_입력은_정상동작한다() {
            assertSimpleTest(() -> {
                input("Q");
                boolean result = controller.askRetry();
                assertThat(result).isFalse();
            });
        }

        @Test
        void 게임_종료_입력은_잘못된_입력이_안올때까지_반복_동작한다() {
            assertSimpleTest(() -> {
                input("1", " ", "*", "", "B", "Q");
                boolean result = controller.askRetry();
                assertThat(result).isFalse();
            });
        }
    }

    @Nested
    class EndTest {

        @Test
        void 게임에_성공한_경우_정상동작한다() {
            assertRandomNumberInRangeTest(() -> {
                        input("3", "U", "U", "U");
                        controller.start();
                        controller.setDifficulty();
                        controller.playGame();
                        controller.end();
                        assertThat(output()).contains(
                                "최종 게임 결과",
                                "게임 성공 여부: 성공",
                                "총 시도한 횟수: 1"
                        );
                    },
                    1, 1, 1
            );
        }

        @Test
        void 게임에_실패한_경우_정상동작한다() {
            assertRandomNumberInRangeTest(() -> {
                        input("3", "U", "D", "R", "U", "U", "D", "Q");
                        controller.start();
                        controller.setDifficulty();
                        controller.playGame();
                        controller.askRetry();
                        controller.playGame();
                        controller.askRetry();
                        controller.end();
                        assertThat(output()).contains(
                                "최종 게임 결과",
                                "게임 성공 여부: 실패",
                                "총 시도한 횟수: 2"
                        );
                    },
                    1, 1, 1
            );
        }
    }

}