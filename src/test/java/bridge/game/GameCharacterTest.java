package bridge.game;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("다음 이동지를 입력 받는 기능 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void setNextMove(String input) {
        character.setNextMove(input);
        String destination = character.showNextDestination();
        assertThat(destination).isEqualTo(input);
    }

    @DisplayName("다음 구역으로 이동 기능 테스트")
    @Test
    void move() {
        int startLocation = character.showCurrentLocation();
        character.move();
        int movedLocation = character.showCurrentLocation();
        assertThat(startLocation).isEqualTo(-1);
        assertThat(movedLocation).isEqualTo(0);
    }

    @DisplayName("현재 위치를 조회하는 기능 테스트")
    @Test
    void showCurrentLocation() {
        int startLocation = character.showCurrentLocation();
        assertThat(startLocation).isEqualTo(-1);
    }

    @DisplayName("다음 이동할 구역 반환 기능 테스트")
    @Test
    void showNextArea() {
        int nextArea = character.showNextArea();
        assertThat(nextArea).isEqualTo(0);
    }

    @DisplayName("다음 이동할 목적지 반환 기능 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void showNextDestination(String input) {
        character.setNextMove(input);
        String destination = character.showNextDestination();
        assertThat(destination).isEqualTo(input);
    }

    @DisplayName("캐릭터 위치 초기화 기능 테스트")
    @Test
    void reset() {
        character.move();
        character.move();
        character.move();
        int movedLocation = character.showCurrentLocation();
        character.reset();
        int resetLocation = character.showCurrentLocation();
        assertThat(movedLocation).isEqualTo(2);
        assertThat(resetLocation).isEqualTo(-1);

    }
}