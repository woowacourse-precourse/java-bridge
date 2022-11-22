package bridge;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리길이_예외_테스트() {
        try{
            InputView inputView = new InputView();
            String bridgeSize = "1";
            inputView.bridgeValidate(bridgeSize);
        } catch (IllegalArgumentException e){
            e.getMessage().contains(ERROR_MESSAGE);
        }
    }

    @Test
    void 이동칸_예외_테스트() {
        try{
            InputView inputView = new InputView();
            String move = "f";
            inputView.movingValidate(move);
        } catch (IllegalArgumentException e){
            e.getMessage().contains(ERROR_MESSAGE);
        }
    }

    @Test
    void 커맨드_예외_테스트() {
        try{
            InputView inputView = new InputView();
            String command = "F";
            inputView.commandValidate(command);
        } catch (IllegalArgumentException e){
            e.getMessage().contains(ERROR_MESSAGE);
        }
    }

}