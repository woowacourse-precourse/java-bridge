package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String BLANK = " ";
    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String UP = "U";
    private static final String DOWN = "D";


    private final List<String> bridge;
    private final InputView inputView;
    private final OutputView outputView;

    public List<String> upperLine = new ArrayList<>();
    public List<String> lowerLine = new ArrayList<>();

    public BridgeGame(List<String> bridge, InputView inputView, OutputView outputView){
        this.bridge = bridge;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public boolean move() {
        for (int index = 0; index < bridge.size(); index++) {
            if (!moveOne(index)) {
                outputView.printMap(upperLine, lowerLine);
                return false;
            }
            outputView.printMap(upperLine,lowerLine);
        }
        return true;
    }
    public void markCorrect(String userInput){
        if ( userInput.equals(UP)) {
            upperLine.add(CORRECT);
            lowerLine.add(BLANK);
        }
        if ( userInput.equals(DOWN)){
            upperLine.add(BLANK);
            lowerLine.add(CORRECT);
        }
    }

    public void markIncorrect(String userInput){
        if ( userInput.equals(UP)) {
            upperLine.add(WRONG);
            lowerLine.add(BLANK);
        }
        if ( userInput.equals(DOWN)){
            upperLine.add(BLANK);
            lowerLine.add(WRONG);
        }
    }

    public void makeMap(boolean correct,String userInput){
        if ( correct ){
            markCorrect(userInput);
        }
        if ( !correct ){
            markIncorrect(userInput);
        }
    }

    public boolean moveOne(int index) {
        String userInput = inputView.readMoving();
        if(bridge.get(index).equals(userInput)){
            makeMap(true,userInput);
            return true;
        }
        makeMap(false,userInput);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String readCommand) {
        if (readCommand.equals("R")) { return true; }
        return false;
    }
}
