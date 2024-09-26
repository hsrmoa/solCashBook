package com.cash.book.common.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * Description : 서버 반환결과 정보 VO
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
public class ResultVo {
	
	private int resultCode;
	private Object data;
	private String errType;
	private String errMsg;

}
