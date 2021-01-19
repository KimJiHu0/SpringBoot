package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class CrawlingController {

	// properties 설정
	// ChromeDriver를 다운로드 받은 경로를 작성해야하는 PATH 전역변수를 선언하여 값을 입력해줍니다.
	private static final String DRIVER_PATH = "C:\\chromeDriver\\chromedriver.exe";
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";

	public static WebDriver driver;
	public static WebElement element;

	@RequestMapping("crawling.do")
	public String crawlingWeb() {
		return "crawling/crawlingWeb";
	}

	@RequestMapping("webcrawling.do")
	@ResponseBody
	public String webCrawling() throws InterruptedException {
		// property를 설정해줍니다.
		System.setProperty(WEB_DRIVER_ID, DRIVER_PATH);

		// Driver 설정을 해줍니다.
		ChromeOptions options = new ChromeOptions();
		// 아래의 명령어는 사실 창이 떠져있지만 사용자의 화면에는 보여지지 않게하기위한 명령어입니다.
		// 화면이 뜨는걸 보고싶으신 분은 비활성화를 하시면 됩니다.
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

		driver = new ChromeDriver(options);
		driver.get("https://www.cgv.co.kr/movies");

		// 여기까지하면 CGV 페이지에서 무비차트가 켜집니다. 이제부터는 현재 순위에 해당하는 값을을 가져와서 MAP에 담아보겠습니다.

		// 더보기 버튼을 클릭하는 명령어입니다.
		driver.findElement(By.className("btn-more-fontbold")).click();

		// 1초 쉬었다가 
		//Thread.sleep(1000);

		// span태그의 class이름이 thumb-image인 태그 아래에 img태그들을 전부 imgs라는 List에 담아줬습니다.
		List<WebElement> imgs = driver
				.findElements(By.cssSelector("span[class=thumb-image] img[onerror=\"errorImage(this)\"]"));
		// span태그의 class이름이 title인 애를 모두 담아주었습니다.
		List<WebElement> titles = driver.findElements(By.cssSelector("strong[class=title]"));
		// span태그의 class이름이 percent의 하위태그에 있는 span태그를 List에 담아주었습니다.
		List<WebElement> percents = driver.findElements(By.cssSelector("strong[class=percent] span"));
		

		// JSON형태로 바꿔주기 위한 List변수를 선언합니다.
		List<Object> file = new ArrayList<Object>();
		// List를 json형태로 변경해주기 위해서 Gson을 사용합니다.
		// pom.xml에서 추가해주면 됩니다.
		Gson gson = new Gson();


		// 더보기를 눌렀을 때 영화 포스터들은 잘 가져와지기 떄문에 imgs의 size만큼 반복문을 돌렸습니다.
		for (int i = 0; i < imgs.size(); i++) {
			
			// JSON형태로 보내주기 위해 Map을 선언해서 List들을 담아주기 위해서 선언했습니다.
			Map<Object, Object> map = new HashMap<Object, Object>();
			
			// map에 {"movieTitle" : "??", "movieImgSrc" : "?", "moviePercent" : "??"} 식으로 담아집니다.
			map.put("movieTitle", titles.get(i).getText());
			map.put("movieImgSrc", imgs.get(i).getAttribute("src"));
			map.put("moviePercent", percents.get(i).getText());
			
			// 그 담아진 map을 file이라는 List에 담아줍니다.
			file.add(map);
			
		}
		// 그리고 gson으로 JSON형태로 변형한 List인 file변수를 json이라는 String 변수에 담아서
		String json = gson.toJson(file);

		// 리턴해줍니다.
		return json;
	}

}
