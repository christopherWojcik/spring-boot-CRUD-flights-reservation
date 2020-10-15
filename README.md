
# CRUD Spring Boot project
[![CCO](https://img.shields.io/github/repo-size/christopherWojcik/spring-boot-CRUD-flights-reservation?style=plastic)](https://img.shields.io/github/repo-size/christopherWojcik/spring-boot-CRUD-flights-reservation?style=plastic) 
![GitHub last commit](https://img.shields.io/github/last-commit/christopherWojcik/spring-boot-CRUD-flights-reservation?style=plastic)

Simple CRUD application - flights reservation.<br>

Project has been made during SDA Course - Java from Scratch :)

``` java 
public boolean isGoodCandidate(String name){
    return checkPassion(name) && checkHardWorking(name) && checkBestCompanyInvestment(name);
}

private boolean checkBestCompanyInvestment(String name) {
    return name.equals("Krzysztof Wójcik");
}

private boolean checkHardWorking(String name) {
    return name.equals("Krzysztof Wójcik");
}

private boolean checkPassion(String name) {
    return name.equals("Krzysztof Wójcik");
}
```
As a UI layer, can be connected Angular project - link: [<code>CRUD-UI-flights-reservation</code>][UI-project]
Project use database: MySQL.  

## Swagger 2.0 documentation
[<code>http:\/\/localhost:8080\/v2\/api-docs</code>][swagger-docs-url]
</br>

## Swagger-UI:
[<code>http:\/\/localhost:8080\/swagger-ui.html</code>][swagger-ui-url]

## Future development :)
What can be done? Almost everything :) <br>
Here are my few proposals: <br>

| Number | Description | Status |
| :----: | :--------- | :----: |
| 0 | Add tests :)  |  ***Not Done*** |
| 1 | Add Swagger for project documentation |  ***Done*** |
| 2 | Implement Passenger API and logic |  ***Not Done*** |
| 3 | Spring security e.g. JWT authentication, SessionTimeout etc. |  ***Not Done*** |
| 4 | Spring Profiles |  ***Not Done*** |
| 5 | Docker |  ***Not Done*** |
| 6 | Cashing |  ***Not Done*** |
| 7 | Change or add DB - e.g. MongoDB |  ***Not Done*** |



[swagger-docs-url]: http://localhost:8080/v2/api-docs
[swagger-ui-url]: http://localhost:8080/swagger-ui.html
[UI-project]: https://github.com/christopherWojcik/UI-CRUD-flights-reservation

## License
[![CC0](https://licensebuttons.net/p/zero/1.0/88x31.png)](https://creativecommons.org/publicdomain/zero/1.0/)