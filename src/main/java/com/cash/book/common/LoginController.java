package com.cash.book.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cash.book.common.service.LoginService;
import com.cash.book.common.vo.LoginVo;
import com.cash.book.common.vo.ResultVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Description : 로그인을 위한 Controller
 * Date : 2024. 9. 24.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 24., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
	
	// 로그인 서비스
	@Autowired
	private LoginService loginSerice;
	
	/**
	 * 
	 * 로그인 시도 전 체크하기 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 23.
	 * @params  LoginVo 
	 * @return  ResultVo
	 */
	@PostMapping(value="/loginCheck")
	public ResultVo loginCheck(@RequestBody LoginVo loginVo) throws Exception {
		ResultVo resultVo = new ResultVo();
		try {
			
			// 1. 로그인 ID 정보 조회하기
			Boolean idExist = loginSerice.loginIdCheck(loginVo.getUserId());
			// ID가 존재함
			if(idExist)
			{
				// 2. 비밀번호 정보 조회
				Boolean pwdCheck = loginSerice.loginPwdCheck(loginVo);
				
				// 비밀번호가 일치
				if(pwdCheck) {
					// 로그인성공
					resultVo.setResultCode(200);
				} 
				else 
				{
					// 비밀번호가 불일치
					resultVo.setResultCode(999);
					resultVo.setErrType("PWD");
				}
			} 
			else 
			{
				// ID가 존재하지 않음
				resultVo.setResultCode(999);
				resultVo.setErrType("ID");
			}			
			
		} catch (Exception e) {
			// 에러발생시
			resultVo.setResultCode(999);
			resultVo.setErrType("ETC");
			resultVo.setErrMsg(e.getMessage());
		}
		
		return resultVo;
	}
}
