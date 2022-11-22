package bridge.view;

import bridge.dto.BridgeMapDto;
import bridge.dto.RetryCountDto;
import bridge.model.entity.BridgeMap;
import bridge.model.value.BridgeIngredient;
import bridge.model.value.OutMessage;

import java.util.List;

import static bridge.model.value.OutMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * - 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
 * - `OutputView`의 패키지는 변경할 수 있다.
 * - `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * - 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    public void printMessage(OutMessage message){
        System.out.println(message.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeMapDto bridgeMapDto) {
        String upMap = createPrintMap(bridgeMapDto.getUpMap());
        String downMap = createPrintMap(bridgeMapDto.getDownMap());
        System.out.println(upMap);
        System.out.println(downMap);
    }

    private String createPrintMap(List<String> map){
        String strMap = BridgeIngredient.START.getIngredient() + BridgeIngredient.BLANK.getIngredient();
        for(int i = 0; i < map.size(); i ++){
            strMap += map.get(i) + BridgeIngredient.BLANK.getIngredient();
            if(i != map.size() - 1) {
                strMap += BridgeIngredient.SEPARATOR.getIngredient();
                strMap += BridgeIngredient.BLANK.getIngredient();
            }
        }
        strMap += BridgeIngredient.END.getIngredient();
        return strMap;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printSuccessOrNot(String result){
        System.out.printf(SUCCES_OR_NOT_MESSAGE.getMessage(), result);
    }
    public void printTryCount(RetryCountDto dto){
        System.out.printf(TRY_COUNT_MESSAGE.getMessage(), dto.getRetryCount());
    }
}
