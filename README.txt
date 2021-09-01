This is a automation test suite developed in Java using TestNg framework and Selenium, covering below listed critical functionalities of BuggyRating Application:
1. Positive and Negative login scenarios
2. Retrieve Popular Make
3. Retrieve Popular Model
4. Retrieve Overall Top Ranking
5. Update Customer Profile to change the current password


Steps to execute:
Run the InvokeLayer -> TestRunner class as a TestNg application

Test Data:
'Data.xlsx' file present in this folder can be updated with UserId, Password and NewPassword attribute values, according to which positive and negative login and change password scenarios will be run.


Test Result:
'Result.xlsx' file present in this folder will be updated with the result parameters of the above 5 functionalities, once the automation test suite run is completed.


Test Report:
TestNg report thats auto generated shows the status of the test run, whether its Passed/Failed/Skipped and the total time taken to run it.
To see the report:
Go to 'test-output' folder and open the 'emailable-report' html file with any web browser.
OR
Go to 'Command line suite' folder inside 'test-output' folder and open the 'Command line test' html file with any web browser.
