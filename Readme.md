# 📝 Student Management Backend Project

## 1️⃣ Project Overview

**Purpose:** Backend system for a school to manage **students, teachers, classes, subjects, and marks** with:

- JWT authentication & role-based authorization
- Clean architecture: Controller → Service → Repository → DB
- Swagger/OpenAPI for API documentation
- Docker + PostgreSQL setup
- Pagination & sorting for large datasets
- Ready for deployment / DevOps showcase


## 2️⃣ Architecture Diagram (Whiteboard Ready)

```
+---------------------+
|     Controller      | <-- Handles HTTP requests/responses (DTOs)
+---------------------+
          |
          v
+---------------------+
|       Service       | <-- Business logic, validation, JWT checks
+---------------------+
          |
          v
+---------------------+
|     Repository      | <-- JPA/Hibernate access to PostgreSQL
+---------------------+
          |
          v
+---------------------+
|    PostgreSQL DB    | <-- Tables: Student, Teacher, Class, Subject, Marks
+---------------------+
```


## 3️⃣ ER Diagram

```
Class 1:N Student
Class 1:N Subject
Teacher 1:N Subject
Subject 1:N Marks
Student 1:N Marks
```

**Tables & Columns:**

- **Student:** id, name, email, age, gender, classId
- **Teacher:** id, name, email
- **Class:** id, name, section
- **Subject:** id, name, teacherId, classId
- **Marks:** id, studentId, subjectId, marksObtained, grade


## 4️⃣ DTOs (Request / Response)

**Auth:**

- LoginDTO → username, password
- TokenDTO → JWT token, expiry

**Student:**

- StudentResponseDTO → id, name, rollNumber, email, age, gender, className
- MarksDTO → subject, marksObtained, grade
- RankDTO → rank, totalMarks, average

**Teacher:**

- TeacherResponseDTO → id, name, email, assignedClasses
- ClassStudentsDTO → classId, className, List<StudentResponseDTO>
- AddMarksDTO → studentId, subjectId, marksObtained

**Principal:**

- TeacherCreateDTO → name, email, assignedSubjects
- ClassReportDTO → classId, className, List<StudentMarksDTO>


## 5️⃣ Controller Endpoints

| Controller | Endpoint                                 | Method | Role      | RequestDTO       | ResponseDTO              |
| ---------- | ---------------------------------------- | ------ | --------- | ---------------- | ------------------------ |
| Auth       | /api/auth/login                          | POST   | ALL       | LoginDTO         | TokenDTO                 |
| Auth       | /api/auth/logout                         | POST   | ALL       | -                | Status                   |
| Student    | /api/students/me                         | GET    | STUDENT   | -                | StudentResponseDTO       |
| Student    | /api/students/me/marks                   | GET    | STUDENT   | -                | List<MarksDTO>           |
| Student    | /api/students/me/rank                    | GET    | STUDENT   | -                | RankDTO                  |
| Teacher    | /api/teachers/me                         | GET    | TEACHER   | -                | TeacherResponseDTO       |
| Teacher    | /api/teachers/classes                    | GET    | TEACHER   | -                | List<ClassDTO>           |
| Teacher    | /api/teachers/classes/{classId}/students | GET    | TEACHER   | -                | List<StudentResponseDTO> |
| Teacher    | /api/teachers/classes/{classId}/marks    | POST   | TEACHER   | AddMarksDTO      | Status                   |
| Teacher    | /api/teachers/classes/{classId}/ranking  | GET    | TEACHER   | -                | List<RankDTO>            |
| Principal  | /api/principal/teachers                  | POST   | PRINCIPAL | TeacherCreateDTO | TeacherResponseDTO       |
| Principal  | /api/principal/teachers                  | GET    | PRINCIPAL | -                | List<TeacherResponseDTO> |
| Principal  | /api/principal/students                  | GET    | PRINCIPAL | -                | List<StudentResponseDTO> |
| Principal  | /api/principal/reports/class/{classId}   | GET    | PRINCIPAL | -                | ClassReportDTO           |
| Public     | /api/public/health                       | GET    | ALL       | -                | Status                   |
| Public     | /api/public/version                      | GET    | ALL       | -                | VersionDTO               |


## 6️⃣ Role Matrix

| Role      | Accessible Controllers |
| --------- | ---------------------- |
| STUDENT   | Auth, Student          |
| TEACHER   | Auth, Teacher          |
| PRINCIPAL | Auth, Principal        |
| Public    | Public                 |


## 7️⃣ Pagination & Sorting Overview

- **Purpose:** Handle large datasets (students/teachers)
- **Implementation:** Spring Boot `Pageable` interface
- **Endpoints Example:** `/api/teachers/classes/{classId}/students?page=0&size=10&sort=rollNumber,asc`
- **Response Structure:**

```json
{
  "content": [
    /* List<StudentResponseDTO> */
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10
  },
  "totalPages": 5,
  "totalElements": 50
}
```


## 8️⃣ Sample Data Flow (Whiteboard Ready)

```
Student Login
     |
     v
[AuthController] → validate credentials → generate JWT
     |
     v
[StudentController] → getStudent / getMarks / getRank
     |
     v
[StudentService] → fetch from StudentRepo / MarksRepo
     |
     v
[PostgreSQL DB] → returns data
     |
     v
[StudentController] → converts to DTO → Response
```

## 9️⃣ DevOps & Deployment Notes

- **Dockerfile:** openjdk base → copy jar → expose 8080 → entrypoint java -jar
- **Docker Compose:** backend + postgres service → ports 8080:8080, 5432:5432
- **Health check:** `/api/public/health`
- Optional: Minikube / K8s deployment
- Swagger UI → API documentation `/swagger-ui.html`

---

