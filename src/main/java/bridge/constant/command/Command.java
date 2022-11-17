package bridge.constant.command;

public interface Command {
    int getKey();
    String getValue();

    static String convertKeyToValue(int key, Class<? extends Command> commandClass) {
        // TODO: Command 인터페이스를 구현하는 Enum 클래스에서 key 값에 해당하는 value 값 반환
        return null;
    }
}
