package main.person.moderator;

import java.util.ArrayList;

import main.person.Person;

public abstract class Moderator implements Person {

	private String personality;
		
	public abstract boolean enterance();
	
	public abstract void guideFirstTurn();
	
	public abstract void guidePick(String playerName);
	
	public abstract void guideGuess(String playerName);
	
	public abstract void guideCorrect(String playerName);
	
	public abstract void guideKeepGoing();
	
	public abstract void guideWrong(String playerName);
	
	public abstract void guideEnd(String playerName);
	
	public boolean judge(ArrayList<Integer> blocks, int index, int num) {
		// 플레이어가 추측한 상대방의 블록이 맞는지 판단하는 메서드
		System.out.println("##### 실제값 : " + (int)blocks.get(index));
		if((int)blocks.get(index) == num) {
			return true;
		}
		return false;
	}
}