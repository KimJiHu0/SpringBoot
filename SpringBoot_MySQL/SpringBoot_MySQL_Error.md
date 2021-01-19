# Spring Boot와 MySQL 연결 시 오류

> ![](https://postfiles.pstatic.net/MjAyMDEyMjJfMjI3/MDAxNjA4NjM3MjU4ODAx.W1av_ghi8vIVuept7vhp6ZOpLi61Hf4iKsvMuQY6nqog.hmzmWfXLNBtFtt4mviOQr1FAR_LohHyEGI10Q1N1l-Ag.PNG.rgusqls/image.png?type=w773)
>
> 기존에 MySQL을 SpringBoot와 연결할 때 application.properties에서는 위와 같이 작성했습니다.
> 하지만 Timezone Error를 접하게 되었습니다.
>
> ![](https://postfiles.pstatic.net/MjAyMDEyMjJfMjA1/MDAxNjA4NjM3MzcyOTIy.ADboe6a8JSRPyDOT3uyJJLMc8l0I1gBPNTQZoCXe2zkg.1siSZGOwdXnwYNyOTH5Ha1YOFHXeDzWq_hgS4fh1cEUg.PNG.rgusqls/image.png?type=w773)
>
> 그래서 위와 같이 url에 **?serverTimezone=UTC&useSSL=true**를 작성하고 나서 오류를 해결할 수 있었습니다. 오류의 이유는 간단했습니다.
> pom.xml에서 mysql-connector-java version이 5.1.x 이후 버전부터는 KST Timezone을 인식하지 못하는 이슈가 있습니다. 이를 해결해주기 위해서는 url에 위와 같이 붙여주면 됩니다.
>
> 
>
> 
>
> 
> 