
# Deploy SpringBoot App to Heroku

Create github repository `myproject-eclipse`

[Github repository](git@github.com:johnvincentio/myproject-eclipse.git)

## Local Development

Create local project

```
cd /Users/jv/Desktop/MyDevelopment/github/projects-heroku
create-repo myproject-eclipse
```

Project directory

```
/Users/jv/Desktop/MyDevelopment/github/projects-heroku/myproject/myproject-eclipse
```

### Create SpringBoot App

[Spring Initializr](https://start.spring.io/)

* Group: io.johnvincent
* Artifact: myproject
* Packaging: Jar
* Java: 8

* Dependency: Spring Web

Downloads a zip file to `/Users/jv/Downloads`

Unzip the file.

Copy `myproject` to `/Users/jv/Desktop/MyDevelopment/github/projects-heroku/myproject/myproject-eclipse`

### Import into Eclipse

Start Eclipse-jee from `/Users/jv/Desktop/MyDevelopment/github/projects-heroku/myproject/myproject-eclipse`

Open Eclipse at `myproject`

* File, Import
* Maven, Existing Maven Projects

Maven Projects

* Root directory: `/Users/jv/Desktop/MyDevelopment/github/projects-heroku/myproject/myproject-eclipse`

Select Finish

Maven Project is Imported.

### Code

`MyprojectApplication.java`

```
package io.johnvincent.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class MyprojectApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

}
```

`application.properties`

```
server.port=9517
```

Commit to repo

```
git add .
git commit -m "init"
git push
```

### Execute

```
cd /Users/jv/Desktop/MyDevelopment/github/projects-heroku/myproject/myproject-eclipse/myproject

./mvnw spring-boot:run
```

### Test

```
http://localhost:9517
```

### Create-package script

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku/springboot-heroku
```

`create-package`

```
#!/bin/sh
#
# script to create Jar
#
#
echo "Maven clean and make the package"
./mvnw clean package

echo "Save Jar"
cp target/myproject-0.0.1-SNAPSHOT.jar ../myproject.jar

echo "Completed"
```

### Build Jar file

```
/Users/jv/Desktop/MyDevelopment/github/projects-heroku/myproject/myproject-eclipse/myproject

./create-package
```

### Execute Jar file

```
cd /Users/jv/Desktop/MyDevelopment/github/projects-heroku/myproject/myproject-eclipse

java -jar myproject.jar
```

### Test

```
http://localhost:9517
```
