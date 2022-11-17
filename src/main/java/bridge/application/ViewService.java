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
        outputView.printGameRunMessage();
    }
    public void printInputBridgeSizeMessage(){
        outputView.printInputBridgeSizeMessage();
    }
    public void printSelectMoveMessage(){
        outputView.printSelectMoveMessage();
    }
}
