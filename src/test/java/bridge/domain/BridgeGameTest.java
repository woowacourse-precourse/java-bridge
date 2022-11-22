package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private List<String> bridge;
    private Results results;
    private  BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridge = List.of("U","D","U");
        results = new Results();
        bridgeGame = new BridgeGame(bridge, results);
    }

    @Test
    @DisplayName("move메소드 이동 가능한 칸 테스트")
    void moveAbleTest(){
        //Given
        //When
        bridgeGame.move("U");
        bridgeGame.move("D");

        //Then
        RoundResult roundResult = results.getResults().get(0);
        assertThat(roundResult).extracting("location").isEqualTo("U");
        assertThat(roundResult).extracting("status").isEqualTo("O");

        RoundResult roundResult2 = results.getResults().get(1);
        assertThat(roundResult2).extracting("location").isEqualTo("D");
        assertThat(roundResult2).extracting("status").isEqualTo("O");

    }


    @Test
    @DisplayName("move 메소드 이동 불가한 칸 테스트")
    void moveUnableTest(){
        //Given
        //When
        bridgeGame.move("U");
        bridgeGame.move("U");

        //Then
        RoundResult roundResult = results.getResults().get(0);
        assertThat(roundResult).extracting("location").isEqualTo("U");
        assertThat(roundResult).extracting("status").isEqualTo("O");

        RoundResult roundResult2 = results.getResults().get(1);
        assertThat(roundResult2).extracting("location").isEqualTo("U");
        assertThat(roundResult2).extracting("status").isEqualTo("X");
    }


}