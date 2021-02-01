package com.chat.bot.controller;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KakaoChannel {

	private static final String DRIVER_PATH = "C:\\ChromeDriver\\chromedriver.exe";
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";

	public static WebDriver driver;
	public static WebElement element;

	// 카톡 id
	private static String kakao_id = "";
	// 카톡 pw
	private static String kakao_pw = "";

	public static void sendMessage(String msg) throws InterruptedException {

		// 받은 msg를 ,기준으로 잘라서 담기.
		String[] msgs = msg.split(",");

		// driver 설정
		System.setProperty(WEB_DRIVER_ID, DRIVER_PATH);

		// driver의 옵션 설정
		ChromeOptions options = new ChromeOptions();
		// driver 화면 안보기.
		// options.addArguments("headless");
		// 옵션 적용하기
		driver = new ChromeDriver(options);
		// PC로 카카오 채널 관리자로 페이지 켜기
		// driver.get("https://center-pf.kakao.com/_KlQvK/chats/"+url);
		driver.get("https://center-pf.kakao.com/_KlQvK/chats");

		// 로그인 창이 나오는데 ID입력
		driver.findElement(By.cssSelector("label[for=id_email_2")).click();
		driver.findElement(By.cssSelector("input[validator=email_or_phone_or_kakaoid]")).sendKeys(kakao_id);

		// 비번입력
		driver.findElement(By.cssSelector("label[for=id_password_3")).click();
		driver.findElement(By.cssSelector("input[validator=password]")).sendKeys(kakao_pw);

		// 로그인하기
		driver.findElement(By.cssSelector(".fld_login .wrap_btn .btn_g")).click();

		// 1초 쉬고
		Thread.sleep(1000);

		// 다시 부모로.
		// String firstWindow라는 변수에 방금 연 창인 부모창을 담아줍니다.
		String firstWindow = driver.getWindowHandle();
		// 그 후에 driver의 기본 메인을 처음으로 연 창으로 바꿔줍니다.
		driver.switchTo().window(firstWindow);
		
		// 그 다음에 element의 List. 변수 elements에 className이 item_info라는 태그들을 담아줍니다.
		// 이는 모든 채팅방을 의미합니다.
		List<WebElement> elements = driver.findElements(By.className("item_info"));

		// 이제 그 elements의 길이만큼 반복문을 돌려줍니다.
		for (int i = 0; i < elements.size(); i++) {
			// element라는 변수에 하나하나를 다 담아주고
			element = elements.get(i);
			// 0.5초 쉬고
			Thread.sleep(500);
			// 채팅방을 클릭하여 전부 열어줍니다.
			element.click();
		}
		// 그 후 1초 쉬고
		Thread.sleep(1000);
		// cnt라는 변수를 선언합니다.
		int cnt = 0;
		// 자식 창을 메인으로 바꿔준다.
		// 열려있는 모든 창은 Set<String> 이기 떄문에 forEach를 사용하였고,
		// 열려있는 모든 창을 하나하나 winHandle라는 변수에 담아줍니다.
		for (String winHandle : driver.getWindowHandles()) {
			// 첫 번째로 들어오는 winHandle는 부모의 창이기 때문에
			// cnt가 1일때만 동작하게 해줍니다.
			if (cnt > 0) {
				// 열러있는 자식창으로 포커스를 잡아주고,
				driver.switchTo().window(winHandle);
				// 그 자식 window창에서 textarea라는 태그를 찾아서 담은 후
				element = driver.findElement(By.tagName("textarea"));
				// 값들을 입력해줍니다.
				element.sendKeys(msgs[0]);
				// 줄바꿈
				element.sendKeys(Keys.LEFT_SHIFT, Keys.ENTER);
				// 1번지 입력
				element.sendKeys(msgs[1]);
				// 줄바꿈 ..
				element.sendKeys(Keys.LEFT_SHIFT, Keys.ENTER);
				element.sendKeys(msgs[2]);
				element.sendKeys(Keys.LEFT_SHIFT, Keys.ENTER);
				element.sendKeys(msgs[3]);
				element.sendKeys(Keys.ENTER);
			} else {
				cnt++;
			}
		}
	}
}
