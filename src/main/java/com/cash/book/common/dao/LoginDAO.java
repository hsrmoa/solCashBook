package com.cash.book.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cash.book.common.vo.LoginVo;

/**
 * 
 * Description : 로그인을 위한 DAO 인터페이스
 * Date : 2024. 9. 24.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 24., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Mapper
public interface LoginDAO {

	
	/**
	 * 
	 * 로그인 여부 체크하기 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 24.
	 * @params  파라미터타입 파라미터설명
	 * @return  int
	 */
	public int loginCheck(@Param("login")LoginVo loginVo);
}
