# CrudApp-Analista2
CRUD Application in AWS with DynamoDB

## Contents

<details>
<summary><strong>Details</strong></summary>
	
  -   [Architecture](#architecture)
  -   [Entity CRUD Operations](#entity-crud-operations)
  -   [Create Users](#create-users)
    
</details>

# Architecture

This API allows to make a user CRUD on an AWS DynamoDB table, this API is dockerized inside a Linux instance of AWS "t2.micro". 

![image](https://user-images.githubusercontent.com/61521775/116791427-ed13d300-aa7f-11eb-9c7f-7bf095461929.png)

## Entity CRUD Operations

| HTTP Verb  |                                               `/api/user`                                               |                                              `/api/user/<userId>`                                     |
| ---------- | :--------------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------------------: |
| **POST**   |                                CREATE a new user.                                 |                                          :x:                        |
| **GET**    | This will return data from all users in DB.  | READ user data from a specified ID. This will return data from a single user only.  |
| **PUT**    |                                                    :x:                                                     |                                                         :x:                                                          |
| **PATCH**  |                                                    :x:                                                     |                                                         UPDATE an attribute of a specified user                                                          |
| **DELETE** |                                                    :x:                                                     |                                          DELETE an User from DB                                         |

A complete list of user endpoints can be found in the
[CRUD Swagger](http://ec2-52-15-70-16.us-east-2.compute.amazonaws.com/swagger-ui.html#/)

## Create Users

Create Users map to HTTP POST.

-   The `/api/user` endpoint is used for creating new user in DB 

Any newly created user must have `userName` and `age` attributes, the userID attribute are aautomatically generated 
#### :one: Request:
```console
{
    "userName": "Andres Felipe Gonzalez Arenas",
	"age": "31"
}
```
#### :one: Response POST /api/user:

```console
[
    {
        "userId": "f3f7548a-ff40-4ac7-b39e-0f40d140f055",
        "userName": "Sara",
        "age": "27"
    },
    {
        "userId": "94f76411-9ce3-4a77-9f0c-10bbaa039055",
        "userName": "andfegon",
        "age": "25"
    },
    {
        "userId": "e3406344-62ac-4258-bae8-e87a8afd6062",
        "userName": "Andres Felipe Gonzalez Arenas",
        "age": "31"
    },
    {
        "userId": "f93f45b7-952b-4af2-a177-d8e7e29ca0b3",
        "userName": "Adriana Maria",
        "age": "53"
    },
    {
        "userId": "7ea2a783-1630-4cab-9390-5da4bb1fe691",
        "userName": "Laura",
        "age": "27"
    }
]
```
