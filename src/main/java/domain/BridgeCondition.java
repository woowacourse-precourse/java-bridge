
package domain;

/**
 * 이동 상태를 보여주는 enum클래스 
 *
 */
public enum BridgeCondition {
	RIGHT(" O "),
	WRONG(" X "),
	EMPTY("   ");
	
	private final String condition;
	
	private BridgeCondition(String condition) {
		this.condition = condition;
	}
	public String getCondition() {
		return condition;
	}

}
