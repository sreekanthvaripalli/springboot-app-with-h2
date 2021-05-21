# springboot-app-with-h2
this is a simple spring-boot application in domain driven development model(hexagonal) configured with H2(in-memory) database - Maven

Run the app using below command:

    mvn spring-boot:run

After server startup successfully, open your browser and access below url:

    http://localhost:8080/swagger-ui/

below endpoints are exposed:
    
    save user: /saveUser
    get user: /getUser
    administer user: /administerUser
    delete user: /deleteUser

Access h2-console at: 

    http://localhost:8080/h2-console 

and provide below details to login
    
    Driver class: org.h2.Driver
    JDBC URL: jdbc:h2:mem:userdetailsDB
    username: sa
    password: just leave it empty
