### 기능 구현 목록

- 숫자를 입력 받으면 숫자만큼 1이나0을 생성하고 1를 U로 0을 D로 바꾼 후 List로 반환한다.
- 1과 U, 0과 D를 enum으로 묶고 1이 입력시 U를 0 입력시 D를 반환하는 메서드 구현.
- list string을 클래스 변수를 갖는 Bridge 클래스 구현. 컨트롤 키와 판의 횟수를 받으면 일치여부를 반환.
- 입력키와 매치 결과를 클래스 변수로 갖고 한 칸의 움직인 결과를 갖는 MoveResult
- boolen 값이 fail일시 X를 true일시 O의 값을 갖는 enum CrossResult 구현
- moveResult의 일급 컬렉션 MoveResult, moveResult 요소를 추가 받고, 실패한 값을 지울 수 있다.