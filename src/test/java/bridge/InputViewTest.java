package bridge;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    InputView inputView = new InputView();
    InputStream sysInBackup = System.in;


    @DisplayName("다리의 길이를 정상적으로 입력 받는 케이스")
    @Test
    void 다리의_길이를_정상적으로_입력받는_경우(){
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        System.setIn(in);

        assertThat(inputView.readBridgeSize()).isEqualTo(5);

        System.setIn(sysInBackup);
    }

    void exceptionBridgeSize(String input){
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(sysInBackup);
    }

    @DisplayName("다리의 길이가 숫자가 아닌 경우 예외 처리")
    @ValueSource(strings = {"a", ",", "A", "일"})
    @ParameterizedTest
    void 다리의_길이가_숫자가_아닌_경우(String input){
        exceptionBridgeSize(input);
    }

    @DisplayName("다리의 길이가 숫자가 3보다 작을 경우 예외 처리")
    @ValueSource(strings = {"2", "0", "-10", "-10000"})
    @ParameterizedTest
    void 다리의_길이가_3보다_작은_경우(String input){
        exceptionBridgeSize(input);
    }

    @DisplayName("다리의 길이가 숫자가 20보다 클 경우 예외 처리")
    @ValueSource(strings = {"21", "100", "10000"})
    @ParameterizedTest
    void 다리의_길이가_20보다_큰_경우(String input){
        exceptionBridgeSize(input);
    }


    @DisplayName("이동할 칸을 정상적으로 입력 받는 케이스")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동할_칸을_정상적으로_입력받는_경우(String input){
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readMoving()).isNotIn(Step.values());
        System.setIn(sysInBackup);
    }

    @DisplayName("이동할 칸에 U,D 제외하고 다른 문자가 입력되는 경우 예외 처리")
    @ValueSource(strings = {"UU", "DD", "Q" , "1", ","})
    @ParameterizedTest
    void 이동할_칸을_정상적으로_입력받지_못하는_경우(String input){
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
        System.setIn(sysInBackup);
    }
}