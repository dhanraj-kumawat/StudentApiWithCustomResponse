This is A Student Api CRUD Project in SpringBoot MVC


-> user can get student information with id(primary key)

eg. GET: http://localhost:8081/students

-> user can get all the students

eg. GET: http://localhost:8081/students

-> user can register 

eg. POST: http://localhost:8081/students

-> user can update information (id)

eg. PUT: http://localhost:8081/students/id

-> user can delete his account(id)

eg. DELETE: http://localhost:8081/students/6

@Custom queries:

-> user can search all the students with name 

eg. GET: http://localhost:8081/students/search?name=ra

-> Custom Exception Handling

eg. StudentIdNotFound

-> Custom Api Response with EntityResponse

eg. ResponseApi