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

---

#### Get all jobs

    GET /jobs HTTP/1.1
    Host: http://localhost:3456/posts

#### Get a job by id

    GET /jobs/:id HTTP/1.1
    Host: http://localhost:3456/posts/:id
    Example: http://localhost:3456/posts/637f2698e5454b13fdfd4f50