package com.cash.book.common.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * Description : 공통으로 사용되는 정보 VO
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
public class CommonVo {

	private String createId;		// 생성자
	private Date createDate;		// 생성일자
	private String updateId;		// 수정자
	private Date updateDate;		// 수정일자
}
