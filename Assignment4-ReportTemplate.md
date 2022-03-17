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

In part 2, we are going to perform GUI testing with Sportchcek’s web page. The Selenium IDE web-interface testing tool is used for automating our test cases. We need to decide the sequence of events on the web interface we want to test for GUI tests. The test events our group chose to test are search, change size, add to cart, change store, apply promotion code, check out, and sort function. We will test each functionally with different possible data to ensure a comprehensive testing. After recording our test cases, we will execute the recorded scripts to test the system. Finally, we will report any defects we found with this test automation.


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
|    9  | 917  | Incremented(++a) double local variable number 1  |Survived|For this particular line of source code “​​String msg = "Range(double, double): require lower (" + lower + ") <= upper (" + upper + ")."; Mutant change the value of local variables. But for that local variable, it is only used to print the output for exception. It doesn’t have any influences with the method output. Therefore there is nothing we can do about test cases, this mutant has survived. |
| 10 |  90 | Incremented(--a) double local variable number 1  |Killed | The line of source code is within the class constructor. There is an if statement “if (lower > upper)”. In our test cases for constructor, we have a test method with lower = 100.1 and upper = 100. Therefore if the mutants try to decrease the lower by 1, it will actually change the statement condition state, thus this mutant is killed.|

# Report all the statistics and the mutation score for each test class


# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
