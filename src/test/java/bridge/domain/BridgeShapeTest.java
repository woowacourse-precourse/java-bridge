package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeShapeTest {
    private static final boolean NOT_LAST = false;
    private static final boolean LAST = true;

    @DisplayName("위에칸이 정답일 경우 출력 양식")
    @Test
    public void collect_Up_Output() {
        List<String> answer = List.of(" O |", "   |");
        assertEquals(BridgeShape.COLLECT_UP.getShapeMessages(NOT_LAST), answer);
    }

    @DisplayName("아래칸이 정답일 경우 출력 양식")
    @Test
    public void Collect_Down_Output() {
        List<String> answer = List.of("   |", " O |");
        assertEquals(BridgeShape.COLLECT_DOWN.getShapeMessages(NOT_LAST), answer);
    }

    @DisplayName("마지막 인덱스 위에칸이 정답일 경우 출력 양식")
    @Test
    public void last_Collect_Up_Output() {
        List<String> answer = List.of(" O ", "   ");
        assertEquals(BridgeShape.COLLECT_UP.getShapeMessages(LAST), answer);
    }

    @DisplayName("마지막 인덱스 아래칸이 정답일 경우 출력 양식")
    @Test
    public void last_Collect_Down_Output() {
        List<String> answer = List.of("   ", " O ");
        assertEquals(BridgeShape.COLLECT_DOWN.getShapeMessages(LAST), answer);
    }

    @DisplayName("위에칸이 틀린값 경우 출력 양식")
    @Test
    public void wrong_Up_Output() {
        List<String> answer = List.of(" X |", "   |");
        assertEquals(BridgeShape.WRONG_UP.getShapeMessages(NOT_LAST), answer);
    }

    @DisplayName("아래칸이 틀린값 경우 출력 양식")
    @Test
    public void wrong_Down_Output() {
        List<String> answer = List.of("   |", " X |");
        assertEquals(BridgeShape.WRONG_DOWN.getShapeMessages(NOT_LAST), answer);
    }

    @DisplayName("마지막 인덱스 위에칸이 틀린값 경우 출력 양식")
    @Test
    public void last_Wrong_Up_Output() {
        List<String> answer = List.of(" X ", "   ");
        assertEquals(BridgeShape.WRONG_UP.getShapeMessages(LAST), answer);
    }

    @DisplayName("마지막 인덱스 아래칸이 틀린값 경우 출력 양식")
    @Test
    public void last_Wrong_Down_Output() {
        List<String> answer = List.of("   ", " X ");
        assertEquals(BridgeShape.WRONG_DOWN.getShapeMessages(LAST), answer);
    }
}