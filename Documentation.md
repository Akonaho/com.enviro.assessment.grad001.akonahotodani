## Getting Started with
# Enviro-365 :: Waste Sorting Application

### Reference Documentation
This is a brief introduction to the structure and funtionality of this application.

* This application assumes there will be a database of all types of WasteItems.
I took the liberty to create such an entity for the purpose of this assessment. Users can perform CRUD operations on this entity.
* The main functionalities of this application are cerntered around the classes:<br /> 
* ####  WasteCategory<br/>
* ####  DisposalGuidelines<br/>
* ####  RecyclingTips <br/>
* All CRUD operations can be performed on these classes
* I created DTO classes to assist with communication between the frontend and the backend application

### API URIs
The following APIs can be used to access the Application's database:<br />
#### [ http://localhost:8080 ] - being your host address

* http://localhost:8080/waste_items/item - GET :: Retrieves a specified waste item
* http://localhost:8080/waste_items/items - POST :: Retrieves all waste items in the database
* http://localhost:8080/waste_items/RemoveItem - POST :: Safely delete a specified waste item
* http://localhost:8080/waste_items/updateItem - POST :: Updates a specified waste item
* http://localhost:8080/waste_items/addItem - POST :: Creates a new waste item under the given category
<br/><br/>

* http://localhost:8080/categories/categories - GET :: Retrieves all waste categories on the database
* http://localhost:8080/categories/categoryByItem - POST ::  Retrieves the waste category a specified waste item is in
* http://localhost:8080/categories/categoryByID - POST :: Retrieves the waste category a specified by id
* http://localhost:8080/categories/categoryByName - POST :: Retrieves the waste category a specified by name
* http://localhost:8080/categories/RemoveCategory - POST :: Safely deletes the provided waste category
* http://localhost:8080/categories/updateCategory - POST :: Updates details of a specified waste category
* http://localhost:8080/categories/addCategoryPOST - POST :: Creates a new waste category with the given details
  <br/><br/>

* http://localhost:8080/tips/tips - GET :: Retrieves all recycling tips on the database
* http://localhost:8080/tips/tipByItem - POST ::  Retrieves all the recycling tips for a specified waste item
* http://localhost:8080/tips/tipsByMaterial - POST ::  Retrieves all the recycling tips for a specified waste item material
* http://localhost:8080/tips/RemoveTip - POST ::  Safely deletes the specified recycling tip
* http://localhost:8080/tips/updateTip - POST ::  Updates details of a specified recycling tip
* http://localhost:8080/tips/addTip - POST ::  Creates a new recycling tip for the given item/material
  <br/><br/>

* http://localhost:8080/guidelines/guidelines - GET :: Retrieves all disposal guidelines on the database
* http://localhost:8080/guidelines/guidelineByItem - POST ::  Retrieves all the disposal guidelines for a specified waste item
* http://localhost:8080/guidelines/guidelinesByCategory - POST ::  Retrieves all the disposal guidelines for a specified waste category
* http://localhost:8080/guidelines/guidelinesByMaterial - POST ::  Retrieves all the disposal guidelines for a specified waste item material
* http://localhost:8080/guidelines/RemoveGuideline - POST ::  Safely deletes the specified disposal guideline
* http://localhost:8080/guidelines/updateGuideline - POST ::  Updates details of a specified disposal guideline
* http://localhost:8080/guidelines/addGuideline - POST ::  Creates a new disposal guideline for the given item/material/category
<br/><br/>
<br/><br/>
<br/><br/>
<br/><br/>
<br/><br/>
<br/><br/>
<br/><br/>
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#io.validation)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)




