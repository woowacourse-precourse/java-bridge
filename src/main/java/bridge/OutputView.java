package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    Application app = new Application();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String[] printMap(List<String> bridgeInput,String bridgeUserInput,boolean same) {
        String[] BridgeOutputView = nextStep(bridgeInput);
        BridgeOutputView=addPassFail(BridgeOutputView,bridgeUserInput,same);
        System.out.println("["+BridgeOutputView[0]+"]");
        System.out.println("["+BridgeOutputView[1]+"]");
        return BridgeOutputView;
    }

    public String[] nextStep(List<String> bridgeUserInput){
        String [] BridgeOutputView = new String[2];
        BridgeOutputView[0] = ""; BridgeOutputView[1] ="";
        for(int i = 0 ; i < bridgeUserInput.size() - 1 ; i++){
            BridgeOutputView = addUpDownResult(BridgeOutputView,bridgeUserInput.get(i));
            BridgeOutputView[0] += "|";
            BridgeOutputView[1] += "|";
        }
        return BridgeOutputView;
    }

    public String[] addUpDownResult(String[] BridgeOutputView,String userInput) {
        if(userInput.equals("U")){
            BridgeOutputView[0] += " O ";
            BridgeOutputView[1] += "   ";
        } else if(userInput.equals("D")){
            BridgeOutputView[0] += "   ";
            BridgeOutputView[1] += " O ";
        }
        return BridgeOutputView;
    }
    public String[] addPassFail(String[] BridgeOutputView,String userInput,boolean same) {
        if(userInput.equals("U")&& same ==true){
            BridgeOutputView[0] += " O ";
            BridgeOutputView[1] += "   ";
        } else if(userInput.equals("D")&&same == false){
            BridgeOutputView[0] += "   ";
            BridgeOutputView[1] += " O ";
        }
        return BridgeOutputView;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String[] BridgeOutputView,boolean successFail,int count) {
        System.out.println("최종 게임 결과");
        System.out.println(BridgeOutputView[0]);
        System.out.println(BridgeOutputView[1]);
        if(successFail==true) System.out.println("게임 성공 여부: 성공");
        else if(successFail == false) System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + count);
    }
    public void printStartGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printLengthBridge(){
        System.out.println("다리의 길이를 입력해 주세요.");
    }
    public void printMovingChoice(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printRetry(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
