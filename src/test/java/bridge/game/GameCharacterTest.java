package bridge.game;

import static org.assertj.core.api.Assertions.*;

import bridge.view.UserMove;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
[X] 다음 이동지를 입력 받는 기능
[X] 다음 구역으로 이동
[X] 현재 구역 반환
[X] 이동할 구역 반환
[X] 다음 이동할 도착지 반환
[X] 초기화
 */

class GameCharacterTest {
    private GameCharacter character;

    @BeforeEach
    void beforeEach() {
        character = new GameCharacter();
    }

    @DisplayName("다음 이동할 목적지 반환 기능 테스트")
    @Test
    void showNextDestination() {
        //given
        //when
        String destination = character.showNextDestination();
        //then
        assertThat(destination).isEqualTo(null);
    }

    @DisplayName("다음 이동지를 입력 받는 기능 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void setNextMove(String input) {
        //given
        //when
        character.setNextMove(UserMove.getUserMove(input));
        //then
        String destination = character.showNextDestination();
        assertThat(destination).isEqualTo(input);
    }

    @DisplayName("현재 위치를 조회하는 기능 테스트")
    @Test
    void showCurrentLocation() {
        //given
        //when
        int startLocation = character.showCurrentLocation();
        //then
        assertThat(startLocation).isEqualTo(-1);
    }

    @DisplayName("다음 구역으로 이동 기능 테스트")
    @Test
    void move() {
        //given
        int startLocation = character.showCurrentLocation();
        //when
        character.move();
        //then
        int movedLocation = character.showCurrentLocation();
        assertThat(startLocation).isEqualTo(-1);
        assertThat(movedLocation).isEqualTo(0);
    }

    @DisplayName("다음 이동할 구역 반환 기능 테스트")
    @Test
    void showNextArea() {
        //given
        //when
        int nextArea = character.showNextArea();
        //then
        assertThat(nextArea).isEqualTo(0);
    }

    @DisplayName("캐릭터 위치 초기화 기능 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @ParameterizedTest
    void reset(int moveCount) {
        //given
        for (int i = 0; i < moveCount; i++) {
            character.move();
        }
        int movedLocation = character.showCurrentLocation();
        //when
        character.reset();
        //then
        int resetLocation = character.showCurrentLocation();
        assertThat(movedLocation).isEqualTo(moveCount - 1);
        assertThat(resetLocation).isEqualTo(-1);

    }
}