# 4주차 미션 - [다리 건너기](https://www.notion.so/ca474d281e414157881a7047f8ebe24a?v=11d6ac51a94948b392677cbf12ddd306) : 구현할 기능 목록

1. [x] 게임 시작 메시지 출력
2. [x] 다리의 길이 입력받기
   1. [x] 입력받기 위한 메시지 출력
   2. [x] Console.readLine() 호출을 통해 입력받기
   3. [x] Integer.parseInt() 사용해 int 타입으로 변환해 저장
   4. [x] 3 이상 20 이하의 숫자가 아닌 경우 예외 처리
3. [x] 다리 생성 (매 라운드마다 사용자가 건넌 다리를 출력하기 위함)
   1. [x] Utils 클래스에 makeInitialBridge() 메서드 생성
   2. [x] 메서드 내부에 List<List<String\>> 타입의 리스트인 currentBridge 생성(currentBridge[1] : 위 칸, currentBridge[0] : 아래 칸)
   3. [x] 사용자가 건넌 다리 정보를 저장할 User 클래스 생성
   4. [x] makeIntialBridge()에서 User의 객체 생성, currentBridge를 생성자 파라미터로 넘겨 줌
4. [x] 건널 수 있는 다리 무작위로 설정
   1. [x] Utils.makeAnswerBridge() 생성, 구현
      1. [x] BridgeRandomNumberGenerator의 객체 생성
      2. [x] BridgeMaker 객체 생성, 위에서 생성한 BridgeRandomNumberGenerator의 객체를 생성자 파라미터로 넘겨 줌
      3. [x] BridgeMaker.makeBridge() 구현
         1. [x] BridgeRandomNumberGenerator.generate()를 size만큼 호출해서 0과 1 중 하나의 랜덤 값 size개 반환받기
         2. [x] List<String\> 생성, BridgeRandomNumberGenerator.generate()의 결과를 "U", "D"로 변환해 리스트에 저장
         3. [x] 정답이 될 다리의 모양이 저장된 리스트를 반환


1. [x] 다리를 모두 건너거나 실패할 때까지 게임 진행
   1. [x] 사용자로부터 이동할 칸 입력받기
      1. [x] 입력받기 위한 메시지 출력
      2. [x] Console.readLinie()을 통해 입력받기
      3. [x] 입력받은 값이 U 또는 D가 아닌 경우 예외 처리
   2. [x] 사용자가 입력한 칸이 이동 가능한 칸인지 확인
      1. [x] 현재 이동하려는 다리가 몇 번째(n번째) 다리인지 확인
      2. [x] answerBridge.get(n + 1)이 사용자의 입력과 같은지 확인
      3. [x] 같으면 O, 다르면 X 반환
   3. [x] 이동 가능한 칸이라면 해당 칸에 O, 가능하지 않은 칸이라면 X 저장
      1. [x] User의 객체에 addNewCrossingResult() 메서드 추가
         1. [x] 해당 이동이 첫 번째 다리 이동이 아닌 경우 위 칸과 아래 칸에 모두 구분 문자열인 "|" 추가
         2. [x] 사용자가 선택한 칸의 경우 currentBridge 사이에 " ", "(O 또는 X)", " "  추가
         3. [x] 사용자가 선택하지 않은 칸의 경우 currentBridge 사이에 " ", " ", " " 추가
   4. [x] 현재까지 건넌 다리 모두 출력


2. [x] 실패한 경우( == 사용자가 입력한 칸이 이동 가능한 칸이 아닌 경우)
   1. [x] 게임 재시도 여부를 입력받기 위한 메시지 출력
   2. [x] 게임 재시도 여부 입력받기
      1. [x] **R이 입력된 경우 : 처음부터 다시 시작, 게임 시도 횟수 1 증가
      2. [x] **Q가 입력된 경우 : 결과 출력 메서드 호출
      3. [x] 이외의 값이 입력된 경우 : 예외 처리
3. [x] 다리를 모두 건넌 경우 결과 출력 메서드 호출


4. [x] 결과 출력
   1. [x] 성공 여부 출력
   2. [x] 총 시도 횟수 출력