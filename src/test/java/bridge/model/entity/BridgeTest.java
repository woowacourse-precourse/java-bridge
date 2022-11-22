package bridge.model.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @DisplayName("Birdge 생성시 사이즈 확인")
    @Test
    void 다리생성시_사이즈_테스트_작성() {
        List<String> answer = List.of("U", "D", "U", "D");
        Bridge bridge = Bridge.of(answer);
        int expectSize = 4;
        assertThat(bridge.getAnswer().size()).isEqualTo(expectSize);
    }
    @DisplayName("[ERROR] Bridge 예외 테스트")
    @Test
    void of() {
        //Given
        List<List<String>> answer =
                List.of(
                        List.of("0", "D", "U", "D"),
                        List.of("", "D", "U", "D"),
                        List.of("(", "D", "U", "D"),
                        List.of("0", "D", "U", "3")
                        );
        //When
        assertThatThrownBy( () -> {
            for(int i = 0; i < answer.size(); i++){
                Bridge.of(answer.get(i));
            }
        }).isInstanceOf(IllegalArgumentException.class);

        //Then
    }

}
