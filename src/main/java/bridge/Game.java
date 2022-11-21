package bridge;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final OutputView outputview = new OutputView();
	private final InputView inputview = new InputView();
	
	public void start() {
		outputview.printgamestart();
		List<String> bridge = makebridge();
		//탈출 or 게임 끝나기 전까지 무한 게임 진행
		int count = 0, trycount = 1;
		System.out.println(bridge);
		
		boolean result = false;
		List<String> inputlist = new ArrayList<>();
		while(true) {
			outputview.printinputupdownchoice();
			String inputupdown = inputview.readMoving();
			
			inputlist.add(inputupdown);
			
			outputview.printMap(inputlist, bridge);
			
			count++;
			
			if(!inputupdown.equals(bridge.get(count - 1))) {
				outputview.printinputretrychoice();
				String retrychoice = inputview.readGameCommand();
				
				if(retrychoice.equals("Q")) {
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
