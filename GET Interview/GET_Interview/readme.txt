Solution Overview
The solution provided is a custom TestNG listener that captures screenshots for the final result. 
The listener is added to the TestNG test suite and runs automatically when the test cases are executed. 
The screenshot files are saved to a folder named "screenshots" with the name of the final result as the file name.

Components
The screenshot is saved to a file in the "screenshots" folder with the name of the final result.
TestNG test cases: These are the Java classes that contain the test cases to be executed. 
Test data properties file: This is a properties file that contains the test data used in the test cases, such as firstname, lastname, email, and phone input values.

Features
Registering with vaild data using properties file.
Making sure that user created successfully by taking screenshot.
Test data properties file: The test data used in the test cases is stored in a properties file. This makes it easy to update the test data without modifying the test cases.