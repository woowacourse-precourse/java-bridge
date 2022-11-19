package bridge.game;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private GameCharacter character;
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        character = new GameCharacter();
        bridgeGame = new BridgeGame(character, 20);
    }

    @DisplayName("게임 캐릭터가 이동할 칸의 이동 가능 여부 체크 테스트")
    @ValueSource(strings = {"U", "D", "D", "U", "D"})
    @ParameterizedTest
    void isAbleToMove(String destination) {
        character.setNextMove(destination);
        String nextRightDestination = bridgeGame.showRightDestinationInArea(character.showNextArea());
        boolean ableToMove = bridgeGame.isAbleToMove();
        if (nextRightDestination.equals(destination)) {
            assertThat(ableToMove).isTrue();
        }
        if (!nextRightDestination.equals(destination)) {
            assertThat(ableToMove).isFalse();
        }
    }

    @DisplayName("진행 결과 만들기")
    @Test
    void makeProgress() {
        //given
        String destination = "U";
        boolean isSuccess = true;
        //when
        Progress progress = bridgeGame.makeMove(destination, isSuccess);
        //then
        assertThat(progress.getDestination()).isEqualTo(destination);
        assertThat(progress.isSuccess()).isEqualTo(isSuccess);
    }

    @DisplayName("진행 결과 저장")
    @Test
    void saveProgress() {
        //given
        character.setNextMove("D");
        //when
        bridgeGame.saveNextMove();
        //then
        List<Progress> progresses = bridgeGame.showCurrentResult();
        assertThat(progresses.size()).isEqualTo(1);
        assertThat(progresses.get(0).getDestination()).isEqualTo("D");
    }

    @DisplayName("캐릭터 이동, 결과 저장")
    @Test
    void move(){
        //given
        //when
        bridgeGame.move("D");
        //then
        List<Progress> progresses = bridgeGame.showCurrentResult();
        assertThat(progresses.size()).isEqualTo(1);
        assertThat(progresses.get(0).getDestination()).isEqualTo("D");
        assertThat(character.showCurrentLocation()).isEqualTo(0);
    }
}