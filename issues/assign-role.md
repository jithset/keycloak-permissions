# Cannot assign roles for the user created

User cannot be able to assign role to user. I have tried different approach 

* create user with realmRoles
* update user with realmRoles
* create with role id
* stackoverflow question [link](https://stackoverflow.com/questions/58668496/keycloak-admin-api-cannot-set-role-mapping-while-creating-user)

## Setup

### Keycloak server

* Create instance of keycloak server using docker

```
docker run -d --name keycloak-test -p 8181:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak:latest
```

> create keycloak server with user admin with password admin running container in detaching mode with exposed port 8181

* create realm ```test-realm```
* create test user ```ajith``` assign roles of realm-management 
* create role ```admin```

#### Create client

* create client ```backendservice```
* root url ```http://localhost:8181```
* select ```Access Type : public```

## Api request

Keycloak Admin rest apis. [link for Keycloak Rest apis](https://www.keycloak.org/docs-api/8.0/rest-api/index.html)

### Get Access Token

```
http://localhost:8181/auth/realms/test-realm/protocol/openid-connect/token

Method : POST

Body : x-www-form-urlencoded
username : ajith
password : ajith
grant_type : password
client_id : backendservice

Response: 
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSl...",
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5...",
    "token_type": "bearer",
    "not-before-policy": 0,
    "session_state": "253d28df-0450-471b-8f6a-2fede0931cef",
    "scope": "profile email"
}
```

> Note : access_token is required for following api's

### Create user [link](https://www.keycloak.org/docs-api/8.0/rest-api/index.html#_users_resource)

```
http://localhost:8181/auth/admin/realms/test-realm/users

Method : POST

Headers: 

Authorization: Bearer {access-token}
Content-Type: application/json

Body : raw json

{
	"username": "abc3",
	"email": "ab3@gmail.com",
	"realmRoles": [
		"admin"
	],
	"credentials": [{
		"type": "password",
		"temporary": true,
		"value": "testpass"
	}],
	"enabled": true
}


Response: 
201 created

Output: 

User created successfully but role is not mapped to user
```

### List user

```
http://localhost:8181/auth/admin/realms/test-realm/users

Method : GET

Headers: 

Authorization: Bearer {access-token}

Response: 
200 OK

[
    {
        "id": "aa217986-9f4b-4ee3-843f-be419c8f5087",
        "createdTimestamp": 1574501153616,
        "username": "abc3",
        "enabled": true,
        "totp": false,
        "emailVerified": false,
        "firstName": "test firstname new",
        "email": "ab3@gmail.com",
        "disableableCredentialTypes": [],
        "requiredActions": [
            "UPDATE_PASSWORD"
        ],
        "notBefore": 0,
        "access": {
            "manageGroupMembership": true,
            "view": true,
            "mapRoles": true,
            "impersonate": true,
            "manage": true
        }
    },
    {
        "id": "0000f340-c917-48f6-8ae4-c96409143253",
        "createdTimestamp": 1574499638697,
        "username": "ajith",
        "enabled": true,
        "totp": false,
        "emailVerified": false,
        "disableableCredentialTypes": [],
        "requiredActions": [],
        "notBefore": 0,
        "access": {
            "manageGroupMembership": true,
            "view": true,
            "mapRoles": true,
            "impersonate": true,
            "manage": true
        }
    }
]

Output: 

List available users in realm
```

### Update user

```
http://localhost:8181/auth/admin/realms/test-realm/users/aa217986-9f4b-4ee3-843f-be419c8f5087

http://localhost:8181/auth/admin/realms/test-realm/users/<user-id>

Method : PUT

Headers: 

Authorization: Bearer {access-token}
Content-Type: application/json

Body : raw json

{
	"firstName": "test firstname",
	"realmRoles": [
		"admin"
	]
}

Response: 
204 No Content


Output: 

First name updated but role is not assigned
```


