package bridge.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    static InputView inputView;

    @BeforeEach
    public void beforeEach(){
        inputView = new InputView();
    }


    @DisplayName("다리의 길이를 입력받을 때 3이상 20이하 범위의 값들이 입력되면 Int 형으로 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3","4","5","8","9","10","15","16","19","20"})
    void givenBridgeSize_whenReadBridgeSize_thenReturn_3_OrMoreAnd20_OrLess(String inputBridgeSize){
        // Given
        InputStream inputStream = generateUserInput(inputBridgeSize);
        System.setIn(inputStream);

        // When
        int bridgeSize = inputView.readBridgeSize();

        // Then
        assertThat(bridgeSize).isGreaterThan(2).isLessThan(21);
    }

    @DisplayName("다리의 길이를 입력받을 때 3미만 20초과 범위의 값들이 입력되면 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1","1","2","21","25","a","1a","a1","-+"})
    void givenBridgeSize_whenReadBridgeSize_thenThrowIllegalArgumentException(String inputBridgeSize){
        // Given
        InputStream inputStream = generateUserInput(inputBridgeSize);
        System.setIn(inputStream);

        // When && Then
        assertThatThrownBy(()->inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}
