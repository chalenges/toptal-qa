# Imburse Challenge

## Requirements
### To run directly from the project 
  * Java
  * Maven
    
### To run with docker-compose   
  * Docker

## Getting Started
    
   I divided the work in two parts: the fwk (bug-catcher) that deals with the wrapper around the RestAssured, 
    and imburse-qa, that uses bug-catcher as a dependency and it's where the tests are. In order to install the fwk you have to 
    go to the build directory and run the following command:
  `mvn install:install-file -Dfile=bug-catcher-1.0.0.jar -DgroupId=qae -DartifactId=bug-catcher -Dversion=1.0.0 -Dpackaging=jar`
    
   
   You can also find the projects on the following url:
  * [bug-catcher](https://github.com/jonacarvalheiro/bug-catcher)
  * [imburse-qa](https://github.com/jonacarvalheiro/imburse-qa)

## 1 - Tests
     
### 1.1 - Tags

#### 1.1.1 @OrderCreation 
  * Order creation tests
#### 1.1.2 @InstructionCreation  
  * Instruction creation tests 
      
### 1.2 - Execution
   You can run tests in 3 different ways:
	
  * Docker-compose
  * Maven;
	
#### 1.2.1 - Feature file (Intellij IDEA)
  * Right-click on the feature you want to run and click run.

#### 1.2.2 - Docker-compose
  * Please make sure you have the Docker Image already build (see 5)
  * Define the tag you want to run, and add it to the CUCUMBER_OPTIONS in env-file.env.
  * Go to selenium-grid folder and run docker-compose up -d to raise Selenium Grid
  * Run the command docker-compose up -d
  
### 1.2.3 - Maven
  * Open the terminal in the project directory;
  * Run the following command:
		 `mvn clean test -Dcucumber.options="--tags @ExampleTag"`

## 2 - Build Docker Image

  * Inside the build folder you will find 5 files:
        - imburse-qa.tar.gz
        - docker-compose.yml
        - Dockerfile
        - env-file.env
        - bug-catcher-1.0.0.jar
  * To build the docker image by running the following command:
         `docker build -t imburse-qa-image .`
        
        
## 3 - To Do
    
  * Integration with Report Portal
  * Automate the docker image build on the CI/CD 
  * Increase the automation tests suite
  * Improve the Page Object pattern on the imburse-qa
  * Possibility to delete orders and instructions in order to reuse the references
  * Integration with Gatling for load/performance tests
  * Test Parallelization 
  * Git tag
