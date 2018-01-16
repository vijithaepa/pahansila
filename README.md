##PAHANSILA

**Pre-requisite**
- JDK 8
- MySQL 5.6
- Install node package manager (npm). [help](https://treehouse.github.io/installation-guides/mac/node-mac.html)
- Install Gulp. [help](https://peidongwang.wordpress.com/2016/07/02/how-to-install-gulp-and-bower-globally-on-mac-osx/)
    - npm install gulp -g
- install protractor. [help](http://www.protractortest.org)
  - npm install -g protractor
- ```
    Optional (if required more control over JS testing) 
    npm install -g karma 
  ``` 
**Build instructions**
* execute following commands to install(dependencies), build and run the front-end
  * npm install [--production]
  * gulp
  * execute garadle task "build"
  * Runs/debug as Springboot application
      * Main Class : org.ps.MpsApplication.java
      * Use classpath of module: <project_name>_main
      
###Security
    - nodemon server.js 
    - http-server
