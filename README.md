# gpw-modules

```
./mvnw install
./mvnw spring-boot:run -pl restapi
```

# GraalVM (native-image)   

Build:   
```
./mvn --pl scaner -Pnative clean package   
```

Refresh META-INF/native-image
```
java -agentlib:native-image-agent=config-output-dir=scaner/src/main/resources/META-INF/native-image/ -jar scaner/target/app-scaner.jar
```

# todo

1. add tests for modules
2. setup docker correctly for modules
3. new module "administration" eg. spring secure + spring mvc or vaadin 
4. run on production ;)