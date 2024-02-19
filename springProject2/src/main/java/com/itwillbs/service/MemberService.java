package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberService {
	
	// MemberDAO 객체생성 => 멤버변수
	// @Inject => MemberDAO 클래스 찾기 => @Repository 자동으로 찾기 => 자동으로 객체생성
	// 경로 설정<context:component-scan base-package="com.itwillbs.dao" />
	@Inject
	private MemberDAO memberDAO;
	
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberService insertMember()");
		// 가입날짜 설정
		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		// insertMember 메서드 호출
		memberDAO.insertMember(memberDTO);
		
	}//insertMember()
	
//	MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberService userCheck()");
		
		// userCheck 메서드 호출
		return memberDAO.userCheck(memberDTO);
		
	}//userCheck()
	
//	MemberDTO memberDTO = memberService.getMember(id);
	public MemberDTO getMember(String id) {
		System.out.println("MemberService getMember()");
		
		return memberDAO.getMember(id);
	}//getMember()

	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberService updateMember()");
		
		memberDAO.updateMember(memberDTO);
	}//updateMember()

	public void deleteMember(MemberDTO memberDTO) {
		System.out.println("MemberService deleteMember()");
		
		memberDAO.deleteMember(memberDTO);
	}//deleteMember()

	public List<MemberDTO> getMemberList() {
		System.out.println("MemberService getMemberList()");
		
		return memberDAO.getMemberList();
	}//getMemberList()
	

}//MemberService 클래스
