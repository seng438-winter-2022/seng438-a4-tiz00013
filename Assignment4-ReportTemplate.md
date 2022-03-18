**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#: 6         |   |
|-----------------  |---|
| Manpreet Singh    |   |
| Tianfan Zhou      |   |
| Girimer Singh     |   |
| Muhammad Shakeel  |   |

# Introduction
In this lab, we are going to practice with mutation testing and GUI testing. In part 1 of the lab, we will try to perform mutation testing based on the test files we previously wrote in lab 2 and lab 3 for Range.java and DataUtilites.java files. A testing tool Pitest is used to provide automated generation of mutants, and run our tests against mutants. The initial mutation score based on our lab 3 submission files will be first tested and recorded. Our goal is to increase this old mutation score by at least 10% by adding more testing cases. We will also choose 10 mutants from the Pitest report and analyze why they are killed or not. This analysis is important for us to write new mutation tests.

In part 2, we are going to perform GUI testing with Sport chek’s web page. The Selenium IDE web-interface testing tool is used for automating our test cases. We need to decide the sequence of events on the web interface we want to test for GUI tests. The test events our group chose to test are search, sign in, register, change store, apply promotion code, filter, check out, and sort function. We will test each functionally with different possible data to ensure a comprehensive testing. After recording our test cases, we will execute the recorded scripts to test the system. Finally, we will report any defects we found with this test automation.


# Analysis of 10 Mutants of the Range class 
| No.        |  Line of Code | Description | Killed or Survived | Reason for the Behaviour|
|-----------------  |---|---- |----|------- | 
|   1  | 105  |Negated double field lower  |Killed | For test case, with Range object r1 = new Range(10, 20), the actual output (10) should match with expected output(10) and passes on the original SUT program. When the same test run on Negated double field lower mutant, the actual output is -10 and the expected output is 10, which fails the test for the Mutant and thus killed the mutant.|
|    2  | 114  |Incremented (++a)double field upper  |Killed | For test case, with Range object r1 = new Range(10, 20), the actual output (20) should match with expected output(20) and passes on the original SUT program. When the same test run on this mutant, the actual output is 21 and the expected output is 20, which fails the test case for the Mutant and thus killed the mutant.|
|    3  | 91  | Decremented(--a) double local variable number 1  |Survived | For test case, with Range object r1 = new Range(20, 10), the test case should check for the illegal argument exception and test case passes for the original SUT program. When the same test case run on this mutant, it still throws the same exception and passes the test case and thus the mutant gets survived.|
| 4 |  337  |Negated double local variable 7 |Survived |   For test case, with Range object r1 = new Range(10, 20), the test case should check for where the expanded Range object output from SUT matches with the expected output and test case passes for the original SUT program. When the same test case run on this mutant, it only prints the negated double variable and this doesnt affect the test case results, it passes the same test case and thus the mutant gets survived.|
|  5   |123   |Incremented (++a) double field upper  |Killed |For test suite, with Range object r1 = new Range(10, 30), the actual output of the getLength() method is 20 should match with expected output(20) and it passes on the original SUT program. When the same test run on this mutant, the actual output from the mutant is 21 and the expected output is 20, which fails the test case for the Mutant and thus killed the mutant.|
|  6    |242   | Removed conditional - replaced equality check with false  | Survived|For line of source code “if (range2 != null && range2.isNaNRange()) Since the mutants change the equality check to false, we need a test case to make this statement become true in order to detect the mutants. We need to have range2.isNaNRange() become true. We don’t have that related test case in our original suites, therefore this mutant survived. |
|  7    |  157 | Greater than to less or equal  |Killed |For line of source code “return (b1 > this.lower); Since it is directly return the statement result value. To change > to <= will flip the boolean value no matter what testing input we designed within our test cases. So that this mutant is detected and has been killed. |
| 8 |132   |Replaced double addition with subtraction   |Killed |For line of source code “return this.lower / 2.0 + this.upper / 2.0; Unless this.upper is 0, otherwise replacing addition with subtraction in this operation will definitely change the method output. In our test cases, we don’t have upper to 0 cases, and we used assertEquals to match with the exact output value. Since mutation brings a different output value, thus, this test case is killed. |
|    9  | 91  | Incremented(++a) double local variable number 1  |Survived|For this particular line of source code “​​String msg = "Range(double, double): require lower (" + lower + ") <= upper (" + upper + ")."; Mutant change the value of local variables. But for that local variable, it is only used to print the output for exception. It doesn’t have any influences with the method output. Therefore there is nothing we can do about test cases, this mutant has survived. |
| 10 |  90 | Incremented(--a) double local variable number 1  |Killed | The line of source code is within the class constructor. There is an if statement “if (lower > upper)”. In our test cases for constructor, we have a test method with lower = 100.1 and upper = 100. Therefore if the mutants try to decrease the lower by 1, it will actually change the statement condition state, thus this mutant is killed.|

# Report all the statistics and the mutation score for each test class
## Range Class
<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic1.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 1- Range Pit Test Coverage Report for original test suite
</p>


<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic2.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 2- Range Pit Mutation for original test suite
</p>

<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic3.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 3- Range Pit Test Coverage Report for updated test suite
</p>

<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic4.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 4- Range Pit Mutation for updated test suite
</p>

## Data Utilities Class

<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic5.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 5- DataUtilities Pit Test Coverage Report for original test suite 
</p>

<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic6.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 6- DataUtilities Pit Mutation for original test suite
</p>


<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic7.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 7-  DataUtilities Pit Test Coverage Report for updated test suite
</p>


<p align="center">
  <img width="600" src="https://github.com/seng438-winter-2022/seng438-a4-tiz00013/blob/main/images/Pic8.png" alt="Material Bread logo">
</p>
<p align="center">
   Figure 8- DataUtilities Pit Mutation for updated test suite
</p>

# Analysis drawn on the effectiveness of each of the test classes
The mutation testing in this lab helped us to find the effectiveness of our test cases that were made in lab 3 for the Range class and for the Data Utilities class. The results illustrated in the above section of this report shows that the test cases made during the lab 3 were not that effective and we found that mutation score for the Range class before the mutation testing was only 59% and for the Data Utilities class, it was 81%. This also shows that a lot of these test cases survived the mutants and thus our test cases were not effective in detecting the faults in the source code. 

With the help of the mutation testing, we created additional test cases in some of the test classes where the mutants survived and run the PIT testing again to recalculate the mutation score for the Range class and for the Data Utilities Class. After implementing the mutation testing on both the classes, we found that the the mutation score of Range class and the Data Utilities class increased to 70% and 91% respectively. This also indicates that the new test cases changed the states of some of the mutants from survived to killed and thus helped in increasing the quality of test cases.

# A discussion on the effect of equivalent mutants on mutation score accuracy
Based on definition, equivalent mutants are the mutants that do the exactly same thing with the original program. They act in the same behavior as the original program. For example, if the original source code is “a = a+1” and if there is a mutant changes the code to be “a++”, then it will be an equivalent mutant since it does the same thing compared with the original code.

Equivalent mutants will have no influence on mutation score. Since mutation score is calculated by mutation score = number of mutants killed by the test suites / number of all non equivalent mutants. Although equivalent mutants will always survive, it is not included within both denominator and numerator, so that equivalent mutants will have no impact on mutation score calculation. However, some mutation testing tools such as Pitest do include all mutants when calculating mutation coverage. Since for these tools they are not able to identify if a mutant is an equivalent mutant or not, in this way, it will decrease mutation score accuracy.

# A discussion of what could have been done to improve the mutation score of the test suites
Since the mutation score is calculated by the number of mutants killed by the test suites / number of all non equivalent mutants, to increase the mutation score, we need to have more non equivalent mutants to be detected and killed. In order to achieve that, we need to create more test cases based on the following conditions. First a test must reach the mutated statement. Otherwise if a mutated statement is not even reached, it can have no influence on the output, therefore that mutant can never be detected and killed. This condition is easy to reach if we have a good line coverage rate of our tests. Second, test input data should infect the program state by causing different program states for the mutant and the original program. This means we can try to create test cases based on the different kinds of mutants. For example, if we have a mutant which changes the condition within a if statement from a equality condition check to always false, then we must have a test case to make the condition of  that if statement becomes true, and the execution code within that if statement must have some influences on output, such that that mutants can be detected. Finally, The incorrect program state must propagate to the program's output and be checked by the test. This is to say, our test cases must be able to catch and detect the incorrect program state caused by mutants. Otherwise, if a mutant changes the program state but test cases don’t check for that state, that mutant still can not be detected.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing
Mutation testing is important because the new test cases would help find more defects that exist in the program. This can improve the test suite and the quality of the program is improved and this is achieved by inserting mutants into the program and our newly designed test cases should be able to detect the faults that are present in the system. We want the test cases to fail because if the test cases are passing then it means that there is error in the code that needs to be fixed. Furthermore, this method of testing is useful for getting a stronger coverage by testing certain parts of the code.

Advantages
-   Mutation testing is useful in detecting defaults or faults which might not be visible through original test cases
-   Mutation testing ensures better coverage and improves test suite
-   The program or software will be more reliable

Disadvantages
-   This technique is very time consuming and costly as the mutants must be generated separately
-   Mutation testing will not work for black box testing as change of source code is needed
-   Most of the times, many test cases need to be executed and automation tool would be needed


# Explain your SELENUIM test case design process
Our SELENIUM test case design process was based on the functionalities tested on the sportchek.ca. As a group of 4, we tested 8 important functionalities on their website and tested these functionalities using the SELENIUM IDE extension on the google chrome. 
The following eight functionalities were tested on the sportchek.ca using the SELENIUM Web driver
1. Search Items:- Testing the search functionality using valid and invalid items on the website
2. Sign In:- Testing  the valid and invalid credentials on the sign in page
3. Register:- Testing the the valid and invalid inputs on the register page
4. Change Store:- Testing whether the change store functionality would change the current store to selected store in the change store menu.
5. Promotion Code:- Testing invalid and valid inputs for the Promotion code field on the website.
6. Filter- Testing whether the filter functionality produces the right results.
7. Sort functionality:- Testing whether the sort functionality produces the right results
8. Checkout Menu:- Testing whether the checkout button opens up the Payment window.

# Explain the use of assertions and checkpoints
Checkpoints are that location in test execution at which every tester should define it logically and intelligently, because it determines the failure condition as well as it helps in validation of the test cases with respect to its actual and expected data.

Assertion is a tool to verify the result. It is used to determine the state of the application whether it is the same as what we are expecting or not. If the assertion fails, then the test case fails and stops the execution. It can be divided into hard assertion or soft assertion.Hard Assertions are used when we want to halt the execution of the test script when the assert condition does not match with the expected result. Soft Assertions are used when the test script need not be halted when the assertion condition does not meet the expected result.

We can use assertion at checkpoints locations, such that if the system states at these key checkpoints locations can be verified. If the state is incorrect, we can immediately terminate our testing.

# how did you test each functionaity with different test data
The SELENIUM IDE was used to test each functionality with different test data and to automate the process of testing on the website. For each functionality, the test case was created in the SELENIUM IDE and we put the link of the sportchek.ca in the url and started recording the functionality on the IDE. Once the recording starts, the functionality is tested with both the valid and invalid inputs of data and when the testing is done, recording was stopped and recorded commands were run to make sure that it passed the test cases.
All the 8 functionalities were tested in the following way

### Search Functionality:-
We recorded the invalid input(“kslskla”) as well as valid input(“shirts”) on the search field and ran the recorded commands to make sure that it passes the test cases.

### Sign In:- 
This functionality was tested by checking the correct credentials on the sign in page. For Instance, We tested the correct credentials of the user name and password and tried to sign in on the website. Moreover, We input the wrong credentials of the username and password and tested the sign in page with it.

### Promotion Code:-
This functionality was testing was using the valid promotion code and invalid promotion code on the checkout menu.

### Register Page:-
In this functionality, we tested the valid input and invalid input for the registration page. For instance, We provided a correct email which was never registered with the sportcheck website and tried to test the registration page with that email. Similarly, we tested the registration page with an invalid email and a registered email.

### Filter:-
In this functionality, we tested whether items gets filtered according to the Brand Names. For Instance, If Adidas is selected in the filter menu, It should display only Adidas items. 

### Change Store:-
In this functionality, we didnt use any test data. We tested whether the change Store functionality changed the current store to the selected store. For instance, initially, the selected store on the website was Crowfoot and then we changed the store to the westbrook to see if the current store gets changed after performing this functionality.

### Checkout:-
To test checkout, an item was added to cart and then proceed to complete a guest checkout. All the shipping details were filled and then tested if payment option shows. Moreover, the shipping location information consists of First Name, Last Name, Address, Postal-Code, Email and Phone Number. We tested all these field with the valid input and the invalid input.

### Sorting:-
In this functionality, we didn't use any test data. Items were sorted on a page from lowest to highest price, highest to lowest price, sorting based on rating and new arrivals. There is no way to verify if new arrivals work as intended as it is not clear when items were added to website. Clearance items showed on top in result of sorting by new arrivals.

# Discuss advantages and disadvantages of Selenium vs. Sikulix
Advantages of Selenium vs Sikulix
-   supported in most web browsers (chrome, Firefox, Internet Explorer, and Safari)
-   The use of HTML locators for testing web pages makes it more accurate
-   Changes to the user interface would not cause test causes to fail
 
Disadvantage of Selenium vs Sikulix
-   It can test only applications that are web-based
-   There is no support for flash objects (video player)
-   Cannot be used to test desktop applications


# How the team work/effort was divided and managed
We downloaded all the required tools needed to complete this lab together (Pitest and Selenium IDE). After the installation process was complete, we ran test using the Pitest tool and had a good understanding on increasing the mutation coverage by adding more test cases to our test suite. Muhammad worked on the functions equals and expand for Range class. Manpreet worked on constrain and hashcode for Range class. Tianfan worked on constructor and intersects for the Range class. Girimer worked on the calculateColumnTotal and calculateRowTotal for DataUtilities class. For GUI testing, everyone tested 2 functionalities for the Sportchek website. Muhammad tested the search functionaility and sign in. Manpreet tested selecting the size and promotion code. Tianfan tested the filter and change store. Girimer tested the checkout menu and sort.

# Difficulties encountered, challenges overcome, and lessons learned
There were some challenges that we faced while completing this lab. For example, some of our group members had a trouble installing and configuring the Pitest tool as it was not working properly. The solution to this problem was to install the updated and latest version of Pitest through the website rather than using the built-in marketplace in eclipse. Another challenge that we faced was that using the Selenium IDE, sometimes the test cases were not getting recorded accurately. To overcome this problem, we had to make sure that we were executing the test cases slowly to make sure that everything gets executed and nothing gets missed. By completing part one of this lab, we have gained a good understanding of how to create mutants and write test cases to kill the mutants. In part two we gained a good understanding of automate GUI testing and got familiar with recording and replaying the test cases. 

# Comments/feedback on the lab itself
After completing this lab, we have gained good knowledge on Mutation and GUI testing. After injecting mutants into the program, we analyzed the mutation score using the Pitest and created better test cases. Selenium IDE was useful in terms of how automated web based testing is done. This lab has taught the importance of mutation testing to find faults and fixing them with better test cases. The Selenium IDE would be useful to test if a website or GUI is working as it expected or not. The lab instructions provided in the lab manual were detailed and helpful in completing the lab. Also, the installation steps given for Pitest and Selenium IDE were useful in successfully downloading these tools to complete the lab.

