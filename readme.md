# Job posting API

#### Post a new job

    POST /jobs HTTP/1.1
    Host: http://localhost:3456/posts
    Content-Type: application/json
```json
{
"profile":"task 1",
"description":"post",
"techs":["1","2"],
"experience":4,
"location":"nigeria"
}

```

##### Response
```json
{
    "id": "637f2af5c98b1004ee3d9db6",
    "profile": "Java Developer",
    "description": "Working in java tech",
    "experience": 4,
    "techs": [
        "Java",
        "Spring boot"
    ],
    "location": "UK",
    "createdAt": "2022-11-24T08:27:32.949+00:00",
    "updatedAt": "2022-11-24T08:27:32.949+00:00"
}
```

---

#### Get all jobs

    GET /jobs HTTP/1.1
    Host: http://localhost:3456/posts

#### Get a job by id

    GET /jobs/:id HTTP/1.1
    Host: http://localhost:3456/posts/:id
    Example: http://localhost:3456/posts/637f2698e5454b13fdfd4f50

#### Update a job
    
        PUT /jobs/:id HTTP/1.1
        Host: http://localhost:3456/posts/:id
        Content-Type: application/json
    ```json
    {
    "profile":"task 1", 
    "description":"post",
    "techs":["1","2"],
    "experience":4,
    "location":"nigeria"
    }
    
    ```
        
    #### Delete a job
    
        DELETE /jobs/:id HTTP/1.1
        Host: http://localhost:3456/posts/:id
        Example: http://localhost:3456/posts/637f2698e5454b13fdfd4f50