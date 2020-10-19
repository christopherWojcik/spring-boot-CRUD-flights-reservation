
# CRUD Spring Boot project
[![CCO](https://img.shields.io/github/repo-size/christopherWojcik/spring-boot-CRUD-flights-reservation?style=plastic)](https://img.shields.io/github/repo-size/christopherWojcik/spring-boot-CRUD-flights-reservation?style=plastic) 
![GitHub last commit](https://img.shields.io/github/last-commit/christopherWojcik/spring-boot-CRUD-flights-reservation?style=plastic)

Simple CRUD application - flights reservation.<br>

*CREATE -* add aicraft to DB<br>
*READ -* get all aircrafts, get aircraft <code>List</code> by parameters (capacity and operable status: active - true, inactive - false), get flight <code>List</code> by parameters (airport of departure and also destination)<br>
*UPDATE -* update aircraft of given id<br>
*DELETE -* delete aircraft<br>

Project has been made during SDA Course - Java from Scratch :) <br>
Data are generated automatically from csv file. Additionally in file: <code>application.properties</code>, You can set up generate flag on true or false. Data are not related with the real ones. Only for educational purposes.
<br>
As a UI layer, can be connected Angular project - link: [<code>CRUD-UI-flights-reservation</code>][UI-project]
Project uses MySQL database.  

## Swagger 2.0 documentation
In Chrome browser - install JsonViewer for better reading :) 
[<code>http://localhost:8080/documentation/v2/api-docs</code>][swagger-docs-url]
</br>

## Swagger-UI:
[<code>http://localhost:8080/documentation/swagger-ui.html</code>][swagger-ui-url]

## Future development :)
What can be done? Almost everything :) <br>
Here are my suggestions for improvements: <br>

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

and also remember :)
<br>
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

[swagger-docs-url]: http://localhost:8080/documentation/v2/api-docs
[swagger-ui-url]: http://localhost:8080/documentation/swagger-ui.html
[UI-project]: https://github.com/christopherWojcik/UI-CRUD-flights-reservation

## License
[![CC0](https://licensebuttons.net/p/zero/1.0/88x31.png)](https://creativecommons.org/publicdomain/zero/1.0/)