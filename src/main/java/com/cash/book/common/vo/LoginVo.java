package com.cash.book.common.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * Description : 로그인시 사용되는 정보 VO
 * Date : 2024. 9. 23.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 23., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Getter
@Setter
@RequiredArgsConstructor
public class LoginVo extends CommonVo {

	private String userId;
	private String userPwd;
}
