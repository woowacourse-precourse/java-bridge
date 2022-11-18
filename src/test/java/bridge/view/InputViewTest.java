package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int READ_SIZE_TEST = 0;
    private static final int READ_MOVE_TEST = 1;
    private static final int READ_COMMAND_TEST = 2;
    static InputView inputView;

    @BeforeAll
    static void initAll() {
        inputView = new InputView();
    }

    @DisplayName("bridge 크기로 3을 넣으면 readBridgeSize 메서드는 숫자 3을 리턴한다.")
    @Test
    void readBridgeSizeTest1() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @DisplayName("bridge 크기로 20을 넣으면 readBridgeSize 메서드는 숫자 20을 리턴한다.")
    @Test
    void readBridgeSizeTest2() {
        String input = "20";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(20);
    }

    @DisplayName("bridge 크기로 2를 (3 미만) 넣으면 에러 메시지를 출력한다.")
    @Test
    void readBridgeSizeErrorTest1() {
        assertSimpleTest(() -> {
            run(READ_SIZE_TEST, "2", "5");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("bridge 크기로 21을 (20 초과) 넣으면 에러 메시지를 출력한다.")
    @Test
    void readBridgeSizeErrorTest2() {
        assertSimpleTest(() -> {
            run(READ_SIZE_TEST, "21", "5");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });

    }

    @DisplayName("bridge 크기로 숫자 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readBridgeSizeErrorTest3() {
        assertSimpleTest(() -> {
            run(READ_SIZE_TEST, "s", "5");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("bridge 크기로 숫자 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readBridgeSizeErrorTest4() {
        assertSimpleTest(() -> {
            run(READ_SIZE_TEST, " ", "5");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동 위치로 'U' 을 입력하면 readMoving 메서드는 'U'를 리턴한다.")
    @Test
    void readMovingTest1() {
        String input = "U";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @DisplayName("이동 위치로 'D' 를 입력하면 readMoving 메서드는 'D'를 리턴한다.")
    @Test
    void readMovingTest2() {
        String input = "D";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @DisplayName("이동 위치로 'U', 'D' 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readMovingErrorTest1() {
        assertSimpleTest(() -> {
            run(READ_MOVE_TEST, "e", "U");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동 위치로 'U', 'D' 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readMovingErrorTest2() {
        assertSimpleTest(() -> {
            run(READ_MOVE_TEST, "UD", "U");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동 위치로 'U', 'D' 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readMovingErrorTest3() {
        assertSimpleTest(() -> {
            run(READ_MOVE_TEST, " ", "U");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("게임 커멘드로 'R' 을 입력하면 readMoving 메서드는 'R'을 리턴한다.")
    @Test
    void readGameCommandTest1() {
        String input = "R";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readGameCommand()).isEqualTo(input);
    }

    @DisplayName("게임 커멘드로 'Q' 를 입력하면 readMoving 메서드는 'Q'를 리턴한다.")
    @Test
    void readGameCommandTest2() {
        String input = "Q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readGameCommand()).isEqualTo(input);
    }

    @DisplayName("게임 커멘드로 'R', 'Q' 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readGameCommandErrorTest1() {
        assertSimpleTest(() -> {
            run(READ_COMMAND_TEST, "r", "R");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("게임 커멘드로 'R', 'Q' 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readGameCommandErrorTest2() {
        assertSimpleTest(() -> {
            run(READ_COMMAND_TEST, "RQ", "R");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("게임 커멘드로 'R', 'Q' 이외의 것을 넣으면 에러 메시지를 출력한다.")
    @Test
    void readGameCommandErrorTest3() {
        assertSimpleTest(() -> {
            run(READ_COMMAND_TEST, "1", "R");
            String s = output();
            assertThat(s).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
    }

    protected void runMain(int test) {
        if (test == READ_SIZE_TEST) {
            inputView.readBridgeSize();
        }
        if (test == READ_MOVE_TEST) {
            inputView.readMoving();
        }
        if (test == READ_COMMAND_TEST) {
            inputView.readGameCommand();
        }
    }

    protected void run(int test, final String... args) {
        command(args);
        runMain(test);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}