package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private String[] lines;

    public BridgeGame() {
        this.lines = new String[]{"", ""};
    }

    public void resetAllLine() {
        this.lines[0] = "";
        this.lines[1] = "";
    }

    public String[] getLines() {
        return this.lines;
    }

    public void setLine(String stringOfFirstLine, String stringOfSecondLine) {
        this.lines[0] += stringOfFirstLine;
        this.lines[1] += stringOfSecondLine;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String elementOfBridge, String input) {
        String result = determineResult(elementOfBridge, input);
        if(isTheFirstLine(input)){
            setLine(result, " ");
        }else {
            setLine(" ", result);
        }
    }

    public String determineResult(String elementOfBridge, String input) {
        if (elementOfBridge.equals(input)) {
            return "O";
        }
        return "X";
    }

    public boolean isTheFirstLine(String input) {
        if (input.equals("U")) {
            return true;
        }
        return false;
    }

    public boolean isFailed(){
        if(this.lines[0].contains("X") || this.lines[1].contains("X")){
            return true;
        }
        return false;
    }

    public boolean isSucceed(int answerSize){
        if(answerSize == getLines()[0].length()){
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if (input.equals("R")) {
            resetAllLine();
            return true;
        }
        return false;
    }
}
