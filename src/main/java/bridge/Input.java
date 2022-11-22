package bridge;

import java.util.Objects;

public class Input {
    private static InputView inputView;

    private Input() {

    }

    /**
     * @return 입력된 다리 길이
     * <p>
     * 입력된 다리 길이를 반환한다.
     */
    public static int readBridgeSize() {
        int size = getInstance().readBridgeSize();
        return size;
    }

    /**
     * @return 입력된 이동 위치
     * <p>
     * 입력된 이동 위치를 반환한다.
     */
    public static String readNextMove() {
        String moveLocation = getInstance().readMoving();
        return moveLocation;
    }

    /**
     * @return 입력된 종료 커맨드
     * <p>
     * 입력된 종료 커맨드를 반환한다.
     */
    public static String readExitCommand() {
        String command = getInstance().readGameCommand();
        return command;
    }

    /**
     * @return 싱글턴 {@link InputView} 객체
     * <p>
     * {@link InputView} 싱글턴 객체를 생성해 반환한다.
     */
    private static InputView getInstance() {
        if (Objects.isNull(inputView)) {
            inputView = new InputView();
        }
        return inputView;
    }
}
