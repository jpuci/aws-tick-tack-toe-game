User Pool:
Create an aws user pool as shown in the begining of [this tutorial](https://www.youtube.com/watch?v=o2IM9oI6Eqk&ab_channel=SecurityinAction101) (not necesseary to use aws hosted login page). Make sure to enable ALLOW_USER_PASSWORD_AUTH in the client authentication flow. 
Spring boot integration as shown [here](https://dev.to/daviidy/api-security-how-to-implement-authentication-and-authorization-with-aws-cognito-in-spring-boot-4713?fbclid=IwAR1RlEKeoMiZwmdQf8b9IOl-8C1DKezTgGCButUdDape5mgLguxveRD9jQQ)
The properties 
```
aws.accessKeyId=aws_access_key
aws.secretKey=aws_secret_key
aws.region=aws_region
```
can be extracted by running 
```
cat .aws/credentials
```
in the aws console.

The login (and registration if you allow self registration) methods need to be modified by adding SECRET_HASH parameter. A method for generating the secret hash can be found [here](https://docs.aws.amazon.com/cognito/latest/developerguide/signing-up-users-in-your-app.html#cognito-user-pools-computing-secret-hash)

If you do not allow self-registration you'll need to create a user through aws. To receive a token for that user you need to change the password. You can create an endpoint for that, or do it through aws console.

How to change password:
```
aws cognito-idp admin-initiate-auth --user-pool-id %USER POOL ID% --client-id %APP CLIENT ID% --auth-flow ADMIN_NO_SRP_AUTH --auth-parameters USERNAME=%USERS USERNAME%,PASSWORD=%USERS CURRENT PASSWORD%,SECRET_HASH=%CALCULATED SECRET HASH%
```
```
aws cognito-idp admin-respond-to-auth-challenge --user-pool-id %USER POOL ID% --client-id %CLIENT ID% --challenge-name NEW_PASSWORD_REQUIRED --challenge-responses NEW_PASSWORD=%DESIRED PASSWORD%,USERNAME=%USERS USERNAME%,SECRET_HASH=%CALCULATED SECRET HASH% --session %SESSION KEY FROM PREVIOUS COMMAND with ""%
```
