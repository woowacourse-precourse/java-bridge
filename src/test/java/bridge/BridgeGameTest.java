package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.BridgeGame;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("BridgeGame 클래스")
@Nested
class BridgeGameTest {

    SoftAssertions softAssertions = new SoftAssertions();

    @DisplayName("move 메소드는")
    @Nested
    class Describe_move {

        @DisplayName("건널 칸의 다리 타입이 입력과 일치하면")
        @Nested
        class Context_with_Correct_Move {

            BridgeGame bridgeGame = new BridgeGame(List.of("U"));

            @DisplayName("true를 리턴하며 유저 입력 배열에 업데이트한다.")
            @Test
            void correctMoveTest() {
                softAssertions.assertThat(bridgeGame.move("U")).as("return Type 확인")
                        .isEqualTo(true);
                softAssertions.assertThat(bridgeGame.getUserBridge()).as("return Type 확인")
                        .contains("U");
                softAssertions.assertAll();
            }
        }

        @DisplayName("건널 칸의 다리 타입이 입력과 일치하지 않으면")
        @Nested
        class Context_with_Wrong_Move {

            SoftAssertions softAssertions = new SoftAssertions();
            BridgeGame bridgeGame = new BridgeGame(List.of("U"));

            @DisplayName("false를 리턴하며 유저 입력 배열에 오답을 업데이트한다.")
            @Test
            void wrongMoveTest() {
                System.out.print((bridgeGame.getUserBridge()).size());
                softAssertions.assertThat(bridgeGame.move("D")).as("return Type 확인")
                        .isEqualTo(false);
                softAssertions.assertThat(bridgeGame.getUserBridge()).as("오답 업데이트 확인")
                        .contains("DF");
                softAssertions.assertAll();
            }
        }

    }

    @DisplayName("retry 메소드는")
    @Nested
    class Describe_retry {

        @DisplayName("재시도(R)를 인자로 받으면")
        @Nested
        class Context_with_retry {

            BridgeGame bridgeGame = new BridgeGame(List.of("U"));

            @BeforeEach
            void setUserBridge() {
                bridgeGame.move("U");
            }

            @DisplayName("bridgeGame의 필드를 초기화한다.")
            @Test
            void retryTest() {
                bridgeGame.retry();
                System.out.print(bridgeGame.getUserBridge().toString());

                softAssertions.assertThat(bridgeGame.getUserBridge().size()).as("userBridge 초기화 확인")
                        .isEqualTo(0);
                softAssertions.assertThat(bridgeGame.getRetrialNumber()).as("도전 횟수 증가 확인")
                        .isEqualTo(2);
                softAssertions.assertAll();
            }
        }
    }

    @DisplayName("giveUp 메소드는")
    @Nested
    class Describe_giveUp {

        @DisplayName("gameCommand를 입력받아 종료(Q)이면")
        @Nested
        class Context_with_quit {

            BridgeGame bridgeGame = new BridgeGame(List.of("U"));


            @DisplayName("gameSuccess(게임 성공 여부)를 실패로 변경한다.")
            @Test
            void giveUpTest() {
                bridgeGame.giveUp();
                assertThat(bridgeGame.getGameSuccess()).as("gameSuccess 변경 확인")
                        .isEqualTo(false);
            }
        }
    }

    @DisplayName("hasNotClear 메소드는")
    @Nested
    class Describe_hasNotClear {

        @DisplayName("userBridge를 다채우지 못하고, 게임을 포기하지 않았으면")
        @Nested
        class Context_with_complete_bridge {

            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

            @BeforeEach
            void setUserBridge() {
                bridgeGame.move("U");
                bridgeGame.move("D");
            }

            @DisplayName("True를 반환한다.")
            @Test
            void hasNotClearTest() {
                assertThat(bridgeGame.isNotOver()).as("gameClear 확인")
                        .isEqualTo(true);
            }
        }

        @DisplayName("userBridge를 다채웠지만, 게임을 포기했다면")
        @Nested
        class Context_with_giveUp {

            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

            @BeforeEach
            void setUserBridge() {
                bridgeGame.move("U");
                bridgeGame.move("D");
                bridgeGame.move("D");
                bridgeGame.giveUp();
            }

            @DisplayName("false를 반환한다.")
            @Test
            void isNotOverTest() {
                assertThat(bridgeGame.isNotOver()).as("gameClear 확인")
                        .isEqualTo(false);
            }
        }
    }
}




