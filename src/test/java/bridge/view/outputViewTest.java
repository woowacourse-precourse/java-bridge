package bridge.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
