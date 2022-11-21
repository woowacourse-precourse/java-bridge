package bridge.view;

import bridge.model.BridgeGame;
import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static int bridgeSize;
    public static String retryGame;
    static Validator validator = new Validator();

    // 다리의 길이를 입력받는다
    public static int readBridgeSize() {
        OutputView.printBridgeSize();
        String input = Console.readLine();
        System.out.println();
        if(input != null && !input.matches("-?\\d+")){
            validator.checkBridgeSizeInputInteger(input);
            input = validator.inputNum;
        }
        bridgeSize = Integer.parseInt(input);
        if(bridgeSize < 3 || bridgeSize > 20) {
            validator.checkBridgeSize(bridgeSize);
        }
        return bridgeSize;
    }

    // 이동할 값을 입력한다.
    public static String readMoving() {
        OutputView.printSelectBlock();
        String moveCount = Console.readLine();
//        BridgeGame.move();
        return moveCount;
    }




}

/**
 * InputView 의 패키지는 변경할 수 있다. InputView 의 메서드의 시그니처(인자, 이름)와 반환타입은 변경할 수 있다. 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 * <p>
 * View 는 Model 에만 의존하기 Model 로부터 데이터를 받을 땐, 사용자마다 다르게 보이는 데이터만 받기 즉 사용자 모두에게 같은 데이터를 보여줄 땐 View 내에서 해결
 * <p>
 * View 는 Model 에만 의존하기 Model 로부터 데이터를 받을 땐, 사용자마다 다르게 보이는 데이터만 받기 즉 사용자 모두에게 같은 데이터를 보여줄 땐 View 내에서 해결
 * <p>
 * View 는 Model 에만 의존하기 Model 로부터 데이터를 받을 땐, 사용자마다 다르게 보이는 데이터만 받기 즉 사용자 모두에게 같은 데이터를 보여줄 땐 View 내에서 해결
 */

/**
 * View 는 Model 에만 의존하기
 * Model 로부터 데이터를 받을 땐, 사용자마다 다르게 보이는 데이터만 받기
 * 즉 사용자 모두에게 같은 데이터를 보여줄 땐 View 내에서 해결
 */