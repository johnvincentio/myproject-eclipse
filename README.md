
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

* Root directory: `/Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku/springboot-heroku`

Select Finish

Maven Project is Imported.

### Code

`SpringbootHerokuApplication.java`

```
package io.johnvincent.springbootheroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class SpringbootHerokuApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHerokuApplication.class, args);
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
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku/springboot-heroku

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
cp target/springboot-heroku-0.0.1-SNAPSHOT.jar ../springboot-heroku.jar

echo "Completed"
```

### Build Jar file

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku/springboot-heroku

./create-package
```

### Execute Jar file

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku

java -jar springboot-heroku.jar
```

### Test

```
http://localhost:9517
```

# Heroku

Login to Heroku

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku

heroku login
```

## Create Heroku App

Do this in the directory containing the `pom.xml`

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku

heroku create johnvincentio-springboot
```

```
https://johnvincentio-springboot.herokuapp.com/ | https://git.heroku.com/johnvincentio-springboot.git
```

* Application url: `https://johnvincentio-springboot.herokuapp.com/`
* Heroku git repository: `https://git.heroku.com/johnvincentio-springboot.git`

### Procfile

Create `/Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku/Procfile`

```
web: java -jar springboot-heroku.jar
```

### Deploy the Code

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku

git push heroku master
```

Error

```
remote:  !     No default language could be detected for this app.
remote: 			HINT: This occurs when Heroku cannot detect the buildpack to use for this application automatically.
remote: 			See https://devcenter.heroku.com/articles/buildpacks
```

```
https://devcenter.heroku.com/articles/buildpacks
```

Try

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku

heroku buildpacks:set heroku/java
```

Stil failed, remove buildpacks

```
heroku buildpacks:remove heroku/java
```

Try this

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku

heroku create jv-heroku-demo-stackabuse --no-remote

cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku/springboot-heroku

mvn clean package

heroku deploy:jar target/heroku-demo.0.0.1-SNAPSHOT.jar --app heroku-demo-stackabuse
```



Heroku Deploy Plugin
If we want to deploy our application directly without using a Git repository, we can do it using the heroku-cli-deploy plugin. Let's begin by installing it:

$ heroku plugins:install heroku-cli-deploy



already have the jar

```
cd /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku

heroku deploy:jar springboot-heroku.jar --app jv-heroku-demo-stackabuse
```

test

```
https://jv-heroku-demo-stackabuse.herokuapp.com/
```


jv-heroku


```
cd /Users/jv/Desktop/MyDevelopment/github/projects/jv-heroku

heroku create johnvincentio-jv-heroku
```

https://johnvincentio-jv-heroku.herokuapp.com/ | https://git.heroku.com/johnvincentio-jv-heroku.git

git push heroku master


https://johnvincentio-jv-heroku.herokuapp.com/

WORKS!!!



# TRY THIS

create repo springboot-heroku

```
/Users/jv/Desktop/MyDevelopment/github/projects
create-repo springboot-heroku
```

remove all from springboot-heroku except `.git`

unzip the zipfile.

```
cp -r springboot-heroku/* /Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku
```

ensure all in `/Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku`

start eclipse from `/Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku`

import existing mavan project

root directory: `/Users/jv/Desktop/MyDevelopment/github/projects/springboot-heroku`



# TRY







# END
