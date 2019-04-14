# **Getting Started**
Github: `https://github.com/tommi2510/_8F.git`

## **Spring Boot Rest API**

1. Import the project with your favorite IDE and with Maven
2. Run the app
3. Make request to localhost:8080/api

# **API endpoints**

### **User**

* ### Get User
    Returns json data about user

    * #### Url
        /users/:id

    * #### Method:
        `GET`

    * #### URL Params
        **Required**:
        `id=[Long]`

    * #### Data Params
        None

    * #### Success Response:
        * **Code**: 200  
        **Content**: `{id: 6, firstName: "Leroy", lastName: "Jenkings", email: "leroyJenk@gmail.com"}`

        * #### Sample Call:
          ```javascript
          $.ajax({
            url: "/users/6",
            dataType: "json",
            type : "GET",
            success : function(r) {
              console.log(r);
            }
          });
          ```
* ### Create User
    Returns json data about user

    * #### Url
        /users

    * #### Method:
         `POST`

    * #### URL Params
        None

    * #### Data Params
        **Required**:

        `firstName: "Leroy"`
        `lastName: "Jenkings"`
        `email: "leroyJenk@gmail.com`

    * #### Success Response:
        * **Code**: 200  
        **Content**: `{id: 6, firstName: "Leroy", lastName: "Jenkings", email: "leroyJenk@gmail.com"}`

    * #### Sample Call:
          ```javascript
          $.ajax({
            url: "/users/6",
            dataType: "json",
            type : "GET",
            success : function(r) {
              console.log(r);
            }
          });
          ```

## Flight

* ### Get Flight
    Returns json data about flight

    * #### Url
        /flights/:id

    * #### Method:
        `GET`

    * #### URL Params
        `id=[Long]`

    * #### Data Params
        None

    * #### Success Response:
        * **Code**: 200  
            ###### **Content**: `{id: 6, flightNo: "Leroy", scheduledTime: "Jenkings", departure: "Reykjavík", arrival: "Akureyri", seats: 76, seatsAvailable: 43, price: 15000}`

    * #### Sample Call:
      ```javascript
      $.ajax({
        url: "/flights/6",
        dataType: "json",
        type : "GET",
        success : function(r) {
          console.log(r);
        }
      });
      ```
* #### Search flights
    Returns json data about flights

    * #### Url
        /flights

    * #### Method:
        `GET`

    * #### URL Params
        ###### **Required**:
        `departure=[String]`
        `arrival=[String]`
        `scheduledTime=[Date]`
        `passengers=[int]`
        **Optional**:
        `page=[int]`

    * #### Data Params
        None

    * #### Success Response:
        * **Code**: 200  
            **Content**: `{id: 6, flightNo: "Leroy", scheduledTime: "2019-07-23 05:57:12", departue: "Reykjavík", arrival: "Akureyri"}`

    * #### Sample Call:
      ```javascript
      $.ajax({
        url: "/flights/6",
        dataType: "json",
        type : "GET",
        data: {
            departure: "Reykjavík",
            arrival: "Akureyri",
            scheduledTime: "2019-07-23 05:57:12",
            passengers: 1
          },
        success : function(r) {
          console.log(r);
        }
      });
      ```
