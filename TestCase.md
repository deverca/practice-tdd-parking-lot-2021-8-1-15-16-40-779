# story 1
[x] Case1  

Given a parking lot, and a car
When park the car  
Then return a parking ticket. 

[x] Case2

Given a parking lot and parking ticket 
When fetch the car
Then return the corresponding car 

[X] Case3

Given a parking lot with two parked cars and two parking tickets
When fetch twice
Then return the right car to each customer

[X] Case4

Given a parking lot and wrong ticket
When fetch the car
Then return no car

[X]Case5

Given a parking lot and used ticket
When fetch the car
Then return no car

[X]Case6

Given a parking lot with maximum capacity and a car 
When park the car
Then return no ticket

#Story 2

[x]Case7

Given a parking lot and wrong ticket(unrecognized ticket)
When fetch
Then return error message "Unrecognized parking ticket"

[X]Case8

Given a parking lot and wrong ticket(used ticket)
When fetch the car
Then return error message "Unrecognized parking ticket"

[X]Case9

Given a parking lot without any position
When park the car
Then return error message "No available position"


# Story 3
[X] Case1

Given a parking lot and a standard parking boy, and a car  
When park the car  
Then return a parking ticket

[X] Case2

Given a parking lot with a parked car, a standard parking boy, and a parking ticket  
When fetch the car  
Then return a parked car

[] Case3

Given a parking lot with two parked cars, a standard parking boy, and two parking tickets  
When fetch the car  
Then return the right car with each ticket

[] Case4

Given a parking lot, a standard parking boy, and a wrong parking ticket  
When customer fetch the car  
Then return nothing with error message Unrecognized parking ticket

[] Case5

Given a parking lot, a standard parking boy, and used parking ticket  
When fetch the car  
Then return nothing with error message Unrecognized parking ticket

[] Case6

Given a parking lot with no space available, a standard parking boy, and a car  
When park the car  
Then return nothing with error message No Available Position




