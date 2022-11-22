
InputView
    int readBridgeSize()
        Console에서 line을 입력받아 integer로 변환 후 리턴
        숫자 변환 실패하는 경우 Exception 
    String readMoving()
        Console에서 line을 입력받아 문자열 하나 입력받아 리턴
        U와 D 중 아무것도 아닌 경우 Exception
    String readGameCommand()
        Console에서 line을 입력받아 문자열 하나 입력받아 리턴
        R과 Q 중 아무것도 아닌 경우 Exception
OutputView
    field
        int cur; 현재 출력 대상 위치한 곳
        List<String> bridge; 출력 대상 다리 
    method    
        생성자(int cur, List<String> bridge) 
            입력해서 저장
        void printMap(String letter, int last)
            개별 한 줄 출력 "U" 또는 "D"에 대해
        void printMaps(int last)
            [ O ]
            [   ]
            이런식으로 출력해야됨
        last가 1일 경우 마지막 X
        String selectLetter(String letter,int i,int last)
            printMap 할 때 안에 O인지 X인지 공란인지 선택하는 함수
        void printResult(int last,int cnt)
            최종 게임 결과
            [ O |   |   ]
            [   | O | O ]
            
            게임 성공 여부: 성공
            총 시도한 횟수: 2
            이런 식으로 출력
BridgeGame
    field
        List<String> curbridge : 현재 게임이 진행되고 있는 다리 정보  
        int curidx : 현재 유저가 위치하고 있는 인덱스
        ArrayList<String> curmov : 현재 움직임들 기록
    method
        생성자
            다리를 만들고(BridgeMaker) 사용 // curidx를 0으로 초기화한다.
        int move()
            InputView.readMoving()을 호출해서 무빙을 받은 다음에 curidx+1값을 비교한다.
            그리고 isFinish(curidx+1,pos)를 호출해서 curidx+1가 pos가 맞는지 확인한다.
            맞으면 1 리턴 안되면 0 리턴
        void retry()
            curidx를 0으로 초기화한다.
        int isFinish(int idx,String pos)
            curbridge[curidx+1]값을 본다. U이고 1,D이고 0이면 return true, 아니면 return false
BridgeMaker
    List<String> makeBridge(int size)
        size만큼 bridgeNumberGenerator.generate();를 수행해서 리스트에 추가한다.
        조건 : 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.