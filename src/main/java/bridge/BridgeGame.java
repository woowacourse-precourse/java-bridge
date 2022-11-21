package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final InputView inputView = new InputView();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean move(List<String> bridge, String direct, int index) {
        String movableBlock = bridge.get(index);
        if(movableBlock.equals(direct)){
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public static boolean isSuccess(int bridgeSize, int index){
        return bridgeSize == index;
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
