package bridge;

import java.util.List;

public class Game {
	private final OutputView outputview = new OutputView();
	private final InputView inputview = new InputView();
	
	public void start() {
		outputview.printgamestart();
		List<String> bridge = makebridge();
		//탈출 or 게임 끝나기 전까지 무한 게임 진행
		//결과 출력
	}
	
	public List<String> makebridge(){
		outputview.printinputbridgesize();
		
		int size = inputview.readBridgeSize();
		
		BridgeMaker bridgemaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		
		return bridgemaker.makeBridge(size);
	}
	
	
}
