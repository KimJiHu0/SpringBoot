<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#map {
	width: 100%;
	height: 500px;
	border: black solid 2px;
}
</style>
</head>
<body>

	<h1>현재 내 위치</h1>


	<div id="map"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ce38396f2da38284e03d8c975450cd22&libraries=services,clusterer,drawing"></script>
	<script type="text/javascript">
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 5
		// 지도의 확대 레벨 
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		//	HTML5의 geolocation으로 사용할 수 있는지 확인
		if(navigator.geolocation){
			// Geolocation을 이용해서 접속 위치 얻어오기
			navigator.geolocation.getCurrentPosition(function(position){
				
				var lat = position.coords.latitude; // 위도
				var lon = position.coords.longitude; // 경도
				
				var locPosition = new kakao.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성
				var message = '<div style="padding:5px;">현재위치</div>';
				
				// 마커와 인포윈도우를 표시합니다.
				displayMarker(locPosition, message);
				
			});
		// HTML5의 Geolocation을 사용할 수 없을 때 마커 표시 위치와 인포 윈도우 내용을 설정.
		} else {
			
			var locPosition = new kakao.maps.LatLng(33.450701, 126.570667);
			var message = 'geolocation을 사용할 수 없습니다..ㅠ^ㅠ';
			
			displayMarker(locPosition, message);
		}
		
		// 지도에 마커와 인포윈도우를 표시하는 함수.
		function displayMarker(locPosition, message){
			
			// 마커를 생성합니다.
			var marker = new kakao.maps.Marker({
				map : map,
				position : locPosition
			});
			
			// 인포윈도우에 표시할 내용
			var iwContent = message;
			var iwRemoveable = true;
			
			// 인포윈도우를 생성.
			var infowindow = new kakao.maps.InfoWindow({
				content : iwContent,
				removable : iwRemoveable
			});
			
			// 인포윈도우를 마커 위에 표시.
			infowindow.open(map, marker);
			
			// 지도 중심좌표를 접속위치로 변경
			map.setCenter(locPosition);
		}
	</script>
</body>
</html>