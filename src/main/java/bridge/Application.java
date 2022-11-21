package bridge;


import java.util.List;

public class Application {
    static InputView input = new InputView();
    static OutputView output = new OutputView();

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGame bridgeGame = getBridgeGame();
        while(bridgeGame.clear()) //게임클리어여부
        {
            gameMove(bridgeGame); //이동
            output.printMap(bridgeGame.board, bridgeGame.step, bridgeGame.result); //맵출력
            if(!bridgeGame.result && !gameRetry(bridgeGame)) //이동실패시 재시작 여부에 따라
                break;
        }
        output.printResult(bridgeGame.board, bridgeGame.step, bridgeGame.result, bridgeGame.retryNum); //게임 결과 출력
    }

    public static BridgeGame getBridgeGame(){
        while(true){
            try{
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                int boardSize = input.readBridgeSize();
                return new BridgeGame(bridgeMaker.makeBridge(boardSize));
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void gameMove(BridgeGame bridgeGame){
        while(true){
            try{
                String move = input.readMoving();
                bridgeGame.move(move);
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.");
            }
        }
    }

    public static boolean gameRetry(BridgeGame bridgeGame){
        while(true){
            try{
                String command = input.readGameCommand();
                return bridgeGame.retry(command);
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 게임 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.");
            }
        }
    }
}
