package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAO {
	
	// 마이바티스 멤버변수 정의 => 객체생성 자동으로 전달(주입) 받음
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.itwillbs.mappers.memberMapper";

	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO insertMember()");
//		전체파일이름.sql구문이름
		sqlSession.insert(namespace+".insertMember", memberDTO);
		
	}//insertMember()
	
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAO userCheck()");
		
		// .selectOne() 리턴결과 1개 ,  .selectList() List형으로 리턴,
		// .selectMap() Map형으로 리턴
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
		
	}//userCheck()
	
	public MemberDTO getMember(String id) {
		System.out.println("MemberDAO getMember()");
		
		return sqlSession.selectOne(namespace+".getMember", id);
	}//getMember()

	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO updateMember()");
		
		sqlSession.update(namespace+".updateMember", memberDTO);
	}//updateMember()

	public void deleteMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO deleteMember()");
		
		sqlSession.delete(namespace+".deleteMember", memberDTO);
	}//deleteMember()

	public List<MemberDTO> getMemberList() {
		System.out.println("MemberDAO getMemberList()");
		
		return sqlSession.selectList(namespace + ".getMemberList");
	}
	
}//MemberDAO 클래스
