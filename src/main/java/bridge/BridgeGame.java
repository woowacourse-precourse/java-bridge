package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private String firstLine;
    private String secondLine;

    public BridgeGame(String firstLine, String secondLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
    }

    public void resetAllLine() {
        this.firstLine = "";
        this.secondLine = "";
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setLine(String stringOfFirstLine, String stringOfSecondLine) {
        firstLine += stringOfFirstLine;
        secondLine += stringOfSecondLine;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String elementOfBridge, String input) {
        String setString = determineSetString(elementOfBridge, input);
        if (checkAndSetLine(setString, input)) {
            return true;
        }
        return false;
    }

    public String determineSetString(String elementOfBridge, String input) {
        if (elementOfBridge.equals(input)) {
            return "O";
        }
        return "X";
    }

    public boolean checkAndSetLine(String setString, String input) {
        if (input.equals("U")) {
            setLine("setString", " ");
            return true;
        }
        setLine(" ", "setString");
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if(input.equals("R")){
            resetAllLine();
            return true;
        }
        return false;
    }
}
