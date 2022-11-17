package bridge;

import bridge.controller.Rungame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeBridgeTest {

    @DisplayName("bridge의 값이 U 또는 D의 값만 있는지 테스트")
    @Test
    void checkUPDOWN() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Rungame runGame = new Rungame();
        List<String> checkList;

        Method method = runGame.getClass().getDeclaredMethod("getBridge", int.class);
        method.setAccessible(true);
        checkList = (List<String>)method.invoke(runGame,5);
        assertThat(checkList).containsOnly("U","D");
    }
}
