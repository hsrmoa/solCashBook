package com.cash.book.common.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginUserVo extends CommonVo {
	
	private int memberSeq;
	private int grpMemberSeq;
	private String memberId;	
	private String memberNm;
	private String memberPwd;	
	private String grpMasterYn;
	private String memberStatus;
	private String authId;
}
