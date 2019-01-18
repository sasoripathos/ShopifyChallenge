# ShopifyChallenge
This is my Summer 2019 Developer Intern Challenge solution. Free free to play with it. For other applicants, please do not try to directly use this project as your solution.

# GitHub Repository
https://github.com/sasoripathos/ShopifyChallenge

# Get Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
Software you need to install before building the project

```
Java 8, Maven
```

## Run Test
Clone this repository to your machine. Open a terminal/command line in the working copy (master branch) and enter following command:
```
1. cd ./shopify
2. mvn clean test
```
All test cases will be run.

## Build and Run
Clone this repository to your machine. Open a terminal/command line in the working copy (master branch) and enter following command:
```
1. cd ./shopify
2. mvn clean install
3. java -jar target/shopify.jar
```
A copy of this server side web api will start running on your machine.

## Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management

# REST API Usage
## URL prefix
When a copy of this server side web api is running on your machine.Your url prefix should be http://localhost:8080
## 1. GET /shopify/product?available=\<value\>
Get a list of all products.
### request query parameters

Parameter	| Value	| Required | Description |
--- | --- | --- | --- |
available | boolean | Not Required | when true, the list will only contains products with available inventory. |

## 2. GET /shopify/product/{name}
Get the product with given name.

## 3. POST /shopify/purchase?product=\<value\>
Purchase a product (ie. reduce the inventory by 1) if the product has avaiable inventory.

Parameter	| Value	| Required | Description |
--- | --- | --- | --- |
product | string | Required | The name of the product that use wants to purchase. |
