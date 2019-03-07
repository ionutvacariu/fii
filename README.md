# FII Practic - Session I

## Spring Boot(Web - SpringMVC, Rest, JPA, H2)

This application exposes two endpoints: `/users` and `/transactions`
-------------------------------------------------------------------

 * On `/users` you can do usual CRUD operations via Rest Operations: `GET`, `PUT`, `POST`, `DELETE`(```User``` entity)
 * On `/transactions` you can make a `POST` operation that will transfer money between users(```Transaction``` entity).
 
 You can test your API using [SoapUI app](https://www.soapui.org/downloads/soapui.html)
 
 Example:
 Transfer money operation JSON:
 ```JSON
 {
	"fromUser": "1",
	"toUser": "2",
	"amount": "10000"
}
```
