package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    InputView inputView;
    InputStream in;
    @BeforeEach
    void init(){
        inputView = new InputView();
    }

    @DisplayName("다리사이즈 올바른 입력 테스트")
    @Test
    void sizeTest(){
        String[] input = {"3","10","20"};
        int[] result = {3,10,20};
        for (int i = 0; i < 3; i++) {
            in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);
            int size = inputView.readBridgeSize();
            assertThat(size).isEqualTo(result[i]);
        }
    }
    @DisplayName("다리사이즈 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"40","0","2","qwe","oo"})
    void sizeErrorTest(String input){
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->{
            inputView.readBridgeSize();
        });
    }
}