package main.person.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import main.person.Person;

@Getter
@Setter
@RequiredArgsConstructor
public class Player implements Person {

	@NonNull
	private String name;
	
	private int randomNumber;
	
	private ArrayList<Integer> myBlocks = new ArrayList<Integer>();

	@Override
	public boolean enterance() {
		// player가 규칙을 이해했는지 확인
		System.out.printf("규칙을 이해하셨으면 y, 다시 한 번 설명을 원하신다면 n를 입력해주세요 >> ");
		Scanner sc = new Scanner(System.in);
		String understandRule = sc.next();
		
		// 규칙 이해 O
		if(understandRule.toLowerCase().equals("y")) {
			return true;
		}
		return false; // 규칙 이해 X
	}

	
	/*
	 * 게임 턴 돌기 전, player가 blackhole에서 4개의 블록을 랜덤으로 뽑는다.
	 */
	public void pickFirst(ArrayList<Integer> blackhole) {
		for(int i = 0; i < 4; i++) { // ?? 여기서 4 대신 BlockGenerator의 firstPickRange 변수 가져와서 쓸건지
			// blackhole에서 랜덤으로 4개의 블록 선택
			int randomNumber = (int)(Math.random() * 12);
			
			int[] count = new int[12];
			count[randomNumber]++;
			
			// 같은 randomNumber가 3회 이상 뽑히지 않도록 중복 제거
			for(int j = 0;j < i;j++) {
				if(myBlocks.get(j) == randomNumber) {
					if(count[randomNumber] > 2) {
						i--;
						break;
					}
					
				}
			}
			
			// 선택된 4개의 블록을 myBlocks에 저장
			myBlocks.add(randomNumber);
		}
	}

	/*
	 * blackhole 중 하나의 블록 선택
	 */
	public void pickOne(ArrayList<Integer> blackhole) {
		// blackhole에서 랜덤으로 1개의 블록 선택
		randomNumber = (int)(Math.random() * 12);
		
		// 선택된 1개의 블록을 myBlocks에 저장
		myBlocks.add(randomNumber);
	}

	public ArrayList<Integer> sortMyBlocks() {
		// 해당 Player가 가지고 있는 blocks를 오름차순으로 정렬
		Collections.sort(myBlocks);
		return myBlocks;

	}
}
