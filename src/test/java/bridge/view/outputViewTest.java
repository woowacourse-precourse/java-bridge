package bridge.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class outputViewTest {

    private static OutputView outputView;
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void beforeEach(){
        outputView = new OutputView();
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @DisplayName("다리 길이 3, 유저가 이동한 인덱스 2, 이동을 성공했을 때 출력문이 일치하는지 확인")
    @Test
    void givenBridgesThreeIndexTwoIsSuccessTrue_whenPrintMap_thenReturnPrintMap(){
        // Given
        List<String> bridges = List.of("D","U","U");
        int index = 2;
        boolean isSuccess = true;

        // When
        outputView.printMap(bridges, index, isSuccess);

        // Then
        assertEquals("[   | O | O ]\n[ O |   |   ]"
                , outputMessage.toString().trim().replace("\r",""));

    }

    @DisplayName("다리 길이 3, 유저가 이동한 인덱스 1, 이동을 실패했을 때 출력문이 일치하는지 확인")
    @Test
    void givenBridgesThreeIndexOneIsSuccessFalse_whenPrintMap_thenReturnPrintMap(){
        // Given
        List<String> bridges = List.of("D","U","U");
        int index = 1;
        boolean isSuccess = false;

        // When
        outputView.printMap(bridges, index, isSuccess);

        // Then
        assertEquals("[   |   ]\n[ O | X ]"
                , outputMessage.toString().trim().replace("\r",""));

    }

    @DisplayName("다리 길이 3, 유저가 이동한 인덱스 0, 이동을 성공했을 때 출력문이 일치하는지 확인")
    @Test
    void givenBridgesThreeIndexZeroIsSuccessTrue_whenPrintMap_thenReturnPrintMap(){
        // Given
        List<String> bridges = List.of("D","U","U");
        int index = 0;
        boolean isSuccess = true;

        // When
        outputView.printMap(bridges, index, isSuccess);

        // Then
        assertEquals("[   ]\n[ O ]"
                , outputMessage.toString().trim().replace("\r",""));

    }

    @DisplayName("다리 길이 3, 유저가 이동한 인덱스 3, 이동을 끝까지 성공했을 때 최종 게임 결과 출력문이 일치하는지 확인")
    @Test
    void givenBridgesThreeIndexThreeIsSuccessTrue_whenPrintResult_thenReturnPrintResult(){
        // Given
        List<String> bridges = List.of("D","U","U");
        int index = 3;
        boolean isRunning = true;

        // When
        outputView.printResult(bridges, index, isRunning);

        // Then
        assertEquals("최종 게임 결과\n\n[   | O | O ]\n[ O |   |   ]\n\n게임 성공 여부: 성공\n"
                , outputMessage.toString().replace("\r", ""));
    }

    @DisplayName("다리 길이 3, 유저가 이동한 인덱스 3, 이동을 실패해서 중간에 종료했을 때 최종 게임 결과 출력문이 일치하는지 확인")
    @Test
    void givenBridgesThreeIndexThreeIsSuccessFalse_whenPrintResult_thenReturnPrintResult(){
        // Given
        List<String> bridges = List.of("D","U","U");
        int index = 3;
        boolean isRunning = false;

        // When
        outputView.printResult(bridges, index, isRunning);

        // Then
        assertEquals("최종 게임 결과\n\n[   | O |   ]\n[ O |   | X ]\n\n게임 성공 여부: 실패\n"
                , outputMessage.toString().replace("\r", ""));
    }

    @DisplayName("게임을 시도한 횟수를 받아 총 시도한 횟수를 출력해줘야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1","10","15","20","25","30"})
    void givenNumberOfAttempts_whenPrintTotalAttemptsMade_thenReturnPrintTotalAttemptsMade(String inputNumberOfAttempts){
        // Given
        int numberOfAttempts = Integer.parseInt(inputNumberOfAttempts);

        // When
        outputView.printTotalAttemptsMade(numberOfAttempts);

        // Then
        assertEquals("총 시도한 횟수: " + numberOfAttempts
                , outputMessage.toString().replace("\r",""));
    }
}
