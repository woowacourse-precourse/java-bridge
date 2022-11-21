package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private StringBuilder sbUp = new StringBuilder();
    private StringBuilder sbDo = new StringBuilder();
    private int size = 0;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void gameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    public int requestBridgeSize(){
        System.out.println("다리 길이를 입력해주세요.");
        try{
            return inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println("다리 길이를 입력해주세요");
            inputView.readBridgeSize();
        }
        return inputView.readBridgeSize();
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
        printEnd(bridge, step);

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
        outputView.printRequestRetry();
    }

    public void printMapStart(){
        sbUp.append("[");
        sbDo.append("[");
    }

    public void printMapEnd(){
        sbUp.append("]");
        sbDo.append("]");
    }

    public void printMapBetween(){
        sbUp.append("|");
        sbDo.append("|");
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

    public void printEnd(List<String> bridge, int step){
        if(bridge.size() - 1  != step){
            printMapBetween();
        }
        if(bridge.size() - 1 == step){
            printMapEnd();
        }
    }

    public void nextStep(){
        this.size = size + 1;
    }
}
