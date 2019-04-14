# **Getting Started**
Github: `https://github.com/tommi2510/_8F.git`

## **Spring Boot Rest API**

1. Import the project in your favorite IDE and with Maven
2. Run the app
3. Make request to localhost:8080/api

# **API endpoints**

## User

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
        **Content**: `{id: 6, firstName: "Leroy", lastName: "Jenkins", email: "leroyJenk@gmail.com"}`

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
        `firstName: [String]`
        `lastName: [String]`
        `email: [String]`

    * #### Success Response:
        * **Code**: 200  
        **Content**: `{firstName: "Leroy", lastName: "Jenkins", email: "leroyJenk@gmail.com"}`

    * #### Sample Call:
          ```javascript
          $.ajax({
            url: "/users",
            dataType: "json",
            type : "POST",
            data: {
                firstName: "Leroy",
                lastName: "Jenkins",
                email: "leroyJenk@gmail.com"
            }
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
            **Content**: `{id: 6, flightNo: "6F1435", scheduledTime: "2019-07-23 05:57:12", departure: "Reykjavík", arrival: "Akureyri", seats: 76, seatsAvailable: 43, price: 15000}`

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
            **Content**: `[{id: 6, flightNo: "6F1435", scheduledTime: "2019-07-23 05:57:12", departue: "Reykjavík", arrival: "Akureyri", seats: 76, seatsAvailable: 43,  price: 15000}]`

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
## Booking

* ### Get Booking
    Returns json data about booking

    * #### Url
        /bookings/:id

    * #### Method:
        `GET`

    * #### URL Params
        `id=[Long]`

    * #### Data Params
        None

    * #### Success Response:
        * **Code**: 200  
            **Content**: `{id: 7, userId: 6, created: "2019-07-23 05:57:12"}`

    * #### Sample Call:
      ```javascript
      $.ajax({
        url: "/bookings/7",
        dataType: "json",
        type : "GET",
        success : function(r) {
          console.log(r);
        }
      });
      ```
* #### Create a booking
    Returns json data about booking

    * #### Url
        /bookings

    * #### Method:
        `POST`

    * #### URL Params
        None

    * #### Data Params
        `user: [Object]`
        `user.id: [Long]`
        `flight: [Object]`,
        `flight.id: [Long]`,
        `passengers: [Array]`
        `passengers.$: [Object]`
        `passengers.$.firstName: [String]`
        `passengers.$.lastName: [String]`

    * #### Success Response:
        * **Code**: 200  
            **Content**: ``

    * #### Sample Call:
      ```javascript
      $.ajax({
        url: "/bookings",
        dataType: "json",
        type : "GET",
        data: {
            user: {
                id: 6
            },
            flight: {
                id: 1
            },
            passengers: [
                {
                    firstName: "Leroy",
                    lastName: "Jenkins",
                    luggage: 1,
                    priorityB: true,
                    firstClass: true
                }
            ]
          },
        success : function(r) {
          console.log(r);
        }
      });
      ```
## Passenger

* ### Get Passenger
    Returns json data about passenger

    * #### Url
        /passengers/:id

    * #### Method:
        `GET`

    * #### URL Params
        `id=[Long]`

    * #### Data Params
        None

    * #### Success Response:
        * **Code**: 200  
            **Content**: `{firstName: "Leroy", lastName: "Jenkins", luggage: 1, priorityB: true, firstClass: true}`

    * #### Sample Call:
      ```javascript
      $.ajax({
        url: "/passengers/7",
        dataType: "json",
        type : "GET",
        success : function(r) {
          console.log(r);
        }
      });
      ```
* #### Create a passenger
    Returns json data about passenger

    * #### Url
        /passengers

    * #### Method:
        `POST`

    * #### URL Params
        None

    * #### Data Params
        `firstName: [String]`
        `lastName: [String]`

    * #### Success Response:
        * **Code**: 200  
            **Content**: `{firstName: "Leroy", lastName: "Jenkins", luggage: 1, priorityB: true, firstClass: true}`

    * #### Sample Call:
      ```javascript
      $.ajax({
        url: "/bookings",
        dataType: "json",
        type : "POST",
        data: {
            firstName: "Leroy",
            lastName: "Jenkins",
            luggage: 1,
            priorityB: true,
            firstClass: true,
          },
        success : function(r) {
          console.log(r);
        }
      });
      ```
