package bridge;

import bridge.controller.StartGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameTest {

    @DisplayName("bridge의 값이 U 또는 D의 값만 있는지 테스트")
    @Test
    void checkUPDOWN() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StartGame runGame = new StartGame();
        List<String> checkList;

        Method method = runGame.getClass().getDeclaredMethod("getBridge", int.class);
        method.setAccessible(true);
        checkList = (List<String>)method.invoke(runGame,5);
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

    @DisplayName("bridge의 파라미터로 받은 length이 값을 기준으로 생성되는지 테스트")
    @Test
    void checkLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StartGame runGame = new StartGame();
        List<String> checkList;
        int lenght = 5;

        Method method = runGame.getClass().getDeclaredMethod("getBridge", int.class);
        method.setAccessible(true);
        checkList = (List<String>)method.invoke(runGame,lenght);
        assertThat(checkList).hasSize(lenght);
    }
}
