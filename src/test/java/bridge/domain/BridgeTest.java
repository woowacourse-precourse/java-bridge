package bridge.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("생성자를 통해 만든 Bridge가 잘 반환되는지 테스트")
    @Test
    public void getBridgeTest() {
        //given
        List<String> list = List.of("U", "U", "D");

        //when
        Bridge bridge = new Bridge(list);

        //then
        assertThat(bridge.getBridge()).isEqualTo(list);
    }

    @DisplayName("위치가 잘 증가하는지 테스트")
    @Test
    public void increaseLocationTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        //when
        bridge.increaseLocation();

        //then
        assertThat(bridge.getLocation()).isEqualTo(1);
    }

    @DisplayName("위치가 잘 반환되는지 테스트")
    @Test
    public void getLocationTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        //when
        int location = bridge.getLocation();

        //then
        assertThat(location).isEqualTo(0);
    }

    @DisplayName("위치가 잘 초기화되는지 테스트")
    @Test
    public void initLocationTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        bridge.increaseLocation();

        //when
        bridge.initLocation();

        //then
        assertThat(bridge.getLocation()).isEqualTo(0);
    }

    @DisplayName("위치 비교가 잘되는지 테스트")
    @Test
    public void isPassTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        String moveUp = "U";
        String moveDown = "D";

        //when
        boolean pass = bridge.isPass(moveUp);
        boolean fail = bridge.isPass(moveDown);

        //then
        assertThat(pass).isEqualTo(true);
        assertThat(fail).isEqualTo(false);
    }
}