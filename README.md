My proposition to solve the United Remote backend challenge: https://github.com/hiddenfounders/backend-coding-challenge

### Purpose
Create a REST API that list:
- Languages used by the 100 trending public repos on GitHub
- For Every language, compute the following attributes: 
    - Number of repos using this language
    - The list of repos using the language
    - Framework popularity over the 100 repos

### Demo:
Get all languages details  
localhost:8083/languages  
![localhost:8083/languages](https://github.com/YoussefOweis/backend-united-remote-challenge/blob/master/images/getAllLanguagesDetails.PNG?raw=true) 


Get JavaScript language details  
localhost:8083/languages/JavaScript  
![localhost:8083/languages/JavaScript](https://github.com/YoussefOweis/backend-united-remote-challenge/blob/master/images/getJavaScriptDetails.PNG?raw=true) 

### Requirement
-	Install [Java 8]( https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
-	Install [Maven]( https://maven.apache.org/download.cgi)
-	Clone this repository 
-	Navigate to the project root and execute: `mvn spring-boot:run`

### Architecture
A simple REST API, where I used the Github API to retrieve the most starred repository (only repository created in the last 30 days are used), then get statistics for each language: repository using this language, number of repository using this language and the framework popularity (which is presented with the rank value).

The architecture used for this project is a MVC architecture where the Controller is represented by the LanguageDetailsController class and uses LanguageDetailsService class to process the data. 

### Used Technologies
-	Java 8
-	Spring (Boot + Web)
-	Maven

### Troubleshooting
In case the port 8083 is already used go to the application.properties file located in the resource folder and specify an available port 

I used my own Token, in case you faced troubles with my token you can change it in Utils.GithubApiClient line 18 (OAUTH_TOKEN) 
### TODO
- [ ] Improve code quality

### Author
Oweis Youssef, currently student at OFPPT, but soon a backend developer
