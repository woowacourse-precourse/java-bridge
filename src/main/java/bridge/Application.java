package bridge;
import java.util.*;
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();     // 생성할 다리 길이 입력
        // 다리마다 이동할 수 있는 곳을 무작위로 생성해 그리고 List형태로 저장해
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(bridgeNumberGenerator);
        List<String> movalbeBridge = maker.makeBridge(bridgeSize);
        OutputView outputView = new OutputView();
        BridgeGame startgame = new BridgeGame(movalbeBridge);
        int index =0;
        while (index < movalbeBridge.size()){
            String user = inputView.readMoving();           // 이동할 칸을 입력
            boolean isRight = startgame.move(user,index);   // 이동할 칸과 무작위 값이 같은지 비교해
            outputView.printMap(user,isRight,index++);        // 이동한 칸 찍어줘
            if(isRight) continue;
            String retryOrNot = inputView.readGameCommand();
            if(!startgame.retry(retryOrNot)) break;
            index =0;
            outputView.removePrintMap();
            // 만약에 같으면 conitnue로 게임종료 여부 물어보지마 그리고 while한번 돌아라
            // 게임 종료 여부
        }
        // 최종게임 결과
        outputView.printResult();
        // 게임 성공 여부 출력
        outputView.printSuccessOrFailure();
    }
}
