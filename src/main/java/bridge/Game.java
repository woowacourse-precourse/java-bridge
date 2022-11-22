package bridge;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final OutputView outputview = new OutputView();
	private final InputView inputview = new InputView();
	private final BridgeGame bridgegame = new BridgeGame();
	
	public void start() {
		outputview.printgamestart();
		List<String> bridge = makebridge();
		int count = 0, trycount = 1;
		System.out.println(bridge);
		
		boolean result = false;
		List<String> inputlist = new ArrayList<>();
		while(true) {
			outputview.printinputupdownchoice();
			
			bridgegame.move(inputlist, bridge);
			
			count++;
			
			if(!inputlist.get(count - 1).equals(bridge.get(count - 1))) {
				if(bridgegame.retry()) {
					break;
				}
				
				count = 0;
				trycount++;
				inputlist.clear();
			}
			
			if(count == bridge.size()) {
				result = true;
				break;
			}
		}
		//결과 출력
		outputview.printResult(result, trycount, inputlist, bridge);
	}
	
	public List<String> makebridge(){
		outputview.printinputbridgesize();
		
		int size = inputview.readBridgeSize();
		
		BridgeMaker bridgemaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		
		return bridgemaker.makeBridge(size);
	}
}
