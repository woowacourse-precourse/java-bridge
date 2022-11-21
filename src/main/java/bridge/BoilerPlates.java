package bridge;

public class BoilerPlates {
	public static void printFailedUp (String mapU,String mapD){
		System.out.println(mapU + "| X ]");
		System.out.println(mapD + "|   ]");
	}
	public static void printFailedDown (String mapU,String mapD){
		System.out.println(mapU + "|   ]");
		System.out.println(mapD + "| X ]");
	}
	public static void printCompleteUp (String mapU,String mapD){
		System.out.println(mapU + "| O ]");
		System.out.println(mapD + "|   ]");
	}
	public static void printCompleteDown (String mapU,String mapD){
		System.out.println(mapU + "|   ]");
		System.out.println(mapD + "| O ]");
	}
	public static void printMap (String mapU,String mapD){
		System.out.println(mapU + "]");
		System.out.println(mapD + "]");
	}
}
