package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static InputView inputView = new InputView();
    public static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    public static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public static BridgeGame bridgeGame = new BridgeGame();
    public static OutputView outputView = new OutputView();
    /*
    확인 사항
    1.총 시도 횟수 입력 예외처리
    2.다리 길이 입력 예외처리
    3.이동할 칸 입력 예외처리
    4.재시작 여부 입력 예외처리
     */
    //1.입력: 다리 길이
    //반복
    //2.다리 생성: 무작위 0,1로 생성
    //3.사용자 이동: 다리길이반큼 반복
    //1)입력: 이동할 칸
    //2)만약 U 이고 윗 다리가 1 이면: O
    //3)만약 U 이고 윗 다리가 0 이면: X
    //반복 중단
    //4)만약 D이고 아랫 다리가 1이면: X
    //5)만약 D이고 아랫 다리가 0이면: O
    //반복 중단
    //4.입력: 다리를 못건넜으면 다시 시도 여부 (R,Q)
    //1)R이면 재시작
    //2)Q이면 중단, 세임 결과 출력
    //5.출력: 게임 성공 여부, 총 시도한 횟수
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1.입력: 다리 길이
        //반복
        //2.다리 생성: 무작위 0,1로 생성
        //3.사용자 이동: 다리길이반큼 반복
        //1)입력: 이동할 칸
        //2)만약 U 이고 윗 다리가 1 이면: O
        //3)만약 U 이고 윗 다리가 0 이면: X
        //반복 중단
        //4)만약 D이고 아랫 다리가 1이면: X
        //5)만약 D이고 아랫 다리가 0이면: O
        //반복 중단
        //4.입력: 다리를 못건넜으면 다시 시도 여부 (R,Q)
        //1)R이면 재시작
        //2)Q이면 중단, 세임 결과 출력
        //5.출력: 게임 성공 여부, 총 시도한 횟수
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridges);

        while(true){
            String possibleMove="";
            String upBridge="";
            String downBridge="";
            List<String> curBridges = new ArrayList<>();
            curBridges.add(""); curBridges.add("");
            boolean flag= false;

            for(int i=0;i<bridgeSize;i++){
                String inputMove = inputView.readMoving();
                System.out.println("이번 입력은: "+inputMove);

                possibleMove = bridgeGame.move(inputMove, bridges, i);
                System.out.println("possibleMove는"+possibleMove);

                if(inputMove.equals("U") && possibleMove.equals("O")){
                    upBridge = curBridges.get(0);
                    upBridge += "O";
                    curBridges.set(0, upBridge);
                    downBridge = curBridges.get(1);
                    downBridge+=" ";
                    curBridges.set(1, downBridge);
                    System.out.println("1번 경우");
                }
                if(inputMove.equals("U") && possibleMove.equals("X")){
                    upBridge = curBridges.get(0);
                    upBridge += "X";
                    curBridges.set(0, upBridge);
                    downBridge = curBridges.get(1);
                    downBridge+=" ";
                    curBridges.set(1, downBridge);
                    System.out.println("2번 경우");

                    flag = true;
                }
                if(inputMove.equals("D") && possibleMove.equals("O")){
                    upBridge = curBridges.get(0);
                    upBridge += " ";
                    curBridges.set(0, upBridge);
                    downBridge = curBridges.get(1);
                    downBridge+="O";
                    curBridges.set(1, downBridge);
                    System.out.println("3번 경우");
                }
                if(inputMove.equals("D") && possibleMove.equals("X")){
                    upBridge = curBridges.get(0);
                    upBridge += " ";
                    curBridges.set(0, upBridge);
                    downBridge = curBridges.get(1);
                    downBridge+="X";
                    curBridges.set(1, downBridge);
                    System.out.println("4번 경우");
                    flag = true;
                }
                //출력: 현재까지 다리
                outputView.printMap(curBridges, i);
                if(flag){ break;}
            }
        }
    }
}
