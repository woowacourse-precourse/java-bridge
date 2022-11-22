# 🔍 OutputView

다리 건너기 게임의 출력을 담당하는 클래스이다.  
메소드의 이름을 변경할 수 없으며, 필요하다면 메소드 추가는 가능하다.

* __메소드 종류__

> * 다리 출력 `printMap()`
> * 게임 결과 출력 `printResult()`

### 다리 출력 `printMap()`

위쪽 다리와 아래쪽 다리 리스트를 받아서 Arrays.toString() 한 값을 String 타입 변수에 저장한다. - `printMap()`
콤마(,)를 구분자(|)로 바꾼 값을 각기 출력한다. - `replaceResult()`

### 게임 결과 출력 `printResult()`