package bridge;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("BridgeGame에 관한 테스트")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BridgeGameTest {

    OutputView ov = new OutputView();
    BridgeGame bg = new BridgeGame(ov, 4);

    OutputStream origin = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    Field map, user;

    @BeforeAll
    void setAccessibleTrueField() throws NoSuchFieldException {
        map = bg.getClass().getDeclaredField("map");
        map.setAccessible(true);
        user = bg.getClass().getDeclaredField("user");
        user.setAccessible(true);
    }

    @BeforeAll
    void changeOutputStream(){
        System.setOut(new PrintStream(out));
    }

    @AfterAll
    void resotreOutputStream(){
        System.setOut(new PrintStream(origin));
    }


    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("move에 관한 테스트")
    class MoveTest {

        @ParameterizedTest(name="시나리오 {index}")
        @MethodSource("testMoveArgument")
        @DisplayName("move했을때 user가 제대로 이동하는지 테스트")
        void testMove(List<String> imap, List<String> iuser, String direction, List<String> expected) throws IllegalAccessException {
            map.set(bg, imap);
            user.set(bg, new ArrayList<>(iuser));
            bg.move(direction);
            assertThat(user.get(bg))
                    .isEqualTo(expected);
        }

        Stream<Arguments> testMoveArgument(){
            return  Stream.of(
                    Arguments.arguments(List.of("U", "D", "U", "D"), List.of("U","D","U"), "U", List.of("U","D","U","U")),
                    Arguments.arguments(List.of("U", "D", "U", "D"), List.of("U","D","U"), "D", List.of("U","D","U","D"))
            );
        }
    }

}
