package bridge;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.model.BridgeGame;
import bridge.model.Progress;
import bridge.model.constant.BridgePattern;
import bridge.model.constant.Command;
import bridge.model.constant.GameCondition;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionListTest {

    private final Progress progress = new Progress(5);
    private final BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "D", "U"), progress);

    /**
     * BridgeGame 클래스에 대한 테스트
     */
    @DisplayName("move 메소드가 성공적으로 실행되는 케이스")
    @Test
    public void moveSuccess() {
        assertEquals(bridgeGame.move(BridgePattern.MOVE_UP), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_DOWN), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_UP), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_DOWN), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_UP), GameCondition.GOAL);

        assertEquals(progress.getProgress(), generateCompareMap());
    }

    @DisplayName("move 메소드가 실패하는 케이스")
    @Test
    public void moveFail() {
        assertEquals(bridgeGame.move(BridgePattern.MOVE_DOWN), GameCondition.FAILURE);
        assertEquals(progress.getProgress().get(BridgePattern.MOVE_DOWN), new ArrayList<>() {{
            add("X");
        }});
    }

    @DisplayName("retry 메소드 테스트 케이스")
    @Test
    public void doRetry() {
        assertEquals(bridgeGame.exportGameCount(), 1);
        bridgeGame.retry();
        assertEquals(bridgeGame.exportGameCount(), 2);
    }

    private Map<BridgePattern, List<String>> generateCompareMap() {
        List<String> up = new ArrayList<>() {{
            add("O");
            add(" ");
            add("O");
            add(" ");
            add("O");
        }};
        List<String> down = new ArrayList<>() {{
            add(" ");
            add("O");
            add(" ");
            add("O");
            add(" ");
        }};

        return new EnumMap<>(BridgePattern.class) {{
            put(BridgePattern.MOVE_UP, up);
            put(BridgePattern.MOVE_DOWN, down);
        }};
    }

    /**
     * BridgePattern 클래스에 대한 테스트
     */
    @DisplayName("입력된 숫자를 상수로 정의된 문자로 변환 성공 케이스")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    public void convertSuccess(int input) {
        assertThatCode(() -> BridgePattern.convertNumberToMove(input)).doesNotThrowAnyException();
    }

    @DisplayName("입력된 숫자롤 상수로 정의된 문자로 변환 실패 케이스")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2})
    public void convertFail(int input) {
        assertThatThrownBy(() -> BridgePattern.convertNumberToMove(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 문자에 부합하는 유형을 성공적으로 찾는 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    public void searchSuccess(String input) {
        assertThatCode(() -> BridgePattern.searchBridgeType(input)).doesNotThrowAnyException();
    }

    @DisplayName("입력한 문자에 부합하는 유형을 성공적으로 찾지 못하는 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"X", "Y"})
    public void searchFail(String input) {
        assertThatThrownBy(() -> BridgePattern.searchBridgeType(input)).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Command 클래스에 대한 테스트
     */
    @DisplayName("입력한 문자에 부합하는 명령 유형을 성공적으로 찾는 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    public void searchCommandSuccess(String input) {
        assertThatCode(() -> Command.searchCommand(input)).doesNotThrowAnyException();
    }

    @DisplayName("입력한 문자에 부합하는 명령 유형을 성공적으로 찾지 못하는 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"A", "B"})
    public void searchCommandFail(String input) {
        assertThatThrownBy(() -> Command.searchCommand(input)).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Progress 클래스에 대한 테스트
     */
    @DisplayName("진행 상황을 성공적으로 갱신시키는 케이스")
    @ParameterizedTest
    @ValueSource(strings = "O")
    public void updateSuccess(String input) {
        progress.updateProgress(BridgePattern.MOVE_UP, input);
        assertEquals(progress.getProgress().get(BridgePattern.MOVE_UP), new ArrayList<>() {{
            add("O");
        }});
    }
}