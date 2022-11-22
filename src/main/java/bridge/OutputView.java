package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> posList, Boolean res) {
        List<String> result = makeResult();

        for (int i = 0; i < posList.size() - 1; i++) {
            result = basicUorD(result, posList.get(i).equals("U"));
        }

        result = lastTrueOrFalse(posList, res, result);

        result = closeResult(result);
        System.out.println("listU = " + result.get(0));
        System.out.println("listD = " + result.get(1));
    }

    private List<String> lastTrueOrFalse(List<String> posList, Boolean res, List<String> result) {
        if (res) {
            return lastUorDatTrue(result, posList.get(posList.size() - 1).equals("U"));
        }
        return lastUorDatFalse(result, posList.get(posList.size() - 1).equals("U"));
    }


    public List<String> lastUorDatFalse(List<String> list, Boolean res) {
        if (res) {
            return addListUAtLastAndFalse(list);
        }
        return addListDAtLastAndFalse(list);
    }

    public List<String> lastUorDatTrue(List<String> list, Boolean res) {
        if (res) {
            return addListUAtLastAndTrue(list);
        }
        return addListDAtLastAndTrue(list);
    }

    public List<String> basicUorD(List<String> list, Boolean res) {
        if (res) {
            return addListU(list);
        }
        return addListD(list);
    }

    public List<String> closeResult(List<String> list) {
        List<String> result = new ArrayList<>();
        String listU = list.get(0);
        String listD = list.get(1);

        listU += "]";
        listD += "]";

        result.add(listU);
        result.add(listD);

        return result;
    }

    public List<String> makeResult() {
        List<String> result = new ArrayList<>();

        String list = "[";
        result.add(list);
        result.add(list);

        return result;
    }

    public List<String> addListU(List<String> list) {
        List<String> result = new ArrayList<>();

        String listU = list.get(0);
        String listD = list.get(1);

        listU += " O |";
        listD += "   |";

        result.add(listU);
        result.add(listD);

        return result;
    }

    public List<String> addListD(List<String> list) {
        List<String> result = new ArrayList<>();

        String listU = list.get(0);
        String listD = list.get(1);

        listU += "   |";
        listD += " O |";

        result.add(listU);
        result.add(listD);

        return result;
    }

    public List<String> addListUAtLastAndTrue(List<String> list) {
        List<String> result = new ArrayList<>();

        String listU = list.get(0);
        String listD = list.get(1);

        listU += " O ";
        listD += "   ";

        result.add(listU);
        result.add(listD);

        return result;
    }

    public List<String> addListDAtLastAndTrue(List<String> list) {
        List<String> result = new ArrayList<>();

        String listU = list.get(0);
        String listD = list.get(1);

        listU += "   ";
        listD += " O ";

        result.add(listU);
        result.add(listD);

        return result;
    }

    public List<String> addListUAtLastAndFalse(List<String> list) {
        List<String> result = new ArrayList<>();

        String listU = list.get(0);
        String listD = list.get(1);

        listU += " X ";
        listD += "   ";

        result.add(listU);
        result.add(listD);

        return result;
    }

    public List<String> addListDAtLastAndFalse(List<String> list) {
        List<String> result = new ArrayList<>();

        String listU = list.get(0);
        String listD = list.get(1);

        listU += "   ";
        listD += " X ";

        result.add(listU);
        result.add(listD);

        return result;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Boolean res, List<String> posList, int count) {
        if (res) {
            System.out.println("최종 게임 결과");
            printMap(posList, true);
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + count);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + count);
    }
}
