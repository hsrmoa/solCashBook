package com.cash.book.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cash.book.common.dao.LoginDAO;
import com.cash.book.common.vo.LoginVo;

/**
 * 
 * Description : 로그인을 위한 서비스
 * Date : 2024. 9. 24.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 24., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Service
public class LoginService {

	// 로그인 DAO 인터페이스
	@Autowired
	private LoginDAO loginDao;
	
	/**
	 * 
	 * 로그인 ID  존재여부 체크 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 24.
	 * @params  String
	 * @return  Boolean
	 */
	public Boolean loginIdCheck(String userId) throws Exception {
		// 아이디 결과
		Boolean idChkResult = true;
		
		try {
			// 아이디체크 파라미터 설정
			LoginVo idCheckParam = new LoginVo();
			idCheckParam.setUserId(userId);
			
			// 아이디 정보 조회
			int idExistCnt = loginDao.loginCheck(idCheckParam);
			
			// 조회한 갯수가 1보다 작을때 (=아이디가 존재하지 않다는것)
			if(idExistCnt < 1) {
				idChkResult = false;
			}
			
		} catch (Exception e) {
			// 에러발생
			throw new Exception(e.getMessage());
		}
		
		return idChkResult;
	}
	
	/**
	 * 
	 * 로그인 비밀번호 존재여부 체크 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 24.
	 * @params  LoginVo
	 * @return  Boolean
	 */
	public Boolean loginPwdCheck(LoginVo loginVo) throws Exception {
		// 비밀번호 결과
		Boolean pwdChkResult = true;
		
		try {
			// 비밀번호 정보 조회
			int pwdExistCnt = loginDao.loginCheck(loginVo);
			
			// 조회한 갯수가 1보다 작을때 (=비밀번호가 틀림)
			if(pwdExistCnt < 1) {
				pwdChkResult = false;
			}
			
		} catch (Exception e) {
			// 에러발생
			throw new Exception(e.getMessage());
		}
		
		return pwdChkResult;
	}
}
