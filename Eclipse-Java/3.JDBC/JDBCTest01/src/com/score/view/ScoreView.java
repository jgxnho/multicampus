package com.score.view;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.score.dto.Score;
import com.score.service.ScoreService;
import com.score.service.ScoreServiceImpl;

public class ScoreView {
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select = 0;
		
		System.out.println("================");
		System.out.println("1.전체출력");
		System.out.println("2.선택출력");
		System.out.println("3.추가");
		System.out.println("4.수정");
		System.out.println("5.삭제");
		System.out.println("6.종료");
		System.out.println("메뉴 선택: ");
		select = sc.nextInt();
		return select;
	}
	
	
	public static void main(String[] args) {
		ScoreService service = new ScoreServiceImpl();
		int select = 0;
		
		String name = null;
		int kor = 0;
		int eng = 0;
		int math = 0;
		
		int res = 0;
		
		while(select != 6) {
			select = getMenu();
			
			switch(select) {
			case 1:
				//전체 출력
				List<Score> my = service.getAll();
				for(Score r : my) {
					System.out.println(r);
				}
				break;
			case 2:
				//선택출력
				System.out.println("선택할 이름: ");
				name = sc.next();
				
				Score selOne = service.getOne(name);
				if(selOne != null)  {
					System.out.println(selOne);
				}else {
					System.out.println("일치하는 학생이 없습니다.");
				}
				break;
			case 3:
				//추가
				System.out.println("추가할 이름: ");
				name = sc.next();
				
				Score sn = service.getOne(name);
				
				if(sn != null) {
					System.out.println("입력한 이름이 존재합니다.");
				}else {
					System.out.println("국어 점수: ");
					kor = sc.nextInt();
					System.out.println("영어 점수: ");
					eng = sc.nextInt();
					System.out.println("수학 점수: ");
					math = sc.nextInt();
					
					Score in = new Score(name, kor, eng, math);
					
					res = service.insert(in);
					if(res>0) {
						System.out.println("추가 성공");
					}else {
						System.out.println("추가 실패");
					}
				}
				break;
				
			case 4:
				//수정
				System.out.println("수정할 이름: ");
				name = sc.next();
				System.out.println("바꿀 국어 점수: ");
				kor=sc.nextInt();
				System.out.println("바꿀 영어 점수: ");
				eng=sc.nextInt();
				System.out.println("바꿀 수학 점수: ");
				math=sc.nextInt();
				
				Score up = new Score(name,kor,eng,math);
				res = service.update(up);
				if(res>0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
				break;
			case 5:
				//삭제
				System.out.print("삭제할 이름: ");
				name = sc.next();
				res = service.delete(name);
				if(res>0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			case 6:
				//종료
				System.out.println("종료되었습니다.");
				break;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
