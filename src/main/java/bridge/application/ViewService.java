package bridge.application;

import bridge.domain.repository.BridgeRepository;
import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.GameCommand;
import bridge.presentation.dto.SelectMove;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ViewService {
    private static final ViewService instance=new ViewService();
    private final BridgeRepository bridgeRepository;
    private final InputView inputView;
    private final OutputView outputView;
    private ViewService(){
        bridgeRepository=BridgeRepository.getInstance();
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
    public GameCommand inputGameCommand(){return inputView.readGameCommand();}
    public void printMoveResult(){
        outputView.printMap(bridgeRepository.getUpperResult(),bridgeRepository.getLowerResult());
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
    public void printInputRetryMessage(){outputView.printInputRetryMessage();}
}
