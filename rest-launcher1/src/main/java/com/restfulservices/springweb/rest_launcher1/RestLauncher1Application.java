package com.restfulservices.springweb.rest_launcher1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
In distributed enterprise applications one application interact with other application 
>> Initially we have EJB's(Enterprise JavaBeans) where one Java application can interact with other Java application.
EJBs (Enterprise JavaBeans) are like special Java classes that run on a Java EE application server (e.g., JBoss, WebLogic, GlassFish). 
They are mainly used for business logic in enterprise applications.
			
			Think of an EJB as a smart assistant in a company:
			 • You (the client) give a request (e.g., “Process this order”).
			 • The assistant (EJB) does the work securely and efficiently.
			 • You get the final result without worrying about security, transactions, or performance.
			
				EJBs enable applications to communicate securely and efficiently. The best method depends on your use case:
				 • Use Remote EJBs(RMI/JNDI) if both applications are in Java EE.
				 • Use MDB (JMS) for asynchronous processing.
				 • Use REST/SOAP APIs for cross-platform integration.
				
			How the Communication Works
				 1. Application 1 (Server 1) hosts the EJB.
				 2. Application 2 (Server 2) does a JNDI lookup to find the EJB and will get EJB reference.
				 3. A network call happens using RMI (Remote Method Invocation) using that EJB reference.
				 4. The method runs on Server 1, and the result is returned to Server 2.
				
			Alternative: Use Message-Driven Beans (MDB)
			If you need asynchronous communication, use JMS (Java Message Service) with MDBs.
			 • Application 1 sends a message to a JMS Queue.
			 • Application 2 listens for the message and processes it.
			 

>> EEJB communication is primarily designed for Java applications to achieve inter operability, developers formed an organization 
    called WSI(Web Services Interoperability)
	
	They came up with B.P.1.0 specifications for inter operability irrespective of the language on which the applications are build. 
	Java also gave their own specification following B.P.1.0 known as JAX-RPC
	
	After that B.P.1.1 came based on that Java gave JAX-WS specification followed by JAX-WS based on further specifications form WSI

	JAX(Java API for XML)=
	 1. WS-I BP provides the rules for interoperable web services.
	 2. JAX-RPC & JAX-WS are Java’s implementations for creating SOAP-based web services, following WS-I BP guidelines.
	 3. Oracle WebLogic & Apache Axis are Java-based web service platforms that implement JAX-RPC & JAX-WS, ensuring WS-I BP 
	

SOAP Based Applications:
	If we develop applications based on WSBP (Web service Basic Profile) we called it as SOAP based applications.
	
	The data that is transferred between the applications is in XML syntax for SOAP based application 
	
	JAXB (Java Architecture for XML Binding) is a Java API that allows converting Java objects to XML and XML to Java objects. 
	It simplifies working with XML in Java applications by using annotations to define XML mappings. This is also called as marshalling and unmarshalling.
	
	The documentation of an API should be defined in WSDL(Web Service Description Language) provides
		What a web service does (operations)
		 How to call the service (request/response format)
		 Where the service is located (endpoint URL)
		
	UDDI (Universal Description, Discovery, and Integration) is a registry for web services that helps businesses publish, discover, 
	and integrate web services over the internet. It acts like a “phone directory” for web services, where companies can list their services and clients can find them.
	Usually UDDI consists of WSDL. Consumer will reach to UDDI first and get the WSDL info of the producer endpoint
	
	 1. UDDI acts as a registry (or directory) for web services 📖
	 • It stores metadata about services, including the WSDL location of a web service.
	 2. Consumers query UDDI to discover services 🔍
	 • They search based on service name, category, or keywords.
	 • If found, UDDI provides the WSDL URL of the producer (service provider).
	 3. Consumers retrieve the WSDL and invoke the web service 
	 • The consumer downloads the WSDL (which describes the service’s operations and endpoint).
	 • Using SOAP, JAX-WS, or another client, they send requests to the producer’s endpoint.
	
		
	
>> Later Roy Fielding one of the main contributors to the HTTP/1.1 specification, suggested that the data transfer should be in much simpler format as JSON object
 and introduced REST (Representational State Transfer) in his doctoral thesis at the University of California, Irvine.

>> Principles of RESTful Services
			
			REST (**Representational State Transfer**) is an **architectural style** used for designing scalable and stateless web services. 
			RESTful services follow a set of well-defined principles to ensure efficiency, flexibility, and performance.
			
			## **1. Client-Server Architecture**
			✅ **Separation of Concerns (SoC):** The client and server should be independent, meaning changes in one should not affect the other.
			- The **client** is responsible for the **UI & user experience**.
			- The **server** handles **business logic, data processing, and storage**.
			**Example:** A mobile app (client) requests data from a web service (server) without needing to know the server's internal workings.
			```http
			GET /users/123 HTTP/1.1
			Host: api.example.com
			```
			---
			## **2. Statelessness**
			✅ **Each request from the client to the server must contain all necessary information.**
			- The server does **not** store client session data between requests.
			- Each request is **independent**, meaning no reliance on previous interactions.
			**Example:** Every API request must include authentication tokens since the server does not remember past requests.
			```http
			GET /orders/123 HTTP/1.1
			Authorization: Bearer abc123
			``'
			---
			## **3. Cacheability**
			✅ **Responses should be cacheable to improve performance and scalability.**
			- Some responses can be **stored (cached)** by clients or intermediaries (e.g., browsers, CDNs).
			- APIs should include **cache-control headers** to define how long responses remain valid.
			**Example:**
			```http
			Cache-Control: max-age=3600  # Cache response for 1 hour
			```
			---
			## **4. Uniform Interface (Consistent API Design)**
			✅ **APIs should follow a standard design for easy use and integration.**
			
			### **Resource-Based URLs (Use Nouns, Not Verbs)**
			✔️ `/users` (✅ Good)  
			❌ `/getUsers` (❌ Bad)  
			
			### **Standard HTTP Methods**
			- `GET` → Retrieve data
			- `POST` → Create a resource
			- `PUT` → Update a resource
			- `DELETE` → Remove a resource
			
			### **Standard HTTP Status Codes**
			- `200 OK` → Success
			- `201 Created` → Resource successfully created
			- `400 Bad Request` → Client-side error
			- `404 Not Found` → Resource does not exist
			---
			## **5. Layered System (Multiple Layers for Scalability & Security)**
			✅ **The API architecture should support multiple layers between the client and server.**
			
			- Intermediary layers can include **load balancers, authentication servers, proxies, and cache layers**.
			- The client should **not** need to know if it’s communicating with the main server or an intermediary.
			
			**Example:** A **CDN (Content Delivery Network)** sits between the client and the actual API server, caching responses to reduce server load.
			---
			## **6. Code-on-Demand (Optional)**
			✅ **Allows sending executable code (e.g., JavaScript, applets) to clients to extend their functionality.**
			- This principle is **optional** and rarely used in modern APIs.
			- Example: A web API sends JavaScript code that a browser executes dynamically.
			---
			## **Conclusion**
			### **Mandatory REST Principles:**
			✔️ Client-Server Separation  
			✔️ Statelessness  
			✔️ Cacheability  
			✔️ Uniform Interface  
			✔️ Layered System  
			
			### **Optional Principle:**
			✔️ Code-on-Demand (rarely used)  

Following these principles ensures that RESTful services are **scalable, efficient, and easy to maintain**, 
making them ideal for web and microservices-based applications. 🚀

>> Base on the principles of RESTful services Java provided an API called JAX-RS
             JAX-RS (Java API for RESTful Web Services)
>> Implementations of JAX-RS
   Jersey:  General JAX-RS usage, GlassFish, Payara, Spring Boot
  RESTEasy : JBoss/WildFly applications
  Apache CXF:  Applications requiring both REST and SOAP
  Spring Boot + Jersey/RESTEasy:  JAX-RS integration with Spring Boot

>> Spring Boot application internally uses Jaxon API to convert Java Object to JASON and vice-versa
*/

/*
 * 	To make an API enable for rest architecture we use two methods 
 * 1) Use controller annotation on @Contoller class and @ResponseBody on mapping methods
 * 
 * 2) Use @RestController on controller class itself
 */
@SpringBootApplication
public class RestLauncher1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestLauncher1Application.class, args);
	}

}
