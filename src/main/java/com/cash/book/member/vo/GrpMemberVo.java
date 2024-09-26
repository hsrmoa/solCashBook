package com.cash.book.member.vo;

import com.cash.book.common.vo.CommonVo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * Description : 마스터회원(=그룹회원) 정보 VO
 * Date : 2024. 9. 26.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 26., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Getter
@Setter
@RequiredArgsConstructor
public class GrpMemberVo extends CommonVo {

	private int grpMemberSeq;		// 그룹회원SEQ
	private String grpMemberNm;		// 그룹회원ID
	private String useYn;			// 사용여부
	
}
