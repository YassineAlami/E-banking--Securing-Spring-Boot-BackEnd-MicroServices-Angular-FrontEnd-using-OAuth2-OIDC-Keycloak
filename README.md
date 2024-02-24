

<hr>

<h2>Architecture</h2>

![Screenshot (1777)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/f4ecb1a0-4382-42ed-9f69-184fb7ce496f)


<hr>


<h2>Steps</h2>


The first step is to launch Keycloak. For the time being, we'll leave it configured with an H2 database, which is the default setting

![Screenshot (1780)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/efe8c4e2-7ec8-4725-82dc-58fc42e8a0f8)



"Keycloak defaults to starting at port 8080. Once we access the main interface, the next step is to create an admin account.

![Screenshot (1781)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/5ad361df-5d1c-4f12-8957-a5480490455e)



After creating our admin account, we can access the 'Administration console.' Upon entering the username and password, we are redirected to the 'Keycloak environment.'

![Screenshot (1783)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/d326879c-2d6b-4b78-bdc3-f55e48612833)




Now, our initial task is to create a 'Realm,' which can be viewed as the kingdom we intend to secure. A Realm can encompass multiple applications. The name we've chosen for our newly created Realm is 'wallet-realm.

![Screenshot (1784)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/2b094686-6aab-4013-b376-3d7f4198a06d)



Within this new realm, we will create the applications we intend to secure. To achieve this, we'll set up some 'clients.' Our initial client is named 'wallet-client.'

![Screenshot (1785)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/d05da1bf-9ab9-440f-8b2d-5e248b6c2cf1)

basically what you seeing right here means <br>
✅ The front app will start at the port 4200<br>
✅ For redirection URLs (call-back), we've configured '*', signifying that any URL with the base "/4200" is permitted post-authentication<br>
✅ Upon logging out, redirection is set to /4200/ again.<br>
✅ We authorize any page from any domain to send requests to Keycloak (acknowledging that this might not be the safest approach, but we will address it later).<br>

![Screenshot (1786)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/9a23a7de-7a0c-4417-88b7-689f10f3157f)


![Screenshot (1787)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/2faa0ae5-6a2e-4f32-95ac-39c05939a104)



now we will create a user, so that we can test how Keycloak will handl the users.
creating a new user, that has the name "user1" and email "user1@gmail.com" 


![Screenshot (1788)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/34c825c4-81ba-4f5a-9044-8343cb747cc6)



Now, we will assign a password to the user we just created ("user1") as '12345' and let's not make it temporary for now. Following that, we will proceed to create another user, 'yassine,' mirroring the process we followed for the first one

![Screenshot (1789)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/5285b591-ed56-45a4-b2fe-304f97825521)


now that we have some users, we can start creating Roles.
let s create 2 Roles "USER" and "ADMIN"

![Screenshot (1790)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/640198fc-972c-4acb-bf12-5ed46c4afc5b)



now let s assigne the roles to the users

![Screenshot (1791) ](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/265d5bbc-10dd-43ee-8943-34783a3f7911)

![Screenshot (1791)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/e1f70506-6a74-41d7-974b-2397e22e23e5)


To test our progress thus far, we need to obtain the 'token_endpoint' from the 'OpenID Endpoint Configuration' within Keycloak's 'Realm settings' <br>
We will then use Postman to send a POST request to this endpoint and verify if we can successfully retrieve the 'ID Token' (Refresh Token and Access Token).


![Screenshot (1792)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/bcb31ad8-ba8f-4e77-add4-01d3d2b4bbb3)


This is how our Access Token looks when decoded. We can observe that the algorithm is set to "RS256," along with details such as the expiration date (exp), userID (sub), and various claims. <br>
Importantly, we can also see the roles assigned to this specific user

![Screenshot (1795)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/c2d6145f-12de-4a0b-9d7f-95f54f12db99)


When the Access Token expires, we can request a new one by sending the Refresh Token in a POST request with 'refresh-token' as the 'grant_type' in x-www-form-urlencoded format.<br>
This process allows us to obtain a new Access Token, as long as the Refresh Token remains valid. Therefore, we can consistently generate new Access Tokens as needed

![Screenshot (1796)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/654684a2-0017-4797-9711-3d9bcd4e42c7)




A third method for identification involves using 'client ID' and 'Client Secret.' Enabling 'Client authentication' for our 'wallet-client' implies that the application, rather than the user, needs to be identified. <br>
In this scenario, the application is required to send both the password and a client ID along with a client secret

![Screenshot (1797)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/7fa05b09-86d0-46fd-9d05-6eb1a45d4f3b)




f we enable "client authentication," a new tab labeled "Credentials" will be added. Within this tab, we can find the "client secret," which can be used for identification purposes

![Screenshot (1798)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/51b989c9-63a3-4f8e-8646-1bd57cd74e3c)




As mentioned earlier, the third method for identification involves using the "Client Secret," and this grant type is known as "client_credentials." <br>

🚨 An important point worth mentioning is that once "Client authentication" is enabled and a "Client Secret" is established, a mere username and password will no longer suffice for identification. <br>
The "Client Secret" becomes imperative. Consequently, we will disable "Client authentication" accordingly.


![Screenshot (1799)](https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Angular-frontEnd/assets/40896739/30310f59-efea-4558-8788-1a47ed70e568)




<h1>WE WILL BE BACK SOON</h1>







