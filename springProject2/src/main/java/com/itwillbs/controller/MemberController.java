package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	// MemberService 객체생성 => 멤버변수
	// @Inject => MemberService 클래스 찾기 => @Service 자동으로 찾기 => 자동으로 객체생성
	// 경로 설정<context:component-scan base-package="com.itwillbs.service" />
	@Inject
	private MemberService memberService;

//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@GetMapping("/insert")
	public String insert() {
		// WEB-INF/views/member/insert.jsp 주소변경 없이 이동
		return "member/insert";
	}//insert()
	
//	@RequestMapping(value = "/insertPro", method = RequestMethod.POST)
	@PostMapping("/insertPro")
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		System.out.println(memberDTO);
		// 회원가입 처리
		// 패키지 com.itwillbs.service 파일 MemberService
		// 패키지 com.itwillbs.dao 파일 MemberDAO
		
		// insertMember() 메서드 호출
		memberService.insertMember(memberDTO);
		
		// 로그인 가상주소 /member/login 주소변경 이동
		return "redirect:/member/login";
	}//insertPro()
	
	//   /member/login   =>  member/login.jsp 이동
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String login() {
		// WEB-INF/views/member/login.jsp 주소변경 없이 이동
		return "member/login";
	}//login()
	
	@PostMapping("/loginPro")
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		// HttpSession session => session 객체 자동으로 전달 받음
		System.out.println("MemberController loginPro()");
		System.out.println(memberDTO);//폼에서 입력한 id,pass
		//로그인 처리
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		
		System.out.println(memberDTO2);
		
		if(memberDTO2 != null) {
			// 아이디,비밀번호 일치하면 memberDTO2 주소 리턴 => 메인 이동
			// 로그인표시를 => 세션내장객체 저장 => 페이지 상관없이 연결만 되어있으면 값유지
			// 세션값 생성
//			HttpSession session = Request.getSession();
			session.setAttribute("id", memberDTO2.getId());
			// 메인 가상주소 /member/main 주소변경 이동
			return "redirect:/member/main";
		}else {
			// 아이디,비밀번호 틀리면  null 리턴 => 로그인 이동
			
			// 로그인 가상주소 /member/login 주소변경 이동
			return "redirect:/member/login";
		}
		
		
	}//loginPro()
	
	
	// 가상주소 /member/main => member/main.jsp 이동
	@GetMapping("/main")
	public String main() {
		// WEB-INF/views/member/main.jsp 주소변경 없이 이동
		return "member/main";
	}//main()
	
	
	// 가상주소 /member/logout => 세션초기화 => 가상주소 /member/main 주소변경되면서 이동
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션 초기화(전체 세션 기억장소 삭제)
		session.invalidate();
		
		return "redirect:/member/main";
	}//main()
	
	// 가상주소 /member/info =>  id = 세션값 가져오기 
	// => MemberService   MemberDTO  memberDTO =  getMember(id) 메서드 호출
	// => model.addAttribute("memberDTO",memberDTO) 데이터 담아서
	// => member/info.jsp 주소변경없이 이동
	@GetMapping("/info")
	public String info(HttpSession session, Model model) {
		System.out.println("MemberController info()");
		String id = (String)session.getAttribute("id");
		
		MemberDTO memberDTO = memberService.getMember(id);
		
//		request.setAttribute("memberDTO",memberDTO);
		model.addAttribute("memberDTO", memberDTO);
		
		// WEB-INF/views/member/info.jsp 주소변경 없이 이동
		return "member/info";
	}//info()
	
	// 가상주소 /member/update =>  id = 세션값 가져오기 
		// => MemberService   MemberDTO  memberDTO =  getMember(id) 메서드 호출
		// => model.addAttribute("memberDTO",memberDTO) 데이터 담아서
		// => member/update.jsp 주소변경없이 이동
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		System.out.println("MemberController update()");
		String id = (String)session.getAttribute("id");
		
		MemberDTO memberDTO = memberService.getMember(id);
		
//		request.setAttribute("memberDTO",memberDTO);
		model.addAttribute("memberDTO", memberDTO);
		
		// WEB-INF/views/member/update.jsp 주소변경 없이 이동
		return "member/update";
	}//update()
	
	
	// post방식 가상주소 /member/updatePro => MemberDTO 받기 
	// memberDTO2 = userCheck(memberDTO) 호출 
	// memberDTO2 != null  => 일치  => 수정 updateMember(memberDTO) 메서드 호출
	//                             => 가상주소 /member/main 주소변경하면서 이동        
	//            == null  => 틀리면 => 가상주소 /member/update 주소변경하면서 이동 
	@PostMapping("/updatePro")
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro()");
		System.out.println(memberDTO);//폼에서 입력한 id,pass,name
		//아이디 비밀번호 비교 처리
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		
		System.out.println(memberDTO2);
		
		if(memberDTO2 != null) {
			// 아이디,비밀번호 일치하면 memberDTO2 주소 리턴 => 메인 이동
			// 수정작업
			memberService.updateMember(memberDTO);
			// 메인 가상주소 /member/main 주소변경 이동
			return "redirect:/member/main";
		}else {
			// 아이디,비밀번호 틀리면  null 리턴 => update 이동
			
			//  가상주소 /member/update 주소변경 이동
			return "redirect:/member/update";
		}
	}//updatePro()
	
	// 가상주소 /member/delete => => member/delete.jsp 주소변경없이 이동
	@GetMapping("/delete")
	public String delete() {
		System.out.println("MemberController delete()");
		
		// WEB-INF/views/member/delete.jsp 주소변경 없이 이동
		return "member/delete";
	}//delete()
	
	
	// post방식 가상주소 /member/deletePro => MemberDTO 받기, 세션객체 받기 
	// memberDTO2 = userCheck(memberDTO) 호출 
	// memberDTO2 != null  => 일치  => 삭제 deleteMember(memberDTO) 메서드 호출
	//                             => 세션 초기화
	//                             => 가상주소 /member/main 주소변경하면서 이동        
	//            == null  => 틀리면 => 가상주소 /member/delete 주소변경하면서 이동 
	
	@PostMapping("/deletePro")
	public String deletePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController deletePro()");
		System.out.println(memberDTO);//폼에서 입력한 id,pass
		//아이디 비밀번호 비교 처리
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		
		System.out.println(memberDTO2);
		
		if(memberDTO2 != null) {
			// 아이디,비밀번호 일치하면 memberDTO2 주소 리턴 => 메인 이동
			// 삭제작업
			memberService.deleteMember(memberDTO);
			// 세션 초기화
			session.invalidate();
			// 메인 가상주소 /member/main 주소변경 이동
			return "redirect:/member/main";
		}else {
			// 아이디,비밀번호 틀리면  null 리턴 => delete 이동
			
			//  가상주소 /member/delete 주소변경 이동
			return "redirect:/member/delete";
		}
	}//deletePro()
	
	// get방식 가상주소 /member/list  
	// 회원정보 모두가져오기 
	// List<MemberDTO> 리턴할형 memberList  = getMemberList() 메서드 호출
	// model에 "memberList", memberList 를 담아서 이동
	// => member/list.jsp 주소변경없이 이동  
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("MemberController list()");
		List<MemberDTO> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		return "member/list";
	}//list()
	
	
	
	
	
	
}//MemberController클래스
