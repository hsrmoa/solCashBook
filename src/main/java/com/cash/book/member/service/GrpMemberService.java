package com.cash.book.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cash.book.member.dao.GrpMemberDAO;
import com.cash.book.member.vo.GrpMemberVo;

/**
 * 
 * Description : 마스터회원(=그룹회원) 정보 service 클래스
 * Date : 2024. 9. 26.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 26., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Service
public class GrpMemberService {

	
	@Autowired
	private GrpMemberDAO grpMemberDao;
	
	/**
	 * 
	 * 그룹명 중복체크하기 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 26.
	 * @params  파라미터타입 파라미터설명
	 * @return  Boolean
	 */
	public Boolean grpMemberNmCheck(String grpMemberNm) throws Exception {
		// 그룹명 중복여부체크
		Boolean grpNmExistChk = true;
		try {
			// 마스터회원 VO
			GrpMemberVo grpMemberVo = new GrpMemberVo();
			grpMemberVo.setGrpMemberNm(grpMemberNm);
			// 그룹명 존재여부 체크
			int grpNmExistCnt = grpMemberDao.grpMemberNmCheck(grpMemberVo);
			// 그룹명 존재개수 
			if(grpNmExistCnt > 0)
			{
				grpNmExistChk = false;
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return grpNmExistChk;
	}
	
	/**
	 * 
	 * 그룹회원 등록하기 
	 * 작성자: sora
	 * 작성일자 : 2024. 9. 26.
	 * @params  파라미터타입 파라미터설명
	 * @return  int
	 */
	@Transactional
	public int grpMemberReg(GrpMemberVo grpMemberVo) throws Exception
	{
		int grpMemberSeq = 0;		
		try {
			// 그룹회원 등록하기
			grpMemberSeq = grpMemberDao.grpMemberReg(grpMemberVo);
			
		} catch (Exception e) {
			grpMemberSeq = -1;
			throw new Exception(e.getMessage());
		}
		
		return grpMemberSeq;
	}
}
