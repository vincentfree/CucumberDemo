# CucumberDemo
Cucumber demo bij Atos test competence

Casus 1

naast de gegevens TC-101 en TC-102 gaan we nu TC-103 en 104 maken. 

------------------------------------------------------------------------------------
TC -103

  To check if error is reported if check-out date field is in the past
  1. Launch hotel reservation application using URL as in test data.
  2. Login to the application using username and password as in test data.
  3. Select location as in test data.
  4. Select hotel as in test data.
  5. Select room type as in test data.
  6. Select no-of-rooms as in test data.
  7. Enter check-out-date as in test data.
  8. Verify that application throws error message
  
  URL: http://adactin.com/HotelApp/index.php
  User:{test username}
  Password:{test password}
  
  Location: Sydney
  Hotel: Hotel Sunshine
  Room type: Double
  No-of-rooms:2
  Check-in-date: today’s -5 date
  Check-out date: today’s -3 date
  System should report an error message ‘Enter Valid dates’
------------------------------------------------------------------------------------
