package bridge.exception;

public class ExceptionMessages {

    private static final String ERROR = "[ERROR] ";
    public static final String InvalidNumberMessage = ERROR + "숫자형식 이어야 합니다.";
    public static final String InvalidGameCommand = ERROR + "커맨드는 R과 Q만 입력 가능합니다.";
    public static final String InvalidBridgeSize = ERROR + "다리의 길이는 3이상 20이하여야 합니다.";
    public static final String InvalidMoveCommand = ERROR + "U와 D방향으로 이동할 수 있습니다.";
}
