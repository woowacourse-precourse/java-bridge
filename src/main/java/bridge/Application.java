package bridge;

import java.util.List;

public class Application {
    private static void game(BridgeGame bridgeGame, List<String> bridge){
        //이동할 칸 입력받기 & 처리
        InputView inputView = new InputView();
        String readMoving = inputView.readMoving();
        bridgeGame.move(readMoving);
        System.out.println(bridgeGame.getPosition());
        //이동한 칸에 따른 현재 위치 출력
        OutputView outputView = new OutputView();
        if(!bridgeGame.getPosition().get(1).equals(bridge.size())){
            outputView.printMap(bridge, bridgeGame);
        }
        //실패 시 결과에 따라 선택
        if(bridgeGame.getQuestion()){
            String readGameCommand = inputView.readGameCommand();
            if(readGameCommand.equals("R")){
                bridgeGame.retry();
                game(bridgeGame, bridge);
                return;
            }
            if(readGameCommand.equals("Q")){
                outputView.printResult(bridge, bridgeGame);
                return;
            }
        }
        //성공 시 게임 실행 & 최종 성공 결과 출력
        if(bridgeGame.getPosition().get(1).equals(bridge.size())){
            outputView.printResult(bridge, bridgeGame);
            return;
        }
        game(bridgeGame, bridge);
    }

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        //다리 길이 입력받기
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        //다리 만들기
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        //게임 만들기
        BridgeGame bridgeGame = new BridgeGame();
        //게임 실행
        game(bridgeGame,bridge);
    }
}
