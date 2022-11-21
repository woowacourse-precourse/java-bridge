package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @Test
    @DisplayName("setUpandDown 메소드가 잘 작동하는지 테스트")
    void setUpandDownTest(){
        //Given
        String location = "U";
        String status = "O";
        RoundResult roundResult = new RoundResult(location,status);
        //When
        Map<String, String> upandDown = roundResult.setUpandDown();
        //Then
        assertThat(upandDown.get("up")).isEqualTo(status);
        assertThat(upandDown.get("down")).isEqualTo(" ");
    }

}