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
    public void printMap(boolean isSuccess, List<Boolean> bridge){
        outputView.printMap(isSuccess, bridge);
        System.out.println();
    }

    private static Stream<Arguments> printMapParameters(){
        return Stream.of(
                Arguments.of(true, List.of(true, true, true)),
                Arguments.of(true, List.of(true, true, false)),
                Arguments.of(false, List.of(true, false, false)),
                Arguments.of(false, List.of(true, false, true))
                );
    }
}
