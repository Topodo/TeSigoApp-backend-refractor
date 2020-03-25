# TeSigoApp-backend-refractor

## REST Services

### 1) Get the list of courses of an specific user (GET):
`http://host:por/api/users/{user_id}/courses`
`http://host:por/api/users/{user_id}/courses?sort=asc`
`http://host:por/api/users/{user_id}/courses?sort=desc`
### 2) Get the information of an specific course (GET):
`http://host:por/api/courses/{course_id}` 
### 3) Creates a new course and links to a list of users (POST):
`http://host:por/api/courses/user/{user_id}`
`http://host:por/api/courses/user/{user_id}?users_ids=id1,id2`
```javascript
Request body
{
	"name": "4to básico"
}
```