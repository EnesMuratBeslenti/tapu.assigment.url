# tapu.assigment.url

Bu projede login olmuş kullanıcadan alınan url farklı bir link içine atarak kullanmasını sağladık.
Bazı APi'lerin postman sonuçları yazılan kodların çalışma senaryoları denenerek aşağıda görselleştirilmiştir.
 update
 POST :http://localhost:8010/api/v1/users/register
![image](https://user-images.githubusercontent.com/66941183/134699202-7ec87cea-4648-483b-a5fb-822ece5b1c50.png)
POST VALİDASYON..
![image](https://user-images.githubusercontent.com/66941183/134699322-f19cc23a-8d5b-4c54-b087-9c951f6a135e.png)
![image](https://user-images.githubusercontent.com/66941183/134699374-971abac4-deeb-4aad-9e44-73d3a90c4c99.png)

----------------------------------------------------------------------------------------------------------------
POST http://localhost:8010/api/v1/users/login
![image](https://user-images.githubusercontent.com/66941183/134699565-5d4da1c4-01ab-4323-93db-8f218ffc00ee.png)
LOGİN VALİDASYON-----
![image](https://user-images.githubusercontent.com/66941183/134699654-56a2d1cf-7f31-4cae-b483-642ca48c9f62.png)
POST http://localhost:8010/api/v1/url/addUrl
![image](https://user-images.githubusercontent.com/66941183/134702750-d95de75d-f928-4b2b-bd31-00f54c100303.png)
http://localhost:8010/api/v1/url/redirect/479ffd0f-8a7b-4bd8-9289-d083a8aa5319 
479ffd0f-8a7b-4bd8-9289-d083a8aa5319==google.com
![image](https://user-images.githubusercontent.com/66941183/134703053-6c5a079b-36d4-4daf-956b-79235284f239.png)

GET http://localhost:8010/api/v1/url/getUrlFindByUserId/{{userId}}
![image](https://user-images.githubusercontent.com/66941183/134703701-23cf3c42-2ce9-4d61-861c-080965815db1.png)
