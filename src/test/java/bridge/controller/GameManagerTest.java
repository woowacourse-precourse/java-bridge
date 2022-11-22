package bridge.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest {
    GameManager gameManager;

    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final List<String> SUCCESS_UP_RESULT = Arrays.asList(" O ", "   ", " O ");
    private static final List<String> SUCCESS_DOWN_RESULT = Arrays.asList("   ", " O ", "   ");
    private static final List<String> FAIL_DOWN_RESULT = Arrays.asList("   ", " X ", "   ");

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @DisplayName("성공했는지 실패했는지에 대한 여부 테스트 - 성공")
    @Test
    void checkSuccess() {
        String result = gameManager.isSuccess(SUCCESS_UP_RESULT, SUCCESS_DOWN_RESULT);
        assertThat(result).isEqualTo(SUCCESS);
    }

    @DisplayName("성공했는지 실패했는지에 대한 여부 테스트 - 실패")
    @Test
    void checkFail() {
        String result = gameManager.isSuccess(SUCCESS_UP_RESULT, FAIL_DOWN_RESULT);
        assertThat(result).isEqualTo(FAIL);
    }
}