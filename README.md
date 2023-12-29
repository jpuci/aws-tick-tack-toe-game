User Pool:

How to change password:
```
aws cognito-idp admin-initiate-auth --user-pool-id %USER POOL ID% --client-id %APP CLIENT ID% --auth-flow ADMIN_NO_SRP_AUTH --auth-parameters USERNAME=%USERS USERNAME%,PASSWORD=%USERS CURRENT PASSWORD%,SECRET_HASH=%CALCULATED SECRET HASH%
```
```
aws cognito-idp admin-respond-to-auth-challenge --user-pool-id %USER POOL ID% --client-id %CLIENT ID% --challenge-name NEW_PASSWORD_REQUIRED --challenge-responses NEW_PASSWORD=%DESIRED PASSWORD%,USERNAME=%USERS USERNAME%,SECRET_HASH=%CALCULATED SECRET HASH% --session %SESSION KEY FROM PREVIOUS COMMAND with ""%
```
