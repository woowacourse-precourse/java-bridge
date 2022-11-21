package bridge;

import java.util.List;

import static bridge.Bridge.*;
import static bridge.Bridge.FAILURE_LOWER;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final InputView inputView = new InputView();

    public static boolean move(List<String> bridge, String direct, int index) {
        String movableBlock = bridge.get(index);
        if(movableBlock.equals(direct)){
            return true;
        }
        return false;
    }


    public static boolean retry(Bridge block) {
        boolean availability = block.getResult();
        if(!availability){
            return true;
        }
        return false;
    }

    public static int getBridgeSize(){
        try{
            return inputView.readBridgeSize();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    public static String getMoveDirect(){
        try{
            return inputView.readMoving();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getMoveDirect();
        }
    }

    public static boolean getGameCommand(){
        try{
            return inputView.readGameCommand();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getGameCommand();
        }
    }

    public static List<String> getBridge(int bridgeSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
