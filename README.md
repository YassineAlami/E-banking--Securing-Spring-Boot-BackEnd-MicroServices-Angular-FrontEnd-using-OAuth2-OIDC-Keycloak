###

<p align="center">
  <a><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&pause=1000&color=F70000&random=false&width=435&lines=Overview&center=true&vCenter=true"/></a>
</p>
  
**`
The goal of this app is to develop 2 frontends, a server-side rendering and a client-side rendering, along with a Spring Boot back end using the distributed Micro Services architecture.
We'll secure all that is to secure in our app using OAuth2 with providers the likes of Keycloak, Google, Gmail, GitHub, and OpenID Connect.
As we said earlier, there will be two front ends: one using Thymeleaf and the second using Angular. This will help us explore the differences in securing server-side rendering and client-side rendering. 
For the authentication, OAuth2 will be implemented for examples of authentication via Google, GitHub, and Keycloak
`**
#

<p align="center">
  <a> <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&pause=1000&color=F70000&random=false&width=435&lines=Architecture&center=true&vCenter=true"</a>
</p>



<p align="center">  
<p><img src="https://github.com/YassineAlami/Securing-E-banking-Microservice-using-OAuth2-OIDC-with-Keycloak-Spring-Boot-BackEnd-Angular-frontEnd/assets/40896739/c8cd4b5a-5550-4ff7-b1c2-4b2d04f93e49" alt="Screenshot (1777) "></p>
</p>

<hr>

<p align="center">
<a><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&pause=1000&color=F70000&random=false&width=435&lines=Steps&center=true&vCenter=true" /></a>
</p>


<p>
  We begin by crafting the customer microservice in a limited form. Accompanied by a user-friendly Thymeleaf front end, the initial design showcases a template structure, ensuring consistency with elements like the navbar and footer.<br>
  The dynamic components within our template allow for seamless adaptation and customization
</p>

<p align="center">
  ![Screenshot (1812)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/2a21aeb9-6e3a-4fb4-bc0d-79e0aec464fc)
</p>


#

Now, our focus is on fortifying our Thymeleaf frontend. Accessing customer data necessitates authentication. Any unauthorized attempts will be thwarted. <br>
Authentication will be achieved through OAuth2, integrating with Google, GitHub, and Keycloak to ensure secure and controlled access to this feature.


#


To authenticate with Gmail, initiating the process involves creating a new project within the Google Cloud Console.
![Screenshot (1816)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/f1e3dcfc-2d16-4420-a1f7-62f83e72734a)


#


The following is the dashboard of our newly created project<br>
In this section (API and Services) we need to pieces of info which are 'Client-id' and 'Client-secret', to be able to have them we have to activate...
Under the identificatins part of the API and Services section we need to create an id of type OAuth2 and fill in some info regarding that id and that s all that is to it.<br>

![Screenshot (1816)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/3191b437-4b69-4897-9433-1281f55359dc)

#


Now we have to 'enable APIs and services' inorder to create an OAuth client Id under the 'API or Services' section

![Screenshot (1817)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/23b83a12-9926-46d4-8502-f4ca229140e4)


#

Once it is enabled, we will be able to create an "OAuth Client ID" in the 'Credintials' section
![Screenshot (1819)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/63436e7f-3d79-475d-aead-fb66f9127381)


#

We will make it 'external' so that users of outter domains could access it
![Screenshot (1820)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/be4589b7-68f0-4354-9594-51ade22ed876)


#

Before dealing with the creation of the OAuth Client ID we will have to configure the 'Consent Screen'
![Screenshot (1821)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/451cde80-a16b-4efc-a7ec-0b763e9a83bb)


#

The 'Authorized redirect URIs' part is very important, in it we are supposed to give the urls that are authorized, let's give it the url of our front-end app (Thymeleaf).<br>
Why is that? Well Because when a user will try to access our app he ll be redirect to 'Gmail', where he will enter his username and password, once the credentials are alright, he will be redirect once again to our App. which was our goal. 

![Screenshot (1822)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/d8f2d547-9acb-4f79-ac0e-ea93120537df)

#


Here we go! Here are our beloved 'Client ID' and 'Client Secret'<br>
These two sweet pieces of info are gonna be used in the 'application.properties' file of our app to regester google as our OAuth2 provider. <br>
It is notheworthy that spring security reconizes providers such as Google, Facebook, GitHub and Okta
![Screenshot (1823)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/49cfc492-d80f-4aad-adf5-fb60d99d4395)

#


Now when we tried to access our app, the access was denied. Let s see what s up

![Screenshot (1824)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/27e8c5b7-3dc4-49d8-b16a-e61d039bd872)

![Screenshot (1825)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/a13299b8-167c-487f-a765-cfc74e030e7e)


#

When we tried to authenticate via Google, we sent a request to our app 'http://localhost:8090/oauth2/authorization/google' but it was rederected [302] to 'Location'.. what is location you might ask ? 

well let's dig a bit deeper to find out

![Screenshot (1826)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/5ed99866-c0b3-4f57-b3a4-c80eecec0df3)


#

'Location' is basically saying at first we will be redirected to "https://accounts.google.com/o/oauth2/v2/auth" but once it is done then we will be rederected to the 'redirect_uri' thet has this address "http://localhost:8090/login/oauth2/code/google"
so it is THIS redirection uri that should be in gmail

![Screenshot (1828)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/6fb5a141-89f7-43e9-af34-dc91ce552abc)

#

now that we have a VALID 'redirection_uri', let s see how things look in our secured app

![Screenshot (1829)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/e7641285-6776-4c3d-884d-bdb910382365)

#


TA-DA !! We can now use Gmail to secure our app

https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/5745065d-3b89-42b1-8e3f-4200f9deb3aa


#

Adding a logout button to our navbar.<br>
notice that the access to 'Customers' requeres an authentication but the 'Home page' does not<br>

https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/5e0e29e6-a9f3-448b-b378-8d360961bff2



#


what we ve just did with google, we will now do the same thing with GitHub<br>
under "https://github.com/settings/applications/new" we have to create a new app.

![Screenshot (1832)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/0ac3c556-99d2-474e-9863-6cc9bd3f5256)


#


Once the app is created, we will be provided with the 'Client ID' and 'Client secret' and thats all we need to secure our app using githhub

![Screenshot (1835)  ](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/3efb64e9-36c6-4017-bcdb-1c9cab2b1b77)

![Screenshot (1835) ](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/196c90c2-d56d-47b4-900b-693bd471768c)

#

at the very first attempt we will be asked from github to permit authorization to the app since we will be using 'name' and some personal data
![Screenshot (1838)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/3c0e87eb-eb92-4b85-afd8-316ab692f3c5)


#


congrats! we did it again! now we have two ways to authenticate : google and github

Uploading Screenshot (1840).mp4…


#

next we want to display the name of the user who is authenticated.<br>
to do that we need the "thymeleaf-extras-springsecurity6" dependency at our pom.xml<br>
so for github, we will be showing the username, and with google the email instead<br>

![Screenshot (1841) ](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/22b0aa18-ad73-4978-b544-bc01f0455559)

![Screenshot (1841)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/ae2f7deb-5469-4772-9a9e-d91b65d59437)

#


and lastly, we will secure our app using the thirs alternative, which is Keycloak.<br>
now that keycloak is running, we will create a realm where to put our client that needs security<br>
![Screenshot (1842)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/c962d83b-dd51-46f1-ab5b-4ba7d2c76846)


#

creating the client (security-customer-client)
![Screenshot (1843)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/d9c6628a-09d5-4e26-ab90-da097a057f55)


#

creating the Roles (USER and ADMIN)
![Screenshot (1845)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/dc53c3e6-23db-48f2-b0c1-c26e0b3dab9b)

#


Creating the users (user1 and user2)
![Screenshot (1846)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/1e99ffd8-0245-4cba-9cd3-81dee4852c86)


#

assigning the roles to the user(user1->[USER] and user2->[USER,ADMIN])
![Screenshot (1849)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/a6b6c959-ae09-4033-ab96-8fdf08aa57cf)


#

now let s test the authentication with keycloak via an HTTP Client.<br>
it will provide us with an 'Access Token' and a 'Refresh Token' wich will be used ...
![Screenshot (1850)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/44d6da2d-0ffe-4982-b3d9-a0e404416e48)


<hr>

the third way to secure our authentication is all set, now we can choose between Keycloak, Google and GitHub whenever we want to authenticate

https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/497034a4-27fe-4c07-948b-0c877f954641

#

thanks to Keycloak it is now possible to regester new users on our app. 

https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/92f34ab7-f425-43b5-8b2e-5d4c0f424ef8

#


up to now, once a user is loged in, he can access basically any feature of the app, which is not cool.<br>
we want now to restrict the access to the app's functionalities. For example users with the Role USER do not have the right to access some specific features.<br>
to do that, we first have to add the Roles to the JWT.

https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/839c4c61-57a5-4943-8db3-5b8b64bd5031

#

And just like that, we will from now on have the roles in our Token (idToken)<br>
these roles are located in "real_maccess" but Spring Security doesn t know that our Roles are there. therefor we have to create a 'Role Mapper' to indicate to Spring Security where exactly he should look for the roles<br>
once it is done, Spring Security will concider our Roles as 'Authorities' which is for him the roles.<br>

![Screenshot (1854)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/4937e3be-c810-47cd-ae5f-9229df6c3b9d)

#

here are the Roles that spring security take into account before the "Role Mapping" operation

![Screenshot (1856)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/f1a9eaea-7eb5-4c03-ab8d-f04d65114ba6)

#


And here are the Roles that Spring Security take into account after the "Role Mapping" operation.<br>
he now recognizes the roles that were created with Keycloak

![Screenshot (1857)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/aff2b276-01bd-4c98-97c8-b7dfbad9bc4d)

#

the following is a test of accessing the Customer section, which requeres an ADMIN Role.<br>
the first attempt is with the user "user1" who has only the role USER.<br>
the second attempt is with the user "user2" who has both roles ADMIN and USER.<br>



https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/11980ce8-67ab-42e2-aa36-fd15c6111b9d


#

A small but not too small detail is the default role assigned to a newly regestred user. let s assigne the USER Role to them

![Screenshot (1859)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/ac8f1759-a0b0-4ab6-9545-46050306f2dc)


#


And here we ve added some password polecies to make it more secure.<br>
we can say now that our thymeleaf front end is secured.<br>
the next step now is to create and secure the back end micro sevice "Inventory-service"

![Screenshot (1860)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/c058b8d8-326d-40f6-b5ab-80fbf45ec24b)

#

After creating the Inventory micro serice, we will try now to secure it.<br>
lets simulate an authentication with the help of a Http Client<be>

a successful authenticatin will proved us with an access token, which will be crucial when trying to access the inventory micro service

![Screenshot (1861)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/a6a90b1d-7726-41a9-b4d6-800107d18ed2)


#


this is what an attempt to access the micro service without providing the header "Authorization: Bearer" that utilizes the "access_token"<br>
401 !! he is telling us that we re not autneticated, simplly beacuse indeed we are not.
![Screenshot (1862)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/ed6b3b6d-b0d3-482f-9bf2-27f2a9420a3a)

#




but when we provide a valide access token we can then access this feature peacfully.

![Screenshot (1863)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/24926e09-5699-4f84-a66a-04ba388b1f89)


#

Now lets make the back end comunicate with the fornt end. we want to send the Products from the inventory micro service to our thymeleaf app, along with the JWT inorder for its request to be accepted<br><br>

What happens hear is that when a user demands to see the products, our thymeleaf app takes it and send a request to inventory service (which is the micro service that has the products) and this request CONTAINS the JWT which is mendatory to access a micro servuce that is protected ('Bearer Only')<br><br>
when our thymeleaf app has a 'Public Client' security mode, which means that when a user attempts to access some featchers that he doesn t have the required authority he will authomatically be redirected to Keycleak and that s Keycloak who will give him the authentication form, one he is authenticated, he will be redirected again to the featcher he wanted to access at the first place (before authentication)<br><br>
once the user gets redirected to the front app again, the app demands the JWT from Keycloak and when keycloak gives it to it, it uses it in its secutity context


https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/effb200a-678b-4e7a-ac9d-c09b90e00134


#


now let s make the access to the Products Section requier an ADMIN Role, this time wi will handle this problem from the back end <br>
it sure look exactly the same from before, but it is not. this time the back end ....

https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/6ee0947d-ccfe-481e-95b8-4900536568a0

#


our next goal is to create another frontend for our app but this time it will be a client-side rendering (CSR) one with Angular.<br>
have a first glance at result of the initial effort

https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/ae4c24d4-6248-4284-8b3f-af07a854891f

#

what we are going to do now is that we are going to send an HTTP Request to inventory service in oder to get the list of the products<br>
now we have to contact the inventory micro service cuz it has the needed products.<br>
this is what we will get if we try to access it without authentication (401 ERROR), cuz this service is secured via oAuth2.<br>
to deal with that.. we only have one solution and that is : to authenticate. <br>
withh angular, the authentication could be of one of 2 types: backend chanle or front end chanel <br>
front end channel: with thymeleaf we ve used front end channel.. means when tthe user attempts to access some resource that he doesn t have the required authority to do so, he will be redirected to Keycloak and it s Keycloak who will demand the username and password.<br>
backend channel: we create a form ourselves and when the user tries to acces some recource that requiers authority, he will be redirected to the form we created, once the user clicks the login button, a request to get the TokenId will be sent along with it, and keycloak will send this token and it will be stocked in local storage


![Screenshot (1871)](https://github.com/YassineAlami/E-Commerce-App-Securing-Angular-And-Thymeleaf-Fronts-Using-OAuth2-OIDC-Keycloak-Google-GitHub../assets/40896739/2354f5d1-6447-48fa-a9ae-6579223a5f8e)

#


now we have to secure our angular front end using keycloak, for that we will need keycloak adapter








