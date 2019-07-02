# Convert CSV to Java Objects and store in SQLite DB

### Instructions to run code

Run the code by going to your local host Port 8080.
You will see the welcome page with a button to run the CSV parser. Check your IDEs run console to see all the items being parsed and the items being logged. Click the button when you are ready. Please note the parser will take some time to process everything.



###Approach 
Initially I wanted to use the batch job integrated into Spring Boot to parse and consume the data but I knew that I would run into trouble with the image link column as some of these items had commas embedded into the link. This would cause the batch job to break up data incorrectly and would require me to write methods to avoid this from happening. So I decided to go with Open CSV. Open CSV had a nice tool for consuming the data by columns and converting them into java beans that I could easily store inside of a database. Furthermore, it had a nice writing feature that would also let me write CSV files. It’s not the fastest solution but it works. I chose to go with spring boot because of the flexibility and the ability to build on top of this project. In the future an admin interface could be easily added with the ability to create, update and delete records. 




### Resources used:
The following guides were used  to use build some of the features:

* [Read / Write CSV files in Java using OpenCSV](https://www.callicoder.com/java-read-write-csv-file-opencsv/)
* [In-Memory Databases](https://www.sqlite.org/inmemorydb.html)
* [Introduction to OpenCSV](https://www.baeldung.com/opencsv)
* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Spring Boot With SQLite](https://www.baeldung.com/spring-boot-sqlite)
* [Open CSV Docs](http://opencsv.sourceforge.net/)


