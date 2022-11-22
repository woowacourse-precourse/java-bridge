package bridge;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<String> upper;
    private final List<String> lower;

    Map(){
        this.upper = new ArrayList<>();
        this.lower = new ArrayList<>();
    }

    /**
     * 사용자의 이동을 맵에 업데이트
     * @param direction 사용자가 입력한 방향
     * @param isRight 사용자의 방향이 올바른 방향인가
     */
    public void update(String direction, boolean isRight){
        if (direction.equals("U")){
            this.upperUpdate(isRight);
            return;
        }
        this.lowerUpdate(isRight);
    }

    /**
     * 사용자의 입력이 맵의 윗부분일 때
     */
    private void upperUpdate(boolean isRight){
        this.lower.add("   ");
        if (isRight){
            this.upper.add(" O ");
            return;
        }
        this.upper.add(" X ");
    }

    /**
     * 사용자의 입력이 맵의 아랫 부분일 떄
     */
    private void lowerUpdate(boolean isRight){
        this.upper.add("   ");
        if (isRight){
            this.lower.add(" O ");
            return;
        }
        this.lower.add(" X ");
    }

    /**
     * 위 아래 맵 정보 모두 초기화
     */
    public void clear(){
        this.upper.clear();
        this.lower.clear();
    }

    /**
     * 위 아래 맵 정보를 각각 맵의 포멧에 맞게 처리 후
     * 리스트에 담아 반환
     */
    public List<String> getPrintableMap(){
        List<String> printableMaps = new ArrayList<>(2);
        String printableUpper = this.upper.toString().replaceAll(", ", "|");
        String printableLower = this.lower.toString().replaceAll(", ", "|");

        printableMaps.add(printableUpper);
        printableMaps.add(printableLower);

        return printableMaps;
    }
}
