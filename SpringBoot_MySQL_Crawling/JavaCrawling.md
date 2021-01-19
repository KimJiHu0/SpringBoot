# Java Crawling

> - **목표**
>
>   JAVA Selenium을 통해서 값을 크롤링한 후에, Map 객체에 담아서 이를 return하여 웹 페이지에서 화면에 뿌려주도록 하겠습니다.
>   CGV에 있는 영화 순위들을 크롤링하도록 하겠습니다.
>
> - **순서**
>
>   1. **우선 ChromDriver을 다운로드 받아야합니다.**
>      https://sites.google.com/a/chromium.org/chromedriver/ 의 경로로 들어가줍니다.
>      ![](https://postfiles.pstatic.net/MjAyMDEyMjRfMjI3/MDAxNjA4ODA0MzgwMzI3.6Fnt5O5hgN4N3yaOWcQ89bAMWC9WogyCOUxed1mBR9Mg.rL0HfPYXt4qqQId6f0G7Yw8EaF-eD4M7KgSBOoC3ZyIg.PNG.rgusqls/image.png?type=w773)
>      위와 같은 페이지가 나오게 되면, 빨간 체크박스 안에 두 개의 선택지가 나옵니다.
>      첫번째는 **안정적인 최신화버전**, 두번째는 **가장 최신버전**입니다.
>      저는 안정적인 최신화버전을 선택하도록 하겠습니다.
>      그 후 linux, max, win 버전이 나뉘어져 있는데, 본인의 OS에 맞게 다운로드 받으신 후 **압축을 푼 경로를 꼭 기억해주셔야 합니다.**
>
>   2. **이제 이클립스에서 pom.xml에 Library를 추가해야합니다.**
>
>      ```xml
>      <dependency>
>          <groupId>org.seleniumhq.selenium</groupId>
>          <artifactId>selenium-java</artifactId>
>          <version>3.3.1</version>
>      </dependency>
>      ```
>
>      위와 같이 추가를 해주게 되면 크롤링이 가능한 JAVA기반 selenium을 다운로드 받을 수 있습니다.
>
>      ```xml
>      <dependency>
>      	<groupId>org.jsoup</groupId>
>      	<artifactId>jsoup</artifactId>
>      	<version>1.13.1</version>
>      </dependency>
>      ```
>
>      jsoup을 사용하고 싶으시면 위의 디펜던시를 다운로드 받으시면 됩니다.
>
>   3. **기본적인 Setting 후 이제 코드로 달도록 하겠습니다.**
>
>      
>      
>      *Controller*
>      
>      ```java
>      package com.spring.boot.controller;
>      
>      import java.util.ArrayList;
>      import java.util.HashMap;
>      import java.util.List;
>      import java.util.Map;
>      
>      import org.openqa.selenium.By;
>      import org.openqa.selenium.WebDriver;
>      import org.openqa.selenium.WebElement;
>      import org.openqa.selenium.chrome.ChromeDriver;
>      import org.openqa.selenium.chrome.ChromeOptions;
>      import org.springframework.stereotype.Controller;
>      import org.springframework.web.bind.annotation.RequestMapping;
>      import org.springframework.web.bind.annotation.ResponseBody;
>      
>      import com.google.gson.Gson;
>      
>      @Controller
>      public class CrawlingController {
>      
>      	// properties 설정
>      	// ChromeDriver를 다운로드 받은 경로를 작성해야하는 PATH 전역변수를 선언하여 값을 입력해줍니다.
>      	private static final String DRIVER_PATH = "C:\\chromeDriver\\chromedriver.exe";
>      	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
>      
>      	public static WebDriver driver;
>      	public static WebElement element;
>      
>      	@RequestMapping("crawling.do")
>      	public String crawlingWeb() {
>      		return "crawling/crawlingWeb";
>      	}
>      
>      	@RequestMapping("webcrawling.do")
>      	@ResponseBody
>      	public String webCrawling() throws InterruptedException {
>      		// property를 설정해줍니다.
>      		System.setProperty(WEB_DRIVER_ID, DRIVER_PATH);
>      
>      		// Driver 설정을 해줍니다.
>      		ChromeOptions options = new ChromeOptions();
>      		// 아래의 명령어는 사실 창이 떠져있지만 사용자의 화면에는 보여지지 않게하기위한 명령어입니다.
>      		// 화면이 뜨는걸 보고싶으신 분은 비활성화를 하시면 됩니다.
>      		options.addArguments("headless");
>      
>      		// options.addArguments("--start-maximized"); // 전체화면으로 실행
>      		// options.addArguments("--disable-popup-blocking"); // 팝업 무시
>      		// options.addArguments("--disable-default-apps"); // 기본앱 사용안함
>      
>      		// 빈 텝 생성
>      		// driver.executeScript("window.open('about:blank', '_blank')");
>      
>      		// 텝 목록 가져오기
>      		// List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
>      
>      		// 첫번째 텝으로 전환
>      		// driver.switchTo().window(tabs.get(0));
>      
>      		driver = new ChromeDriver(options);
>      		driver.get("https://www.cgv.co.kr/movies");
>      
>      		// 여기까지하면 CGV 페이지에서 무비차트가 켜집니다. 이제부터는 현재 순위에 해당하는 값을을 가져와서 MAP에 담아보겠습니다.
>      
>      		// 더보기 버튼을 클릭하는 명령어입니다.
>      		driver.findElement(By.className("btn-more-fontbold")).click();
>      
>      		// 1초 쉬었다가
>      		Thread.sleep(1000);
>      
>      		// span태그의 class이름이 thumb-image인 태그 아래에 img태그들을 전부 imgs라는 List에 담아줬습니다.
>      		List<WebElement> imgs = driver
>      				.findElements(By.cssSelector("span[class=thumb-image] img[onerror=\"errorImage(this)\"]"));
>      		// span태그의 class이름이 title인 애를 모두 담아주었습니다.
>      		List<WebElement> titles = driver.findElements(By.cssSelector("strong[class=title]"));
>      		// span태그의 class이름이 percent의 하위태그에 있는 span태그를 List에 담아주었습니다.
>      		List<WebElement> percents = driver.findElements(By.cssSelector("strong[class=percent] span"));
>      		
>      
>      		// JSON형태로 바꿔주기 위한 List변수를 선언합니다.
>      		List<Object> file = new ArrayList<Object>();
>      		// List를 json형태로 변경해주기 위해서 Gson을 사용합니다.
>      		// pom.xml에서 추가해주면 됩니다.
>      		Gson gson = new Gson();
>      
>      
>      		// 더보기를 눌렀을 때 영화 포스터들은 잘 가져와지기 떄문에 imgs의 size만큼 반복문을 돌렸습니다.
>      		for (int i = 0; i < imgs.size(); i++) {
>      			
>      			// JSON형태로 보내주기 위해 Map을 선언해서 List들을 담아주기 위해서 선언했습니다.
>      			Map<Object, Object> map = new HashMap<Object, Object>();
>      			
>      			// map에 {"movieTitle" : "??", "movieImgSrc" : "?", "moviePercent" : "??"} 식으로 담아집니다.
>      			map.put("movieTitle", titles.get(i).getText());
>      			map.put("movieImgSrc", imgs.get(i).getAttribute("src"));
>      			map.put("moviePercent", percents.get(i).getText());
>      			
>      			// 그 담아진 map을 file이라는 List에 담아줍니다.
>      			file.add(map);
>      			
>      		}
>      		// 그리고 gson으로 JSON형태로 변형한 List인 file변수를 json이라는 String 변수에 담아서
>      		String json = gson.toJson(file);
>      
>      		// 리턴해줍니다.
>      		return json;
>      	}
>      
>      }
>      
>      ```
>
>      *JSP*
>      
>      ```JSP
>      <%@ page language="java" contentType="text/html; charset=UTF-8"
>          pageEncoding="UTF-8"%>
>          
>          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
>      <!DOCTYPE html>
>      <html>
>      <head>
>      <meta charset="UTF-8">
>      <title>Insert title here</title>
>      
>      <style type="text/css">
>      
>      	img{
>      		width : 150px;
>      		height : 200px;
>      	}
>      
>      </style>
>      
>      <!-- ajax를 사용하기 위해서 jQuery library를 추가해줍니다. -->
>      <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
>      <script type="text/javascript">
>      
>      	// 이 페이지가 화면에 보여지자마자 ajax를 실행하기 위해서 선언했습니다.
>      	$(function(){
>      		$.ajax({
>      			type : "post",
>      			dataType : "json",
>      			contentType : "application/json",
>      			url : "webcrawling.do",
>      			success : function(data){
>      				// data의 길이는 43입니다. [2020.12.25 현재기준] => 이는 영화가 바뀔때마다 크기가 달라집니다.
>      				for(var i = 0; i < data.length; i++){
>      					// table이라는 id를 가진 table태그에
>      					$("#table").append(
>      							// th태그들을 append해주고,
>      							"<col width='50px'>"+
>      				        	"<col width='100px'>"+
>      				        	"<col width='150px'>"+
>      				        	"<col width='50px'>"+
>      								"<tr>" +
>      								"<th>영화 순위</th>" +
>      								"<th>영화 제목</th>" +
>      								"<th>영화 포스터</th>" +
>      								"<th>영화 예매율</th>"
>      					);
>      					$("#table").append(
>      							// data의 i번지에서 movieTitle, movieImgSrc, moviePercent를 꺼내서 td태그에 넣어줍니다.
>      							// src같은 경우에는 td태그에 넣게되면 그대로 text로 출력되기 때문에 img태그를 만들어서 담아줍니다.
>      						"<tr>" +
>      						"<td>" + i + "</td>" +
>      						"<td>" + data[i].movieTitle + "</td>" +
>      						"<td><img alt = '영화 포스터' src = '"+ data[i].movieImgSrc + "'/></td>" +
>      						"<td>" + data[i].moviePercent + "</td>"
>      					);
>      				}
>      			},
>      			error : function(){
>      				alert("실패");
>      			}
>      		})
>      	});
>      
>      </script>
>      </head>
>      <body>
>      
>      	<h1>Crawling Web</h1>
>      	
>      	
>      	<h2>영화 예매율 순위</h2>
>      	<table id ="table" border="1">
>      	</table>
>      
>      </body>
>      </html>
>      ```
>      
>      위처럼 Gson을 사용해주기 위해서는 pom.xml에서 디펜던시를 추가해줘야합니다.
>      
>      ```xml
>      <dependency>
>      	<groupId>com.google.code.gson</groupId>
>      	<artifactId>gson</artifactId>
>      </dependency>
>      ```
>