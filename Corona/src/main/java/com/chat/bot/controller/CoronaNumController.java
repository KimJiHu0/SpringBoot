package com.chat.bot.controller;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoronaNumController {

	// properties 설정
	// ChromeDriver를 다운로드 받은 경로를 작성해야하는 PATH 전역변수를 선언하여 값을 입력해줍니다.
	private static final String DRIVER_PATH = "C:\\ChromeDriver\\chromedriver.exe";
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";

	public static WebDriver driver;
	public static WebElement element;

	
	// 코로나에 대한 확진자를 알고 싶다면 이 메소드를 불러서 받자.
	public static String coronaNum() {
		
		Logger logger = LoggerFactory.getLogger(CoronaNumController.class);

		// Property 설정하기
		System.setProperty(WEB_DRIVER_ID, DRIVER_PATH);

		// Driver 설정하기
		ChromeOptions options = new ChromeOptions();

		// 크롬이 켜지는 것을 보고 싶으면 아래의 명령어 비활성화
		options.addArguments("headless");

		// options.addArguments("--start-maximized"); // 전체화면으로 실행
		// options.addArguments("--disable-popup-blocking"); // 팝업 무시
		// options.addArguments("--disable-default-apps"); // 기본앱 사용안함

		// 빈 텝 생성
		// driver.executeScript("window.open('about:blank', '_blank')");

		// 텝 목록 가져오기
		// List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		// 첫번째 텝으로 전환
		// driver.switchTo().window(tabs.get(0));

		// 위에서 설정해준 options를 driver라는 크롬드라이버에 설정 적용
		driver = new ChromeDriver(options);
		// 원하는 URL을 작성하여 창을 띄우기.
		// 이 URL은 naver에 "코로나 확진자" 라는 검색어를 입력한 결과창.
		driver.get(
				"https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90");

		// ========================== 국내 코로나 감염자 ============================

		// .status_today .info_02 .info_title 는 돔탐색
		// status_today 라는 className 밑에 있는 info_02라는 className 밑에 있는 info_num이라는
		// className를 element에 담고
		element = driver.findElement(By.cssSelector(".status_today .info_02 .info_num"));
		// 그에 대한 Text를 추출하여 corona_Type라는 변수에 담았다.
		String corona_Num1 = element.getText();
		logger.info("------------------------------");
		logger.info("추출한 값 : " + corona_Num1);
		logger.info("------------------------------");
		// =============================================================================
		
		// ========================= 해외 코로나 유입자 ================================
		
		// .status_today .info_02 .info_title 는 돔탐색
		// status_today 라는 className 밑에 있는 info_02라는 className 밑에 있는 info_num이라는
		// className를 element에 담고
		element = driver.findElement(By.cssSelector(".status_today .info_03 .info_num"));
		// 그에 대한 Text를 추출하여 corona_Type라는 변수에 담았다.
		String corona_Num2 = element.getText();
		logger.info("------------------------------");
		logger.info("추출한 값 : " + corona_Num2);
		logger.info("------------------------------");
		
		// =============================================================================
		
		// ============================= 총 합 확진자 ==================================
		
		int total = Integer.parseInt(corona_Num1) + Integer.parseInt(corona_Num2);
		logger.info("총 확진자 : " + total);
		
		// =============================================================================
		
		
		// 어제 날짜를 가져오기 위해서 선언
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		// coronanum이라는 method를 호출했을 때 반환해줄 결과 값.
		String result = "";
		
		// 여기서 주의할 점
		// 30일인 날과 31일 날을 계산해서 바꿔줘야함.
		// 31일 : 1,3,5,7,8,10,12
		// 30일 : 4,6,9,11
		// 여기서 2월은 윤년일 때에는 29일까지, 아닐떈 28일까지.
		if(day - 1 == 0) {
			month -= 1;
			// 31일인 날
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				day = 31;
			}
			// 30일인 날
			else if(month == 4 || month == 6 || month == 9 || month == 11) {
				day = 30;
			}
			// 2월일 때
			else if(month == 2){
				// 윤년일 때
				if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
					day = 29;
				} else {
					day = 28;
				}
			}
			// 1월 1일에서 전 날꺼 계산하기.
			else {
				// month가 0일때
				year -= 1;
				month = 12;
				day = 31;
			}
			result = String.format("[ %d년 %d월 %d일 ],국내발생 : %s명,해외발생 : %s명,총합 : %d명",
					year, month, day, corona_Num1, corona_Num2, total);
			logger.info(result);
		}
		//
		else {
			day -= 1;
			result = String.format("[ %d년 %d월 %d일 ],국내발생 : %s명,해외발생 : %s명,총합 : %d명",
					year, month, day, corona_Num1, corona_Num2, total);
			logger.info(result);
		}
		
		return result;
	}
}
