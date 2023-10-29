   Poker Assessment  

Poker Assessment
================

Development Environment
-----------------------

*   **OS:** Windows 11
*   **IDE:** Eclipse
*   **Builder:** Maven
*   **Source control:** Git - Github
*   **Console:** Git Bash

The source code can be found [here](https://github.com/Fr0s7by73/Poker).

Installation
------------

Navigate to the root directory of where you checked out the code.

In Git Bash, run the following command: _./build.sh_  
This should also work in a linux environment.  
If you are using the native Windows command prompt, rename the "build.sh" file to "build.bat", and run the following command: _build.bat_

This will do a maven clean install, downloading all the required libraries needed for the application, run all the unit tests for the application, and build a runnable jar, which gets deployed to the "target" directory.

_Developer notes: I stuck to shell script formatting, since that was the way it was demoed in the example. I could've created both .sh and .bat formats, but since build and deployment is gerenally an in house, controlled environment, I didn't create multiple options._

_My initial build script created a new directory on the local home directory, and copied the new jar, as well as the run.sh file to that location. This seemed a bit "invasive" for an assessment excercise like this, so I decided to stick with the default maven deploy location of "target"._

Launch
------

After the maven build is successful, simply run the application by calling the "run.sh" file in the same way the "build.sh" file was called.

General Info
------------

The program launches from com.advance.poker.view.PokerMain.java

### Design Considerations - Expansion

I made PokerGame an abstract class, which allows me to implement some methods that should be the same across different types of Poker Games. The methods that might vary between different Poker Games I also made abstract, forcing developers to override these methods in their subclasses.

This should make it easier to add another variant of Poker Game.

### Design Consideration - Move to web based frontend

Ideally I would've created the backend part as API's. That would be the easiest way to put a web based front end in front of it at a later stage. Creating API's and launching a web server to host it in was outside of the scope of this assessment. So I created the project using an MVC (Model View Controller) Design Pattern. This way, should we decide later to add a web based frontend, we can just remove the view part of this project. Converting the existing code to API services should be reasonably easy.

### Design Consideration - Display in console

Initially I had the code in com.advance.poker.controller.utils.DeckBuilder.buildDisplayName() use Unicode to display the symbol of the card's suit. This worked great during testing in my IDE's console. When I did some testing in Windows CMD and Git Bash, I noticed this doesn't work by default, and I got question marks instead of the suit symbol.

It was possible to fix this by changing the console's default settings on how it interprets Unicode. I don't find it acceptable to ask a user to change their environment to this extent to run our game successfully, so I changed it to something simpler that will have a higher level of success until we find a better solution.