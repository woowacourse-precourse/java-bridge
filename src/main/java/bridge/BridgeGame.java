package bridge;

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

    public void gameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

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

        String upBridge = sbUp.substring(0, sbUp.toString().length() - 1) + "]";
        String doBridge = sbDo.substring(0, sbDo.toString().length() - 1) + "]";

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

    public boolean isFinish(String str){
        if(str.equals("Q")){
            return false;
        }
        return true;
    }

    public void printMapStart(){
        if(size == 0){
            sbUp.append("[");
            sbDo.append("[");
        }
    }

    public void midOrLast(List<String> bridge, int size){
        if(bridge.size()-1 != size){
            sbUp.append("|");
            sbDo.append("|");
        }
        if(bridge.size()-1 == size){
            sbUp.append("]");
            sbDo.append("]");
        }
    }

    public String printMoveUpDown(List<String> bridge, String input, int step){
        if(bridge.get(step).equals(input)){
            return " O ";
        }
        return " X ";
    }

    public void printGoUp(List<String> bridge, String input, int step){
        String result = printMoveUpDown(bridge, input, step);
        if(bridge.get(step).equals("U")) {
            if (result.equals(" O ")) {
                sbUp.append(result);
                sbDo.append("   ");
            }
            if (result.equals(" X ")) {
                sbUp.append("   ");
                sbDo.append(result);
            }
        }
    }

    public void printGoDown(List<String> bridge, String input, int step){
        String result = printMoveUpDown(bridge, input, step);
        if(bridge.get(step).equals("D")) {
            if (result.equals(" O ")) {
                sbUp.append("   ");
                sbDo.append(result);
            }
            if (result.equals(" X ")) {
                sbUp.append(result);
                sbDo.append("   ");
            }
        }
    }

    public String printFinalBridge(List<String> bridge){
        String result = sbUp + System.getProperty("line.separator") + sbDo;

        if(size != bridge.size()){
            result = sbUp.substring(0, sbUp.toString().length()-1) + "]"
                    + System.getProperty("line.separator")
                    + sbDo.substring(0, sbDo.toString().length()-1) + "]";
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
