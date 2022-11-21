package bridge.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class OutputTest {
    private OutputView outputView;
    @BeforeEach
    public void upSet(){
        outputView = new OutputView();
    }

    @DisplayName("사용자 요구사항에 맞는 디자인이 화면에 출력되는지 확인")
    @MethodSource("printMapParameters")
    @ParameterizedTest
    public void printMap(boolean success, List<String> bridge){
        outputView.printMap(success, bridge);
        System.out.println();
    }

    private static Stream<Arguments> printMapParameters(){
        return Stream.of(
                Arguments.of(true, List.of("U", "U", "U")),
                Arguments.of(true, List.of("U", "U", "D")),
                Arguments.of(false, List.of("U", "D", "D")),
                Arguments.of(false, List.of("U", "D", "U"))
                );
    }
}
