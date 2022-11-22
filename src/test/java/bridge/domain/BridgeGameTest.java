package bridge.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        List<String> list = List.of("U", "U", "D");
        bridgeGame = new BridgeGame(list);
    }

    @DisplayName("생성자를 통해 만든 Bridge가 잘 반환되는지 테스트")
    @Test
    public void getBridgeTest() {
        //given
        List<String> list = List.of("U", "U", "D");

        //when

        //then
        assertThat(bridgeGame.getBridge()).isEqualTo(list);
    }

    @DisplayName("위치가 잘 증가하는지 테스트")
    @Test
    public void increaseLocationTest() {
        //given
        int increaseLocation = 1;

        //when
        bridgeGame.move();

        //then
        assertThat(bridgeGame.getLocation()).isEqualTo(increaseLocation);
    }

    @DisplayName("위치가 잘 반환되는지 테스트")
    @Test
    public void getLocationTest() {
        //given
        int nowLocation = 0;

        //when
        int location = bridgeGame.getLocation();

        //then
        assertThat(location).isEqualTo(nowLocation);
    }

    @DisplayName("위치가 잘 초기화되는지 테스트")
    @Test
    public void initLocationTest() {
        //given
        int resetLocation = 0;
        bridgeGame.move();

        //when
        bridgeGame.retry();

        //then
        assertThat(bridgeGame.getLocation()).isEqualTo(resetLocation);
    }

    @DisplayName("위치 비교가 잘되는지 테스트")
    @Test
    public void isPassTest() {
        //given
        String moveUp = "U";
        String moveDown = "D";

        //when
        boolean pass = bridgeGame.isPass(moveUp);
        boolean fail = bridgeGame.isPass(moveDown);

        //then
        assertThat(pass).isEqualTo(true);
        assertThat(fail).isEqualTo(false);
    }
}