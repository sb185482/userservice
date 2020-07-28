# Datanauts Userservice

## API Endpoints (can be queried with Postman):

1. Get All Users
GET -> http://localhost:8080/users

2. Get User By UserId
GET -> http://localhost:8080/users/1

3. Delete a User
DELETE -> http://localhost:8080/users/1

4. Add a User
POST -> http://localhost:8080/users \
Headers -> { "X-COM-PERSIST" : true } \
Body ->
```json
{
   "userId":21,
   "name":"Karlee Halvorson",
   "email":"dsenger@gmail.com",
   "address":"462 Feeney Locks South Kaylie, NH 52967-1173",
   "phone":"1000023720",
   "accountNo":"1027867"
}
```
## Run in Docker
```bash
git clone https://github.com/sb185482/userservice.git
cd userservice/
mvn clean install
docker build -t datanautsuserservice .
docker run -p 8080:8080 datanautsuserservice
```
