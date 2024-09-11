package com.cash.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * Description : 서버 접속시 Vuejs 프로젝트와 연동을 위한 Controller
 * Date : 2024. 9. 11.
 * History :
 * - 작성자 : sora, 날짜 : 2024. 9. 11., 설명 : 최초작성
 *
 * @author sora
 * @version 1.0
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
}
