# Imburse Challenge

## Requirements
### To run directly from the project 
  * Java
  * Maven
    
### To run with docker-compose   
  * Docker

### Features developed

#### bug-catcher fwk

  * RestAssured Wrapper that allows some abstraction around the api requests
  * Decryptor is a helper that encrypt and decrypt configuration data. This allows me to have sensitive 
  data with confidence
  * SystemEnvWrapper is another helper that allows me to handle environment variables. 
  * Unit tests developed
  
#### imburse-qa

  * Reporting
  * Cucumber
  * Configuration json file
  * Possibility to run through docker image
  * 33 automated tests
    

## Getting Started
    
  * I divided the work in two parts: the fwk (bug-catcher) that deals with the wrapper around the RestAssured, 
    and imburse-qa, that uses bug-catcher as a dependency and it's where the tests are. In order to install the fwk you have to 
    go to the build directory and run the following command:
  `mvn install:install-file -Dfile=bug-catcher-1.0.0.jar -DgroupId=qae -DartifactId=bug-catcher -Dversion=1.0.0 -Dpackaging=jar`
    
  * Before you can run, you should define the ENCRYPTION_KEY environment variable. This is MANDATORY. The value of the ENCRYPTION_KEY environment variable will be supplied by me on the email.
   
  * The authentication bearer token should be defined on the config.json, replacing the value on
  `accessToken`. But this value will be encrypted, so you should encrypt the value. To encrypt it
  you can use the jar file inside of the decryptor root folder. There you also will find the instructions on a 
  README.md file. 
   
   You can also find the projects on the following url:
  * [bug-catcher](https://github.com/jonacarvalheiro/bug-catcher)
  * [imburse-qa](https://github.com/jonacarvalheiro/imburse-qa)
  

## 1 - Tests
     
### 1.1 - Tags

#### 1.1.1 @OrderCreation 
  * Order creation tests (9 tests)
#### 1.1.2 @InstructionCreation  
  * Instruction creation tests (24 tests)
      
### 1.2 - Execution
   You can run tests in 3 different ways:
	
  * Docker-compose
  * Maven;
	
#### 1.2.1 - Feature file (Intellij IDEA)
  * Right-click on the feature you want to run and click run.

#### 1.2.2 - Docker-compose
  * Please make sure you have the Docker Image already build (see 3)
  * Define the tag you want to run, and add it to the TAGS in env-file.env.
  * Define the ENCRYPTION_KEY on the env-file.env.
  * Run the command docker-compose up
  
### 1.2.3 - Maven
  * Open the terminal in the project directory;
  * Run the following command to run a specific tag:
		 `mvn clean test -Dcucumber.filter.tags="@ExampleTag"`
  * Run the following command to run all the tests:
  `mvn clean test`


## 2 - Reporting
  * The report will be only available after the run through command line (`mvn clean test -Dcucumber.filter.tags="@ExampleTag"`).
  This report will be on target/cucumber-html-reports, and you can open e.g. target/cucumber-report-html/cucumber-html-reports/overview-features.html file
  on the browser.
  
  
## 3 - Build Docker Image

  * Inside the build folder you will find the following files:
        - imburse-qa.tar.gz
        - docker-compose.yml
        - Dockerfile
        - env-file.env
        - Makefile
        - bug-catcher-1.0.0.jar
  * If you have can use Makefile you can run `make` and all the process will be made automatically.
Case not, to build the docker image by running the following command:
         `docker build -t imburse-qa-image:0.1.0 .`
        
        
## 4 - To Do
    
  * Integration with Report Portal
  * Automate the docker image build on the CI/CD 
  * Increase the automation tests suite
  * Improve the Page Object pattern on the imburse-qa
  * Possibility to delete orders and instructions in order to reuse the references
  * Integration with Gatling for load/performance tests
  * Test Parallelization 
  * Git tag
