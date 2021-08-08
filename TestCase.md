# story 1

[x] Case1

Given a parking lot, and a car When park the car  
Then return a parking ticket.

[x] Case2

Given a parking lot and parking ticket When fetch the car Then return the corresponding car

[X] Case3

Given a parking lot with two parked cars and two parking tickets When fetch twice Then return the right car to each
customer

[X] Case4

Given a parking lot and wrong ticket When fetch the car Then return no car

[X]Case5

Given a parking lot and used ticket When fetch the car Then return no car

[X]Case6

Given a parking lot with maximum capacity and a car When park the car Then return no ticket

# Story 2

[x]Case7

Given a parking lot and wrong ticket(unrecognized ticket)
When fetch Then return error message "Unrecognized parking ticket"

[X]Case8

Given a parking lot and wrong ticket(used ticket)
When fetch the car Then return error message "Unrecognized parking ticket"

[X]Case9

Given a parking lot without any position When park the car Then return error message "No available position"

# Story 3

[X] Case1

Given a parking lot and a standard parking boy, and a car  
When park the car  
Then return a parking ticket

[X] Case2

Given a parking lot with a parked car, a standard parking boy, and a parking ticket  
When fetch the car  
Then return a parked car

[X] Case3

Given a parking lot with two parked cars, a standard parking boy, and two parking tickets  
When fetch the car  
Then return the right car with each ticket

[X] Case4

Given a parking lot, a standard parking boy, and a wrong parking ticket  
When customer fetch the car  
Then return error message Unrecognized parking ticket

[X] Case5

Given a parking lot, a standard parking boy, and used parking ticket  
When fetch the car  
Then return error message Unrecognized parking ticket

[X] Case6

Given a parking lot with no space available, a standard parking boy, and a car  
When park the car  
Then return nothing with error message No Available Position

# Story 4

[X] Case7

Given a multiple parking lots, standard parking boy, and a car When park the car Then park in the first parking lot and
return parking ticket

[X]Case8

Given a multiple parking lots with first is full, standard parking boy, and a car When park the car Then park in the
second parking lot and return parking ticket

[X]Case9

Given a multiple parking lots with full capacity, standard parking boy, and a car When park the car Then return nothing
with error message No Available Position

[X]Case 10 Given multiple parking lot with parked car, standard parking boy, and two parking ticket When fetch twice
Then return parked car

[X]Case11 Given multiple parking lots with full capacity, standard parking boy, and parking ticket for car in parking
lot 1 When fetch Then return the right car

[X] Case12

Given multiple parking lots, a standard parking boy, and a wrong parking ticket  
When customer fetch the car  
Then return error message Unrecognized parking ticket

[X] Case13

Given multiple parking lots, a standard parking boy, and used parking ticket  
When fetch the car  
Then return error message Unrecognized parking ticket

# Story 5

[X]Case1

Given a parking lot and a smart parking boy, and a car  
When park the car  
Then return a parking ticket

[X]Case2

Given a parking lot with a parked car, a smart parking boy, and a parking ticket  
When fetch the car  
Then return a parked car

[X] Case3

Given a parking lot with two parked cars, a smart parking boy, and two parking tickets  
When fetch the car  
Then return the right car with each ticket

[X] Case4

Given a parking lot, a smart parking boy, and a wrong parking ticket  
When customer fetch the car  
Then return error message Unrecognized parking ticket

[X] Case5

Given a parking lot, a smart parking boy, and used parking ticket  
When fetch the car  
Then return error message Unrecognized parking ticket

[X] Case6

Given a parking lot with no space available, a smart parking boy, and a car  
When park the car  
Then return nothing with error message No Available Position
[X]Case 7

Given two parking lot where lot 2 has more space a smart parking boy and a car When park Then park in lot 2 and return a
ticket

[X]Case 8 Given two parking lot where lot 1 has more space a smart parking boy and a car When park Then park in lot 1
and return a ticket

[X]Case 9 Given two parking lot with all full capacity, smart parking boy, and a car When park Then return No Available
Position

[x]Case10 Given two parking lot with two tickets and smart parking boy When fetch twice Then return right car

[X]Case11 Given two parking lots a smart parking boy and unrecognized ticket When fetch Then Unrecognized parking ticket

[X]Case12 Given two parking lots a smart parking boy and used ticket When fetch Then Unrecognized Parking ticket

# Story6

[X]Case1

Given a parking lot and a super smart parking boy, and a car  
When park the car  
Then return a parking ticket

[X]Case2

Given a parking lot with a parked car, a super smart parking boy, and a parking ticket  
When fetch the car  
Then return a parked car

[X] Case3

Given a parking lot with two parked cars, a super smart parking boy, and two parking tickets  
When fetch the car  
Then return the right car with each ticket

[] Case4

Given a parking lot, a super smart parking boy, and a wrong parking ticket  
When customer fetch the car  
Then return error message Unrecognized parking ticket

[] Case5

Given a parking lot, a super smart parking boy, and used parking ticket  
When fetch the car  
Then return error message Unrecognized parking ticket

[] Case6

Given a parking lot with no space available, a super smart parking boy, and a car  
When park the car  
Then return nothing with error message No Available Position


