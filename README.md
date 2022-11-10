# Anagram exercise

## Compile the classes in the following sequence:

> javac -cp . com/global/ReadFile.java

> javac -cp . com/global/Processor.java

> javac -cp . com/global/Main.java

## Run the class Main to get the output

> java -cp . com/global/Main.java [file_path]

## Big O analysis

* The time complexity is O(n^2)

## Reason for using Hashmap

* Hashmap uses hash() to create unique ids for each object. I have tried to use that to my advantage by generating my own unique ids for each of the words.

## Future Prospects:

* Create an api which would allow the user to use this program via RESTAPI
* There should be a way to lower the time complexity which needs more time.
* Increase the test coverage to atleast 80% (currently, its 77%)


