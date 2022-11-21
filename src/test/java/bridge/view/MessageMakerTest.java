package bridge.view;

import static org.junit.jupiter.api.Assertions.*;

import bridge.dto.StepResponseDto;
import bridge.model.Repetition;
import bridge.model.Score;
import bridge.model.UserStep;
import global.config.AppConfig;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageMakerTest {

    MessageFactory messageFactory;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        messageFactory = appConfig.messageFactory(List.of("U", "D", "D"));
    }

    @DisplayName("성공 시 메세지를 생성해준다.")
    @Test
    void successMessage(){
        assertEquals(messageFactory.successMessage(), "[ O |   |   ]\n[   | O | O ]\n");
    }

    @DisplayName("실패 시 메세지를 생성해준다.")
    @Test
    void failMessage(){
        assertEquals(messageFactory.failMessage(), "[ O |   |   ]\n[   | O | X ]\n");
    }

    @DisplayName("마지막 종합 메세지를 생성한다 : 성공")
    @Test
    void finalMessageSuccess(){
        StepResponseDto stepResponseDto = new StepResponseDto(
                new Score(new UserStep(List.of("U", "D", "D")), new Repetition(5)));
        assertEquals(messageFactory.finalMessage(stepResponseDto),
                "게임 성공 여부: 성공\n총 시도한 횟수: 5");
    }

    @DisplayName("마지막 종합 메세지를 생성한다 : 실패")
    @Test
    void finalMessageFail(){
        StepResponseDto stepResponseDto = new StepResponseDto(
                new Score(new UserStep(List.of("U", "D", "D")), new Repetition(5)), false);
        assertEquals(messageFactory.finalMessage(stepResponseDto),
                "게임 성공 여부: 실패\n총 시도한 횟수: 5");
    }

}