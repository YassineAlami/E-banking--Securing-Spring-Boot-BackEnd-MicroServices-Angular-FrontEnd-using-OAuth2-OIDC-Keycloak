<h3>The primary objective of this project is to enhance the security of a Spring Boot microservice by implementing OAuth2 OIDC with Keycloak. This involves assigning roles and ensuring their proper consideration when accessing the application's functionalities, encompassing both the front and back ends </h3>

<hr>

<h2>Architecture</h2>


![Screenshot (1777) ](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/6ea3e463-5fbe-482b-964c-2392f66200ea)



<hr>

<h2>Steps</h2>


The initial phase involves the creation of an 'ebank-service' dedicated to the management of our bank's customers

![Screenshot (1800)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/8a647f67-3559-47b6-b416-84578c1fbae6)



Now our focus is on securing this service using Keycloak.<br>
By utilizing the token_endpoint in Keycloak Realm Settings, we successfully obtained the Token ID. From this, we extract the access token (bearer) for identification purposes.


![Screenshot (1801)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/fb88a8b4-79bc-4bf8-9203-9d36002ddfd5)




We configured the security settings for our customer in the ebank service, establishing it as 'STATELESS' and protected by JWT.<br>
To access the ebank microservice, providing the JWT is now imperative. Therefore, the process involves first obtaining identification, acquiring the access token, and subsequently sending it as a header named 'Authorization'<br>

![Screenshot (1803)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/1189bc4b-567d-4774-92c8-55997c64d115)



Now, let's explore role management. Suppose we want the 'getCustomers' method to require a 'USER' role. To achieve this, we initially annotate it with '@PreAuthorize("hasAuthority('USER')").' However, this alone isn't sufficient since JWT primarily considers scope, translating to authority (scope=authority), and not the roles established in Keycloak. <br>

To address this, we must instruct Spring Security to consider the 'roles' within 'realm_access.' Consequently, the authorities (roles) that Spring Security recognizes in our Ebank Service are as follows: <br>

![Screenshot (1804)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/e4909ff2-cbda-4c3e-9142-f32cc40b7779)



With the 'USER' role now recognized as one of the authorities by Spring Security, we gain access to endpoints that require this specific authority.



![Screenshot (1805)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/edc832bf-89fc-446b-a950-0b266ec3bf4c)



<h1>WE WILL BE BACK SOON!!!</h1>







