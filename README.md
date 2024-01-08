Infractructure:

**RDS**

Create RDS as shown [here](https://www.youtube.com/watch?v=GSu1g9jvFhY)


**User Pool**

Create an aws user pool as shown in the begining of [this tutorial](https://www.youtube.com/watch?v=o2IM9oI6Eqk&ab_channel=SecurityinAction101) (not necesseary to use aws hosted login page). Make sure to enable ALLOW_USER_PASSWORD_AUTH in the client authentication flow. 
The login (and registration if you allow self registration) methods need to be modified by adding SECRET_HASH parameter. A method for generating the secret hash can be found [here](https://docs.aws.amazon.com/cognito/latest/developerguide/signing-up-users-in-your-app.html#cognito-user-pools-computing-secret-hash)
If you do not allow self-registration you'll need to create a user through aws. To receive a token for that user you need to change the password. You can create an endpoint for that, or do it through aws console.

How to change password:
```
aws cognito-idp admin-initiate-auth --user-pool-id %USER POOL ID% --client-id %APP CLIENT ID% --auth-flow ADMIN_NO_SRP_AUTH --auth-parameters USERNAME=%USERS USERNAME%,PASSWORD=%USERS CURRENT PASSWORD%,SECRET_HASH=%CALCULATED SECRET HASH%
```
```
aws cognito-idp admin-respond-to-auth-challenge --user-pool-id %USER POOL ID% --client-id %CLIENT ID% --challenge-name NEW_PASSWORD_REQUIRED --challenge-responses NEW_PASSWORD=%DESIRED PASSWORD%,USERNAME=%USERS USERNAME%,SECRET_HASH=%CALCULATED SECRET HASH% --session %SESSION KEY FROM PREVIOUS COMMAND with ""%
```


**Cognito**

Spring Boot integration with cognito as shown [here](https://dev.to/daviidy/api-security-how-to-implement-authentication-and-authorization-with-aws-cognito-in-spring-boot-4713?fbclid=IwAR1RlEKeoMiZwmdQf8b9IOl-8C1DKezTgGCButUdDape5mgLguxveRD9jQQ)

**Docker**


First the image was build using a dockerfile, then pushed to my public Dockerhub repository. 
The final ec2 docker-compose.yaml was running from the images published to repository. 
  Pushing docker image to docker registry:
    ```
    docker tag image-name user-name/repo-name
    ```
    ```
    docker push user-name/repo-name
    ```


**EC2**


1. Create an EC2 instance on AWS
2. To copy ec2-setup.sh to ec2 instance:
```
scp -i /path/to/your-key.pem /path/to/your-script.sh ec2-user@your-ec2-instance-public-dns:/path/on/ec2/instance

```
Make it executable:
```
chmod +x your-script.sh
```
ssh into the EC2 instance:
```
ssh -i /path/to/your-key.pem ec2-user@your-ec2-instance-public-dns
```
and then run the setup script
```
./path/on/ec2/instance/ec2-setup.sh
```
4. Copy docker-compose-ec2.yaml into the EC2
  ```
   scp -i  /path/to/your-key.pem docker-compose-ec2.yaml ec2-user@your-ec2-instance-public-dns
  ```
5. To allow the configuration of CORS in the backend and base url in the frontend create domain.env file on ec2
   ```
    rm -f domain.env
    echo "BASE_URL=your-ec2-instance-public-dns" >> domain.env
    echo "CROSS_ORIGIN=http://your-ec2-instance-public-dns" >> domain.env
   ```
6. Run your code with
  ```
    docker compose -f docker-compose-ec2.yaml up -d --build
```


(Possibly) usefull thing:

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

To make sure that the host can be set in angular I configured the following files:
.env.js
environment.ts
to get the hostname.

In the spring boot application the cross.origin property was moved to application.properties and is then read from a .env file.

Instructions on how to dynamically set Angular environment variables in Docker can be found [here](https://pumpingco.de/blog/environment-variables-angular-docker/)

