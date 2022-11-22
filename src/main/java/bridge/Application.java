package bridge;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ReadSize readSize = new ReadSize();
        while (readSize.bridgeSize()==-1){
            readSize = new ReadSize();
        }
        BridgeNumberGenerator bridgeNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeU=bridgeMaker.makeBridge(readSize.bridgeSize());
        List<String> bridgeD=bridgeMaker.makeBridge(readSize.bridgeSize());

        for (int i=1;i<=readSize.bridgeSize();i++){
            ReadMove readMove = new ReadMove();
            while (readMove.movecmd()==null){
                readMove = new ReadMove();
            }
            BridgeGame bridgeGame = new BridgeGame();
            String movecmd1=bridgeGame.move(bridgeU,readMove.movecmd(),i);
            if (movecmd1!=null){
                OutputView outputView = new OutputView();
                outputView.printMap(bridgeU,"U",movecmd1,i,readSize.bridgeSize());
            }
            String movecmd2=bridgeGame.move(bridgeD,readMove.movecmd(),i);
            if (movecmd2!=null){
                OutputView outputView = new OutputView();
                outputView.printMap(bridgeD,"D",movecmd2,i,readSize.bridgeSize());
            }
        }
    }
}
class ReadSize{
    static final int ERROR=-1;
    public int bridgeSize(){
        InputView inputview = new InputView();  int size=0;
        try { size=inputview.readBridgeSize(); }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ERROR;
        }
        return size;
    }
}

class ReadMove {
    public String movecmd() {
        InputView inputview = new InputView();
        String cmd;
        try {
            cmd = inputview.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return cmd;
    }
}