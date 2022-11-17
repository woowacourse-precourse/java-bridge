package bridge.application;

import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.SelectMove;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ViewService {
    private static final ViewService instance=new ViewService();
    private final InputView inputView;
    private final OutputView outputView;
    private ViewService(){
        inputView=new InputView();
        outputView=new OutputView();
    }
    public static ViewService getInstance(){
        return instance;
    }
    public BridgeSize inputBridgeSize(){
        return inputView.readBridgeSize();
    }
    public SelectMove inputSelectMove(){
        return inputView.readMoving();
    }
    public void printGameRunMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printInputBridgeSizeMessage(){
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printSelectMoveMessage(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D");
    }
}
