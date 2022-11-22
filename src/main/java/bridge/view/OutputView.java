package bridge.view;


import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String SUCCESS = "성공";
    private final String FAIL = "실패";
    private final String UPPER ="U";
    private final String LOWER ="D";
    private OutputLogic outputLogic;
    private Integer bridgeSize;
    public OutputView(List<String> bridgeList){
        this.outputLogic = new OutputLogic(bridgeList);
        this.bridgeSize = bridgeList.size();
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Boolean userResult,int userPosition,String input) {
        outputLogic.setInput(input);
        outputLogic.printMapLogic(UPPER,userPosition,userResult);
        changeLine();
        outputLogic.printMapLogic(LOWER,userPosition,userResult);
        changeLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Boolean userResult,Integer[] userData,String input) {
        System.out.println("최종 게임 결과");
        printMap(userResult,userData[1],input);
        changeLine();
        System.out.printf("게임 성공 여부: %s",isSuccess(userResult));
        changeLine();
        System.out.printf("총 시도한 횟수: %d",userData[0]);
    }
    private String isSuccess(Boolean userResult){
        if(userResult) return SUCCESS;
        return FAIL;
    }
    private void changeLine(){
        System.out.println();
    }
}
