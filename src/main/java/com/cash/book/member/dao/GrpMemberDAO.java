package com.cash.book.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cash.book.member.vo.GrpMemberVo;

/**
 * 
 * Description : 마스터회원(그룹회원) DAO 인터페이스
 * Date : 2024. 9. 26.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 26., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Mapper
public interface GrpMemberDAO {

	
	/**
	 * 
	 * 마스터회원명(그룹회원명) 존재여부 체크하기 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 26.
	 * @params  파라미터타입 파라미터설명
	 * @return  int
	 */
	public int grpMemberNmCheck(@Param("grpMember")GrpMemberVo grpMemberVo);
	
	/**
	 * 
	 * 마스터회원(그룹회원) 회원등록하기 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 26.
	 * @params  파라미터타입 파라미터설명
	 * @return  int
	 */
	public int grpMemberReg(@Param("grpMember")GrpMemberVo grpMemberVo);
}
