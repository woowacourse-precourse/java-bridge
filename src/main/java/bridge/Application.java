package bridge;
import java.util.*;
public class Application {

    public static void main(String[] args)throws IllegalArgumentException {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            int bridgeSize = inputView.readBridgeSize();     
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker maker = new BridgeMaker(bridgeNumberGenerator);
            List<String> movalbeBridge = maker.makeBridge(bridgeSize);
            OutputView outputView = new OutputView();
            BridgeGame startgame = new BridgeGame(movalbeBridge);
            int index =0;
            while (index < movalbeBridge.size()){
                String user = inputView.readMoving();
                boolean isRight = startgame.move(user,index);
                outputView.printMap(user,isRight,index);
                if(!isRight){
                    String retryOrNot = inputView.readGameCommand();
                    if(!startgame.retry(retryOrNot)) break;
                    index =0;
                    outputView.removePrintMap();
                    continue;
                }
                index++;
            }
            boolean bridgeGameResult = startgame.result();
            outputView.printResult();
            outputView.printSuccessOrFailure(bridgeGameResult, startgame.getAttempts());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]"+e.getMessage());
        }


    }
}
