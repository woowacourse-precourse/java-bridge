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

    @DisplayName("다리를 위로 건널지 아래로 건널지 입력받는 코드를 테스트, 유효한 입력이 들어왔을 경우 성공")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D", "D", "U"})
    void givenUpOrDown_whenReadMoving_thenReturnUpOrDown(String inputUpOrDown){
        // Given
        InputStream inputStream = generateUserInput(inputUpOrDown);
        System.setIn(inputStream);

        // When
        String upOrDown = inputView.readMoving();

        // Then
        assertThat(upOrDown).containsPattern("[UD]");
        assertThat(upOrDown).hasSize(1);
    }

    @DisplayName("다리를 위로 건널지 아래로 건널지 입력받는 코드를 테스트 - 유효하지 않은 값 입력")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "UD", "DU", "123", "**", "12D", "D12"})
    void givenUpOrDown_whenReadMoving_thenThrowIllegalArgumentException(String upOrDown){
        // Given
        InputStream inputStream = generateUserInput(upOrDown);
        System.setIn(inputStream);

        // When & Then
        assertThatThrownBy(()->inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("건널 수 없는 다리를 골라 건넜을 경우, 재시작('R') OR 게임 종료('Q')의 입력을 받아야 한다. - 유효한 값 입력")
    @ParameterizedTest
    @ValueSource(strings = {"R","Q"})
    void givenGameCommand_whenReadGameCommand_thenReturnGameCommand(String InputGameCommand){
        // Given
        InputStream inputStream = generateUserInput(InputGameCommand);
        System.setIn(inputStream);

        // When
        String command = inputView.readGameCommand();

        // Then
        assertThat(command).containsPattern("[QR]");
        assertThat(command).hasSize(1);
    }

    @DisplayName("건널 수 없는 다리를 골라 건넜을 경우, 재시작('R') OR 게임 종료('Q')의 입력을 받아야 한다. - 유효하지 않은 값 입력")
    @ParameterizedTest
    @ValueSource(strings = {"q","r","RQ","QR","1","1*","1Q","Q1"})
    void givenGameCommand_whenReadGameCommand_thenThrowIllegalArgumentException(String retryOrQuit){
        // Given
        InputStream inputStream = generateUserInput(retryOrQuit);
        System.setIn(inputStream);

        // When & Then
        assertThatThrownBy(()->inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}
