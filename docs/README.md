# 기능 구현
### BridgeGame 클래스
 - move() // 사용자가 칸을 이동할 때 사용하는 메서드
 - retry() // 사용자가 게임을 다시 시작할 때 사용하는 메서드

### BridgeMaker 클래스
 - makeBridge() // 입력받은 길이에 해당하는 다리 모양 리턴
 
### InputView 클래스
- readBridgesize() // 다리 길이 입력받음
- readMoving() // 사용자가 이동할 칸을 입력받음
- readGameCommand() // 게임 재시작 유무를 입력받음

### OutputView 클래스
- checkBrdige() // 다리와 맞는지 체크하는 함수
- separate() // 끝인지 아닌지 구분해 다른 값을 리턴
- printMap() // 현재까지 이동한 다리상태 출력
- printSuccess() // 성공 출력
- printFail1()  // 실패 출력
- printFail2() // 실패 출력
- printResult() // 게임 결과 출력