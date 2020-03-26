# TeSigoApp-backend-refractor

## REST Services

### 1) Get the list of courses of an specific user (GET):
`http://host:por/api/users/{user_id}/courses`
`http://host:por/api/users/{user_id}/courses?sort=asc`
`http://host:por/api/users/{user_id}/courses?sort=desc`
### 2) Get the information of an specific course (GET):
`http://host:por/api/courses/{course_id}` 
### 3) Creates a new course and links to a list of users (POST):
`http://host:por/api/courses?users_ids=id1,id2`
```javascript
Request body
{
	"name": "4to básico"
}
```
### 4) Get all subjects of an specific course (GET):
`http://host:port/api/courses/{course_id}/subjects`
### 5) Creates a new user using the current user permissions (POST):
`http://host:port/api/users?current_user_id=id1`
```javascript
/* Request body
 * roles = [profesor, admin, paradoctente, utp, pie]
 */
{
	"firstName": "FirstName",
	"lastNames": "LastNames",
	"email": "email@gmail.com",
	"photo": "base64 string",
	"role": "profesor",
	"firebaseUID": "user_id_provided_for_firebaseauth"
}
```