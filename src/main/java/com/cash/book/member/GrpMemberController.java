package com.cash.book.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cash.book.common.vo.ResultVo;
import com.cash.book.member.service.GrpMemberService;
import com.cash.book.member.vo.GrpMemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Description : 마스터(=그룹)회원정보 Controller
 * Date : 2024. 9. 26.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 26., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value="/member")
@RequiredArgsConstructor
public class GrpMemberController {

	
	@Autowired
	private GrpMemberService grpMemberService;
	
	
	/**
	 * 
	 * 그룹회원정보 등록하기 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 26.
	 * @params  파라미터타입 파라미터설명
	 * @return  ResultVo
	 */
	@PostMapping(value="/grpJoin")
	public ResultVo grpMemberJoin(@RequestBody GrpMemberVo grpMemberVo) throws Exception
	{
		ResultVo resultVo = new ResultVo();
		
		try {
			// 1. 그룹명 중복여부 체크
			Boolean grpNmExistChk = grpMemberService.grpMemberNmCheck(grpMemberVo.getGrpMemberNm());
			// 그룹명이 존재할 때
			if(!grpNmExistChk)
			{
				resultVo.setResultCode(999);
				resultVo.setErrType("GRPNM");
			} else {
				// 2. 마스터회원(그룹회원) 등록하기
				// 2-1. 생성,수정ID 추가
				grpMemberVo.setCreateId("SYSTEM");
				grpMemberVo.setUpdateId("SYSTEM");
				
				// 2-2 마스터회원(그룹회원) 등록 서비스
				int grpMemberSeq = grpMemberService.grpMemberReg(grpMemberVo);
				resultVo.setResultCode(200);
				resultVo.setData(grpMemberSeq);
			}
		} catch (Exception e) {
			resultVo.setErrMsg(e.getMessage());
			resultVo.setResultCode(999);
		}		
		
		return resultVo;
	}
	
	
}
