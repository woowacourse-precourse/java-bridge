package bridge;

import bridge.controller.StartGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameTest {

    @DisplayName("bridge의 값이 U 또는 D의 값만 있는지 테스트")
    @Test
    void checkUPDOWN() {
        StartGame runGame = new StartGame();
        List<String> checkList;
        setInput("9");
        checkList = runGame.setBridgeSize().getBridge();
        assertThat(check(checkList)).isTrue();
    }


    private boolean check(List<String> checkList) {
        for (int i = 0; i < checkList.size(); i++) {
            if (!(checkList.get(i).equals("U") || checkList.get(i).equals("D"))){
                return false;
            }
        }
        return true;
    }

    @DisplayName("입력받은 length 기준으로 bridge가 생성되는지 테스트")
    @Test
    void checkLength() {
        StartGame runGame = new StartGame();
        List<String> checkList;
        int lenght = 10;
        setInput(String.valueOf(lenght));
        checkList = runGame.setBridgeSize().getBridge();
        assertThat(checkList).hasSize(lenght);
    }

    private void setInput(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
    }

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
