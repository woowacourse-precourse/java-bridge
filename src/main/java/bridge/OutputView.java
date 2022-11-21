package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String[] lines) {
        String firstLine = trimLine(lines[0]);
        String secondLine = trimLine(lines[1]);
        System.out.println(firstLine);
        System.out.println(secondLine);
    }

    public String trimLine(String line){
        line = line.replaceAll("", " | ");
        line = line.substring(2, line.length()-2);
        line = "[" + line + "]";
        return line;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String[] lines, String result, int count) {
        System.out.println("최종 게임 결과");
        printMap(lines);
        System.out.println("\n게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + count);
    }

    public void printLine(String s){
        System.out.println(s);
    }
}
