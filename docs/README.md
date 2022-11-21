# 다리 건너기

## 로직
- #### Application class
    - 프로그램 실행하는 클래스
    - 인스턴스 생성
        * BridgeGame 인스턴스 생성
        * BridgeRandomNumberGenerator 인스턴스 생성
        * BridgeMaker 인스턴스 생성
        * InputView 인스턴스 생성
        * OutputView 인스턴스 생성
        * User 인스턴스 생성
    - 게임 진행
        * OutputView.startGame() 실행
        * 사용자 위치 초기화
        * 다리 크기 입력 및 다리 생성
        * 반복
            * 사용자 이동 방향 입력 및 이동
            * 사용자 위치의 값과 사용자의 이동 방향 비교 -> checkDirection
            * 맵 출력
            * checkDirection이 true 이면서 사용자 위치가 다리의 끝이면 break
                * 결과 출력 및 종료
            * checkDirection이 false일 때
                * 다시 -> 시도 횟수 증가, 사용자 위치 초기화
                * 종료 -> 결과 출력 및 종료

- #### User class
    - 유저 클래스
    - 위치, 게임 진행 횟수, 사용자 현재 방향 정보 저장

- #### BridgeGame class
    - 다리 건너기 게임을 관리하는 클래스
    - user인스턴스 생성 및 초기화
    - move() : 사용자 위치 변경
    - retry() : 사용자 위치 및 사용자 시도 횟수 관리
    - checkBridge() : 사용자 위치에 대한 다리의 값 비교

- #### BridgeMaker class
    - 다리의 길이를 입력 받아서 다리를 생성해주는 클래스
    - BridgeMaker 생성자 : BridgeNumberGenerator 초기화
    - makeBridge() : 다리 생성

- #### BridgeRandomNumberGenerator class
    - 다리 생성하는 클래스
    - generate()

- #### InputView class
    - 입력 클래스
    - readBridgeSize() : 다리의 길이를 입력
    - readMoving() : 사용자가 이동할 칸을 입력
    - readGameCommand() : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력

- #### OutputView class
    - 출력 클래스
    - startGame() : 게임 시작 알림 출력
    - printMap() : 상태에 맞게 다리 출력
    - printResult() : 게임의 최종 결과를 정해진 형식에 맞춰 출력

- #### Error class
    - 에러 클래스 : 모든 출력을 "[ERROR]" 로 시작
    - checkRangeInputBridgeLenght() : 다리 길이 입력에 대한 에러 체크
    - checkTextMove() : 사용자가 이동할 칸에 대한 입력 문자 확인
    - checkTextEndOrRetry() : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력에 대한 문자 확인


# 주요 요구 사항

- #### indent(인덴트, 들여쓰기) depth 3이 넘지 않도록 구현

- #### else 예약어를 쓰지 않는다.
    - if 조건절에서 값을 retrun 하는 방식으로 구현

- #### 함수, 메서드의 길이가 10라인을 넘지 않도록 구현

- #### 메서드의 파라미터 개수는 3개까지 허용

- #### camp.nextstep.edu.missionutils패키지의 Console.readLine() 이용
    - 사용자 입력을 위해



