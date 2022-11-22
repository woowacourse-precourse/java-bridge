1. 주어진 클래스 파일들 mvc 목적에 맞게 패키지 수정
2. 다리에 대한 정보를 담고 있는 Bridge 클래스 생성
    - Bridge 클래스 생성할 때 정상적으로 생성되는지 검증 로직 추가
        - U, D 으로만 구성된 bridge가 맞는지 검사
3. Bridge 모델과 관련하여 공통으로 사용할 상수 클래스 추가
4. Bridge 위, 아래 칸에 대한 enum 추가
5. BridgeMaker의 makeBridge 메서드로 Bridge 생성하도록 구현
    - 0, 1 이외의 숫자로 BridgeSpace를 선택할 경우에만 정상 동작
6. 출력문으로 사용할 문자열들 모아둘 상수 클래스 추가
7. 에러 출력문으로 사용할 문자열들 모아둘 상수 클래스 추가
8. OutputView 클래스에 출력 관련 메서드들 구현
    - printMap, printResult 메서드는 BridgeGame, BridgeGameController 완성 후에 구현
9. InputView 클래스에 입력 관련 메서드들 구현
10. BridgeGame 클래스에 게임 관련 메서드들 구현
    - 다리를 움직이는 move 메서드 구현
    - move 메서드를 호출할 때마다 상태 업데이트 하는 check 메서드 구현
    - 재시도 할 경우 상태 초기화 해주는 retry 메서드 구현
11. 게임을 진행을 호출하기 위한 BridgeGameController 추가
    - 필드로 InputView, OutputView, Bridge, BridgeGame 과 게임 종료 상태인 complete 을 가짐
12. BridgeGameController에 게임 진행 관련 메서드들 구현
    - 게임을 시작하는 gameStart 메서드 구현
        - 입력을 받아 다음 칸으로 이동하는 move 메서드 구현
        - move 할 때마다 BridgeGame 의 상태를 확인하는 checkBridgeGameStatus 메서드 구현
13. 이동한 칸에 대한 printMap 출력에 관한 enum 클래스 추가
14. 게임 결과별 printResult 출력에 관한 enum 클래스 추가
15. OutputView 클래스의 printMap, printResult 메서드 구현
16. BridgeGameController의 gameStart 메서드 완성
17. main 함수에서 BridgeGameController의 게임 시작 메서드 호출
