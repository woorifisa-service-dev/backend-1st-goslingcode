package main.person.moderator;

public class CalmModerator extends Moderator {

	@Override
	public boolean enterance() {
		// 환영 인사 및 규칙 설명
		System.out.println(" “고슬링 코드”에 오신걸 환영합니다.\r\n" +
				"\n"+
				"저희 게임은 흰색 12개와 검은색 12개의 블록이 준비되어 있습니다.\r\n" + 
				"\n"+
				"게임이 시작되면 각자 4개의 블록을 뽑아주세요.\r\n" + 
				"(뽑은 블록들은 자동으로 정렬됩니다.)\r\n" + 
				"\n"+
				"우선 자신의 차례가 되면 블록을 한 개 뽑아주세요!\r\n" + 
				"그 후, 상대방의 몇 번째 블록이 어떤 숫자일지 추측해주세요.\r\n" + 
				"만약 정답을 맞출 경우 게임은 계속됩니다. 당연히 원하는 경우 멈출 수도 있습니다.\r\n" + 
				"하지만 틀릴 경우, 현재 턴 시작할 때 뽑은 자신의 블록을 공개해야 합니다.\r\n" + 
				"블록이 모두 공개가 되면 경기가 끝나게 됩니다.\r\n" + 
				"\n"+
				"그럼 “고슬링 코드”에서 즐거운 시간 보내시길 바라겠습니다.\r\n");
		return true;
		
	}

	@Override
	public void guideFirstTurn() {
		// 게임시작 멘트 및 초기 블럭 선택하라는 설명
		System.out.println("우선 게임에 필요한 블록을 각자 4개씩 뽑아주시기 바랍니다.\r\n");
	}

	@Override
	public void guidePick(String playerName) {
		// 턴 플레이어 블럭 추가 뽑기 안내
		System.out.println(playerName+"님의 턴입니다. 추가로 블록 하나를 뽑아주세요.\r\n");
	}

	@Override
	public void guideGuess(String playerName) {
		// 상대 플레이어의 블럭을 추측 안내
		System.out.println(playerName+"님의 블록 하나를 추측해 주세요.\r\n");
	}

	@Override
	public void guideCorrect(String playerName) {
		// 추측이 맞을 경우, 상대방 블럭 공개 안내 
		System.out.println("정답입니다. "+playerName+"님은 해당 블록을 제거해주세요.\r\n");
	}

	@Override
	public void guideKeepGoing() {
		// 계속 게임 할지 질문
		System.out.println("정답을 맞추셨으니 게임을 계속 진행할 수 있습니다. 상대의 블록을 한 번 더 맞추시겠습니까?\r\n");
	}

	@Override
	public void guideWrong(String playerName) {
		// 추측이 틀릴 경우, 본인 블럭 공개 안내
		System.out.println("틀렸습니다. "+playerName+"님이 가져오신 블록을 공개하겠습니다.\r\n");
	}

	@Override
	public void guideEnd(String playerName) {
		// 게임 종료 멘트
		System.out.println("게임이 종료되었습니다. 승자는 "+playerName+"님 입니다. 축하드립니다.\r\n");
	}


}