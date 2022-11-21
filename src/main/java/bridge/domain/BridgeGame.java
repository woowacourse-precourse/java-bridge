package bridge.domain;

import bridge.variable.Variable;
import bridge.view.InputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private StringBuilder sbUp = new StringBuilder();
    private StringBuilder sbDo = new StringBuilder();
    private int size = 0;
    private int tryCount = 1;

    InputView inputView = new InputView();

    public List<String> makeBridge(int step){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(step);
    }

    public int getSize(){
        return size;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridge, String input, int step) {
        printMapStart();
        printGoUp(bridge, input, step);
        printGoDown(bridge, input, step);
        midOrLast(bridge, step);

        String upBridge = sbUp.substring(0, sbUp.toString().length() - 1) + Variable.END_BRACKET.getStr();
        String doBridge = sbDo.substring(0, sbDo.toString().length() - 1) + Variable.END_BRACKET.getStr();

        return upBridge + System.getProperty("line.separator") + doBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String input = inputView.readGameCommand();
        if(!isFinish(input)){
            return;
        }
        clearResultRestart();
        initLevel();
    }

    private boolean isFinish(String str){
        if(str.equals(Variable.QUIT.getStr())){
            return false;
        }
        return true;
    }

    private void printMapStart(){
        if(size == 0){
            sbUp.append(Variable.START_BRACKET.getStr());
            sbDo.append(Variable.START_BRACKET.getStr());
        }
    }

    private void midOrLast(List<String> bridge, int size){
        if(bridge.size()-1 != size){
            sbUp.append(Variable.MID_BRACKET.getStr());
            sbDo.append(Variable.MID_BRACKET.getStr());
        }
        if(bridge.size()-1 == size){
            sbUp.append(Variable.END_BRACKET.getStr());
            sbDo.append(Variable.END_BRACKET.getStr());
        }
    }

    public String printMoveUpDown(List<String> bridge, String input, int step){
        if(bridge.get(step).equals(input)){
            return Variable.SUCCESS.getStr();
        }
        return Variable.FAIL.getStr();
    }

    public void printGoUp(List<String> bridge, String input, int step){
        String result = printMoveUpDown(bridge, input, step);
        if(bridge.get(step).equals(Variable.UP.getStr())) {
            if (result.equals(Variable.SUCCESS.getStr())) {
                sbUp.append(result);
                sbDo.append(Variable.BLANK.getStr());
            }
            if (result.equals(Variable.FAIL.getStr())) {
                sbUp.append(Variable.BLANK.getStr());
                sbDo.append(result);
            }
        }
    }

    private void printGoDown(List<String> bridge, String input, int step){
        String result = printMoveUpDown(bridge, input, step);
        if(bridge.get(step).equals(Variable.DOWN.getStr())) {
            if (result.equals(Variable.SUCCESS.getStr())) {
                sbUp.append(Variable.BLANK.getStr());
                sbDo.append(result);
            }
            if (result.equals(Variable.FAIL.getStr())) {
                sbUp.append(result);
                sbDo.append(Variable.BLANK.getStr());
            }
        }
    }

    public String printFinalBridge(List<String> bridge){
        String result = sbUp + System.getProperty("line.separator") + sbDo;

        if(size != bridge.size()){
            result = sbUp.substring(0, sbUp.toString().length()-1) + Variable.END_BRACKET.getStr()
                    + System.getProperty("line.separator")
                    + sbDo.substring(0, sbDo.toString().length()-1) + Variable.END_BRACKET.getStr();
        }

        return result;
    }

    public void nextStep(){
        this.size = size + 1;
    }

    public int getTryCount(){
        return tryCount;
    }

    public void initLevel(){
        this.tryCount = tryCount + 1;
        this.size = 0;
    }

    public void clearResultRestart(){
        sbUp.delete(0, sbUp.length());
        sbDo.delete(0, sbDo.length());
    }
}
