package com.lec.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.lec.dto.friend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/friendTest")
public class friendRepositoryTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		friendRepository repository = friendRepository.getInstance();
		ArrayList<friend> friendList = repository.getfriendList();
		for(friend friend: friendList) {
			System.out.println(friend);
		}
		int result = repository.insertFriend("박길순", "010-7777-7777");
		System.out.println(result==friendRepository.SUCCESS? "추가성공" : "추가실패");
	}
}
