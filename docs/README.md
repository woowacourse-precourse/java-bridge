🌈####다리 건너기####🌈
--------------------------------
* Domain, View, Controller 클래스로 나누어 구상한다. 


1. InputView 클래스
- readBridgeSize() -> "다리 건너기 게임을 시작합니다." 출력, "다리의 길이를 입력해주세요." 출력
- readMoving() -> "이동할 칸을 선택해 주세요." 위 : U, 아래 : D를 입력받는다. 
- readGameCommand() -> "게임을 다시 시도할지 여부를 입력해주세요." 재시도일경우 : R, 종료일 경우 : Q를 입력 받고 종료




2. OutputView 클래스
- printMap() -> InputView에서 입력받은 칸에 따른 맵을 출력한다. 
- printResult() -> 최종 게임 결과 O, X가 출력되며, 게임 성공 여부, 총 시도한 횟수가 같이 출력된다.




3. BridgeGame 클래스 
- move() -> 두 칸으로 이루어진 다리 중, 위아래 둘 중 하나의 칸만 건널 수 있고 건넌 칸 중에서 그 칸이 생성된다. 
- retry() -> 다리를 끝까지 건널 때까지 move()를 실행한다. 


4. BridgeMaker 클래스
- makeBridge() -> 다리 값을 입력받으면 그 값에 따른 다리를 생성한다. 

5. BridgeRandomNumberGenerator 클래스 
- 다리 칸 생성을 Random 값으로 생성한다. 
