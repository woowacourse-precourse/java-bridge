package bridge;

import bridge.domain.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {
    Record record;
    List<String> upBridgeResult;
    List<String> downBridgeResult;

    @BeforeEach
    void generateResult() {
        try {
            record = new Record();

            Field upBridgeResultField = record.getClass().getDeclaredField("upBridgeResult");
            upBridgeResultField.setAccessible(true);
            upBridgeResult = (List<String>) upBridgeResultField.get(record);

            Field downBridgeResultField = record.getClass().getDeclaredField("downBridgeResult");
            downBridgeResultField.setAccessible(true);
            downBridgeResult = (List<String>) downBridgeResultField.get(record);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    @DisplayName("위로 건너기 성공 테스트")
    @Test
    void checkUpBridgeSuccessTest() {
        String moveInput = "U";
        boolean moveSuccess = true;

        record.write(moveInput, moveSuccess);
        assertThat(upBridgeResult).contains(" O ");
        assertThat(downBridgeResult).contains("   ");
    }

    @DisplayName("위로 건너기 실패 테스트")
    @Test
    void checkUpBridgeFailTest() {
        String moveInput = "U";
        boolean moveSuccess = false;

        record.write(moveInput, moveSuccess);
        assertThat(upBridgeResult).contains(" X ");
        assertThat(downBridgeResult).contains("   ");
    }
}
