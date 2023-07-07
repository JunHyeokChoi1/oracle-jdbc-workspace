package com.youtube;

import java.util.Scanner;

import com.youtube.controller.YouTubeController;
import com.youtube.model.vo.Member;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	private YouTubeController yc = new YouTubeController();
	
	
	public static void main(String[] args) {

		Application app = new Application();
		app.register();
		
	}

	public void register() {
		//회원가입
		System.out.println("아이디 입력: ");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력: ");
		String password = sc.nextLine();
		System.out.println("닉네임 입력: ");
		String nickname = sc.nextLine();
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPassword(password);
		member.setMemberNickname(nickname);
		
		if(yc.register(member)) {
			System.out.println("회원가입에 성공하셨습니다~");
		} else {
			System.out.println("회원가입에 실패하였습니다 ㅠㅠ");
		}
		
	}
	
	
	
}
