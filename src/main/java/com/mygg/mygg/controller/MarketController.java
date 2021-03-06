package com.mygg.mygg.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;
import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MarketService;
import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MarketVO;

@Controller
@RequestMapping("/market/")
public class MarketController {

	private static final Logger logger = LoggerFactory.getLogger(MarketController.class);
	// Service와 연결
	// URL market/...
	@Resource(name="marketService")
	private MarketService marketService;
	private MemberService memberService;
	
	 @Autowired
	    public MarketController(MemberService memberService) {
	        this.memberService = memberService;
	    }

	 
	 
	/**
	 * 기능 - 서비스 목록들
	 글 등록을 하고 저장까지 완료가 되면 바로 이 화면으로 넘어온다.
	 * URL이름 - marketListPage
	 * 화면이름 - marketList.html
	 * Method - public String marketListPage(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session)
	 * Parameter(매개변수 ID/PW , 없으면 N/A)
	 - MarketVO marketVO, Model model
	 * return type(void, String, ServiceVO)
	 -
	 * 쿼리(DB 작업 insert, select, update, delete)
	 - SELECT 컬럼들 FROM MARKET;
	 */
	@RequestMapping("marketListPage")
	public String marketListPage(Model model, HttpServletRequest request, MarketVO marketVO) throws Exception {

		List<MarketVO> marketList = marketService.marketList();
		
		// List<MarketVO> categoryList = marketService.categoryList();
		
		model.addAttribute("marketList", marketList);
		
		// model.addAttribute("categoryList", categoryList);

		return "service/marketList";
	}

	/**
	 * 기능 - 글을 입력만 하는곳 입력된 값들은 serviceSave에 넘긴다.
	 * URL이름 - serviceRegistPage
	 * 화면이름 - serviceRegist.html
	 * Method - public String serviceRegistPage()
	 * Parameter(매개변수 ID/PW , 없으면 N/A)
	 * 	- N/A
	 * return type(void, String, ServiceVO)
	 * 쿼리(DB 작업 insert, select, update, delete)
	 * @throws Exception 
	 */
	@GetMapping("serviceRegistPage")
	public String serviceRegistPage(HttpServletResponse response, MemberDTO memberDTO, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {

		// 세션이 없는채로 url찍고들어오면 로그인하라고 페이지 이동
        HttpSession session = request.getSession();
        
        // id만 담음
        Object member = session.getAttribute("id");
		
        if(member == null) {
        	return "redirect:/member/login";
		} else {
			return "service/serviceRegist";
		}
	}
	// 써머노트 이미지 저장
//	@PostMapping("serviceImage")
//    public JsonObject uploadSummernoteImageFile(@RequestParam("file")MultipartFile multipartFile){
//
//        JsonObject jsonObject = new JsonObject();
//
//        String fileRoot = "C:\\summernote_image\\"; //저장될 경로
//        String originalFileName = multipartFile.getOriginalFilename();
//        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
//
//        // 랜덤 UUID+ 확장자로 저장될 파일이름
//        String savedFileName = UUID.randomUUID() + extension;
//
//        File targetFile = new File(fileRoot + savedFileName);
//
//        try {
//
//            InputStream fileStream = multipartFile.getInputStream();
//            FileUtils.copyInputStreamToFile(fileStream, targetFile); //파일 저장
//            jsonObject.addProperty("url","/summernoteImage/"+savedFileName);
//            jsonObject.addProperty("responseCode","success");
//
//        }catch (IOException e){
//
//            FileUtils.deleteQuietly(targetFile);	// 실패시 저장된 파일 삭제
//            jsonObject.addProperty("responseCode", "error");
//            e.printStackTrace();
//
//        }
//
//        return jsonObject;
//    }

	/**
	 * 기능 - 실제 입력된 서비스의 내용들을 받아서 디비에 저장하는 곳 I
	 수정을 입력하고 실제 디비에 저장하는 곳 U
	 저장을 하고 리스트에 바로 보내기 때문에 serviceSave로의 화면은 필요없다.
	 * URL이름 - serviceSave
	 * 화면이름 - 값을 저장만 하는곳이라 화면 필요없음.
	 * Method - public MarketVO serviceSave()
	 * Parameter(매개변수 ID/PW , 없으면 N/A)
	 - MarketVO marketVO 변수들 사용
	 * return type(void, String, ServiceVO)
	 - marketService.serviceSave(marketVO);
	 * 쿼리(DB 작업 insert, select, update, delete)
	 - INSERT INTO MARKET (컬럼들) VALUES(값);
	 UPDATE MARKET SET 컬럼들 WHERE SERVICE_NO = #{serviceNo}
	 * @ResponseBody // Ajax 통신을 위한 태그
	 */
	@ResponseBody
	@RequestMapping(value="serviceSave")
	public MarketVO serviceSave(MarketVO marketVO, HttpServletRequest request) throws Exception {

		logger.info("##################################################");
		logger.info("## serviceSave {} :: " + marketVO.toString());
		logger.info("##################################################");
		
		return marketService.serviceSave(marketVO);
	}

	/**
	 * 기능 - 서비스 상세보기 기능
	 마켓 리스트에서 제목을 눌렀을때 상세보기로 넘어와서 해당 글만 쫙 보여준다.
	 입력해서 보내는건 없고 serviceNo를 보내고 받아와서 보여주기만 할뿐.
	 * URL이름 - serviceDetail
	 * 화면이름 - serviceDetail.html
	 * Method - public String serviceDetail
	 * Parameter(매개변수 ID/PW , 없으면 N/A)
	 - @ModelAttribute("serviceNo") MarketVO marketVO, Model model
	 * return type(void, String, ServiceVO)
	 -
	 * 쿼리(DB 작업 insert, select, update, delete)
	 - SELECT 컬럼명들 다 FORM MARKET WHERE SERVICE_NO = #{serviceNo}
	 - serviceNo로 찾아와서 상세보기 해야함.
	 */
	@RequestMapping("serviceDetail")
	public String serviceDetail(@ModelAttribute("marketVO") MarketVO marketVO, Model model, HttpServletResponse response, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {

		logger.info("##################################################");
		logger.info("## serviceDetail {} :: " + marketVO.toString());
		logger.info("##################################################");
		
		HttpSession session = request.getSession();

		Object member = session.getAttribute("id");

		if (member == null) {

			return "redirect:/member/login";
			
		} else {
			MarketVO serviceInfo = marketService.serviceDetail(marketVO);

			model.addAttribute("serviceInfo", serviceInfo);

			return "service/serviceDetail";
		}
	}
	/**
	 * 기능 - 서비스 수정하는 폼 입력 기능
	 * URL이름 - serviceUpdate
	 * 화면이름 - service/serviceUpdate.html
	 * Method - public String serviceUpdate
	 * Parameter(매개변수 ID/PW , 없으면 N/A)
	 - @ModelAttribute("serviceNo") MarketVO marketVO, Model model
	 * return type(void, String, ServiceVO)
	 * 쿼리(DB 작업 insert, select, update, delete)
	 */
	@RequestMapping("serviceUpdate")
	public String serviceUpdate(@ModelAttribute("marketVO") MarketVO marketVO, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();

		Object member = session.getAttribute("id");

		if (member == null) {
			return "redirect:/member/login";
		} else {

			logger.info("##################################################");
			logger.info("## serviceUpdate {} :: " + marketVO.toString());
			logger.info("##################################################");

			MarketVO serviceInfo = marketService.serviceDetail(marketVO);

			model.addAttribute("serviceInfo", serviceInfo);
			return "service/serviceUpdate";
		}
	}
	/**
	 * 기능 - 서비스를 삭제 하는 곳
	 상세보기에서 삭제를 누르면 삭제할거 serviceNo를 기준삼기
	 serviceNo를 DB에 보낸다음에 삭제한 후에는 리다이렉트 사용해서 마켓리스트로 넘어간다.
	 * URL이름 - serviceDelete
	 * 화면이름 - service/serviceDelete.html
	 * Method - public String serviceUpdate
	 * Parameter(매개변수 ID/PW , 없으면 N/A)
	 - @ModelAttribute("serviceNo") MarketVO marketVO, Model model
	 * return type(void, String, ServiceVO)
	 * 쿼리(DB 작업 insert, select, update, delete)
	 - DELETE FROM MARKET WHERE SERVICE_NO = #{serviceNo}
	 */

	@RequestMapping("serviceDelete")
	@ResponseBody
	public MarketVO serviceDelete(MarketVO marketVO, HttpSession session) throws Exception{

		return marketService.serviceDelete(marketVO);
	}

	/**
	 * 기능 - 찜 기능 테이블 (jmstate)
	 		 사용자 ID는 JM_ID 서비스 번호는 JM_SERVICE
			 세션있는 회원들만이 찜하기 버튼이 보여진다. 
			 찜버튼을 누르면 찜 jmstate 테이블에 insert JM_ID, JM_SERVICE
			 다시 누르면 찜취소가 된다 jmstate 테이블에 delete 
			 찜하기 버튼을 누르면 디비  jm_State에 +1씩 된다
			 찜은 게시물 하나에서 한 사람당 1번만 할 수 있음.
	 * URL이름 - jmSave
	 * Method - public int jmSave
	 * Parameter(매개변수 ID/PW , 없으면 N/A)
	 	- MarketVO marketVO
	 * return type(void, String, ServiceVO)
	 * 쿼리(DB 작업 insert, select, update, delete)
		- INSERT INTO JMSTATE (JM_ID, JM_SERVICE) VALUES (#{jmId}, #{jmService})
		- DELETE FROM JMSTATE WHERE JM_ID = #{jmId} AND JM_SERVICE = #{jmService}
		- UPDATE MARKET SET JM_STATE = <choose> <when test='gubun == "I"'> JM_STATE + 1 </when>
		  <when test='gubun == "D"'> JM_STATE - 1 </when></choose> WHERE SERVICE_NO = #{jmService}
	 */
	@RequestMapping("jmSave")
	@ResponseBody
	public int jmSave(MarketVO marketVO) throws Exception{
		// marketVO안에 session id랑 serviceNo 담겨있음
		return marketService.jmSave(marketVO);
	}
}