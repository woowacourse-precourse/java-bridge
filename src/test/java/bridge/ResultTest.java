package bridge;

import bridge.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    Result result;
    List<String> upBridgeResult;
    List<String> downBridgeResult;

    @BeforeEach
    void generateResult() {
        try {
            result = new Result();

            Field upBridgeResultField = result.getClass().getDeclaredField("upBridgeResult");
            upBridgeResultField.setAccessible(true);
            upBridgeResult = (List<String>) upBridgeResultField.get(result);

            Field downBridgeResultField = result.getClass().getDeclaredField("downBridgeResult");
            downBridgeResultField.setAccessible(true);
            downBridgeResult = (List<String>) downBridgeResultField.get(result);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    @DisplayName("위로 건너기 성공 테스트")
    @Test
    void checkUpBridgeSuccessTest() {
        String moveInput = "U";
        boolean moveSuccess = true;

        result.write(moveInput, moveSuccess);
        assertThat(upBridgeResult).contains(" O ");
        assertThat(downBridgeResult).contains("   ");
    }

    @DisplayName("위로 건너기 실패 테스트")
    @Test
    void checkUpBridgeFailTest() {
        String moveInput = "U";
        boolean moveSuccess = false;

        result.write(moveInput, moveSuccess);
        assertThat(upBridgeResult).contains(" X ");
        assertThat(downBridgeResult).contains("   ");
    }
}
