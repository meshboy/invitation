### Invite closer customers to Dublin

#### Problem Statement 

Write a program that will read the full list of customers and
 output the names and user ids of matching customers 
 (within 100km), sorted by User ID (ascending).
 
 
### Description 
This program is written in Java. The customers are read from a file, then deserialize by GSON into a list. 
Each item in the list was checked if it falls within the given boundary by using the given property (lat and long). 
The allowed customers are stored in a PriorityQueue sorted in an ascending order by using the userId property. 

The sample file used to test for this program is located in resources/customers.txt under the src folder. Also, the 
result of the sample usecase can be found same path (resources/output.txt)

### How to run the program 

- Install gradle (https://gradle.org/install)
- gradle run 

### How to run Test 

- gradle test
