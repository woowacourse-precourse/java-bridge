package bridge;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final OutputView outputview = new OutputView();
	private final InputView inputview = new InputView();
	private final BridgeGame bridgegame = new BridgeGame();
	
	private List<String> bridge, inputlist = new ArrayList<>();
	private int count = 0, trycount = 1;
	
	public void start() {
		outputview.printgamestart();
		bridge = makebridge();
		System.out.println(bridge);
		
		playgame();
	}
	
	public void playgame() {
		boolean result = false;
		while(true) {
			bridgegame.move(inputlist, bridge);
			
			int checknumber = finishcheck();
			
			if(checknumber == -1) {
				break;
			}
			if(checknumber == 1) {
				result = true;
				break;
			}
		}
		outputview.printResult(result, trycount, inputlist, bridge);
	}
	
	public int finishcheck() {
		if(!inputlist.get(count).equals(bridge.get(count))) {
			if(bridgegame.retry()) {
				return -1;
			}
			count = 0;
			trycount++;
			inputlist.clear();
		}
		
		if(++count == bridge.size()) {
			return 1;
		}
		
		return 0;
	}
	
	public List<String> makebridge(){
		outputview.printinputbridgesize();
		
		int size = inputview.readBridgeSize();
		
		BridgeMaker bridgemaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		
		return bridgemaker.makeBridge(size);
	}
}
