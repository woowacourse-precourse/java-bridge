#InputRegex

input regex를 모은 enum 

#InputView

### readBridgeSize

    다리의 길이를 입력받음

### validateBridgeSize

    입력 받은 다리의 길이가 올바른지 검증

### readMoving

    사용자가 움직일 방향을 입력받음

### validateMoving

    입력 받은 방향이 U,D 인지 검증

### readGameCommand

    사용자의 게임 재진행 여부 를 입력 받음

### validateGameCommand

    입력한 게임 진행 여부가 R,Q 인지 검증

# BridgeMaker

### makeBridge

    U,D로 구성된 bridge(ArrayList) 생성

# BrdigeGameInfo

게임의 현재 정보를 저장하는 class

# BridgeGame

### move

    player 를 한칸 앞으로 이동시의 시킴

### retry

    player 의 위치를 초기화 시키고 총시도 횟수를 1회 증가 시킴

### status

    player 의 현재 상태를 확인함

# Player 

player 의 status 분류를 위한 enum

# OutputView

### printMap

    현재까지 건넌 다리 상태를 출력

### printResult

    게임 결과 출력

# GameRunner

### run

    게임 실행