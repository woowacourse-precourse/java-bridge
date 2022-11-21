package bridge;

public class BoilerPlates {
	public static void printFinalFailedUp(String mapU,String mapD,int gameCount){
		System.out.println("최종 게임 결과");
		if(mapU.length() >3){
			System.out.println(mapU + "| X ]");
			System.out.println(mapD + "|   ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + " X ]");
			System.out.println(mapD + "   ]");
		}
		System.out.println("게임 성공 여부: 실패");
		System.out.println("총 시도한 횟수: "+gameCount);
	}
	public static void printFinalFailedDown(String mapU,String mapD,int gameCount){
		System.out.println("최종 게임 결과");
		if(mapU.length() >3){
			System.out.println(mapU + "|   ]");
			System.out.println(mapD + "| X ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + "   ]");
			System.out.println(mapD + " X ]");
		}
		System.out.println("게임 성공 여부: 실패");
		System.out.println("총 시도한 횟수: "+gameCount);
	}
	public static void printCompleteUp (String mapU,String mapD,int gameCount){
		System.out.println("최종 게임 결과");
		if(mapU.length() >3){
			System.out.println(mapU + "| O ]");
			System.out.println(mapD + "|   ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + " O ]");
			System.out.println(mapD + "   ]");
		}
		System.out.println("게임 성공 여부: 성공");
		System.out.println("총 시도한 횟수: "+gameCount);

	}
	public static void printCompleteDown (String mapU,String mapD,int gameCount){
		System.out.println("최종 게임 결과");
		if(mapU.length() >3){
			System.out.println(mapU + "|   ]");
			System.out.println(mapD + "| O ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + "   ]");
			System.out.println(mapD + " O ]");
		}
		System.out.println("게임 성공 여부: 성공");
		System.out.println("총 시도한 횟수: "+gameCount);
	}
	public static void printFailedUp (String mapU,String mapD,int gameCount){

		if(mapU.length() >3){
			System.out.println(mapU + "| X ]");
			System.out.println(mapD + "|   ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + " X ]");
			System.out.println(mapD + "   ]");
		}
	}
	public static void printFailedDown (String mapU,String mapD,int gameCount){
		if(mapU.length() >3){
			System.out.println(mapU + "|   ]");
			System.out.println(mapD + "| X ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + "   ]");
			System.out.println(mapD + " X ]");
		}
	}
	public static void printResultUp (String mapU,String mapD,int gameCount){

		if(mapU.length() >3){
			System.out.println(mapU + "| O ]");
			System.out.println(mapD + "|   ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + " O ]");
			System.out.println(mapD + "   ]");
		}
	}
	public static void printResultDown (String mapU,String mapD,int gameCount){
		if(mapU.length() >3){
			System.out.println(mapU + "|   ]");
			System.out.println(mapD + "| O ]");
		}
		if(mapU.length() <=3){
			System.out.println(mapU + "   ]");
			System.out.println(mapD + " O ]");
		}
	}

	public static void printMap (String mapU,String mapD){
		System.out.println(mapU + "]");
		System.out.println(mapD + "]");
	}
	public static void readBridgeSize (){
		System.out.println("다리 건너기 게임을 시작합니다.");
		System.out.println("다리의 길이를 입력해주세요.");
	}
	public static void readMoving (){
		System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
	}
	public static void readGameCommand (){
		System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
	}
}
