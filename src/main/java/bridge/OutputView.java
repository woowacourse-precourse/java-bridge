package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static final String gamestart = "다리 건너기 게임을 시작합니다.";
	private static final String inputbridgesize = "다리의 길이를 입력하세요.";
	private static final String inputupdownchoice = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String inputretrychoice = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	
	public void printgamestart() {
		System.out.println(gamestart);
	}
	
	public void printinputbridgesize() {
		System.out.println("\n" + inputbridgesize);
	}
	
	public void printinputupdownchoice() {
		System.out.println("\n" + inputupdownchoice);
	}

	public void printinputretrychoice() {
		System.out.println("\n" + inputretrychoice);
	}
	
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> inputlist, List<String> bridge) {
    	printupdown(inputlist, bridge, "U");
    	printupdown(inputlist, bridge, "D");
    }
    
    public void printupdown(List<String> inputlist, List<String> bridge, String choice) {
    	String result = "";
    	
    	for(int i = 0; i < inputlist.size(); i++) {
    		if(i > 0 && i < inputlist.size()) {
    			result += " | ";
    		}
    		if(!inputlist.get(i).equals(choice)) {
    			result += " ";
    			continue;
    		}
    		if(inputlist.get(i).equals(bridge.get(i))) {
    			result += "O";
    			continue;
    		}
    		
    		result += "X";
    	}
    	System.out.println("[ " + result + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean win, int trycount, List<String> inputlist, List<String> bridge) {
    	System.out.println("최종 게임 결과");
    	
    	printMap(inputlist, bridge);
    	
		System.out.print("\n게임 성공 여부: ");
		
		if(win) {
			System.out.println("성공");
		}
		if(!win) {
			System.out.println("실패");
		}
		System.out.println("총 시도한 횟수: " + trycount);
    }
}
