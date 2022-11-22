package bridge;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private InputView input;
    private OutputView outputView;
    private int Attempt=0;
    public BridgeGame(){
        input=new InputView();
        outputView =new OutputView();
        play();
    }
    private void play(){
        start();
        move();
    }
    private void start(){
        int bridgeSize;
        System.out.println("다리 건너기 게임을 시작합니다.");
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            bridgeSize=input.readBridgeSize(Console.readLine());
            bridge=new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }
    private void move() {
        Attempt++;
        int count=0;
        boolean result=true;
        String direction = "";
        try {
            while (result && count != bridge.size()){
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                direction=input.readMoving(Console.readLine());
                result=bridgeFilter(count,direction);
                outputView.printMap(bridge.subList(0,count),direction,result);
                count++;
            }
            if(!result) retry(count,direction);
            else successReport();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            move();
        }
    }
    private void failReport(int count,String direction){
        System.out.println("최종 게임 결과");
        outputView.printFinallyFailBridge(bridge.subList(0,count-1),direction);
        outputView.printResult(Attempt,"실패");
    }

    private void successReport(){
        System.out.println("최종 게임 결과");
        outputView.printFinallyBridge(bridge);
        outputView.printResult(Attempt,"성공");
    }
    private void retry(int count,String direction) {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String command =input.readGameCommand(Console.readLine());
            if(command.equals("R")) move();
            else{
                failReport(count,direction);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry(count,direction);
        }
    }
    private boolean bridgeFilter(int count,String direction){
        return bridge.get(count).equals(direction);
    }
}


