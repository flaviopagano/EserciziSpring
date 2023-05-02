# Exercise - Spring Boot - Spring Repositories 1
* write a Spring Boot application with the necessary dependencies that:
  * runs on port `5050`
  * uses `Rest Repositories HAL Explorer`
  * connects to a local MySQL db
  * drops the schema at the end of the session
  * defines a table of programming languages, where each `ProgrammingLanguage` has:
    * a primary key
    * a `name` not null
    * a year of `firstAppearance` that can be null
    * a column `inventor` not null
  * defines a repository for the programming languages, so that it's possible to use `HAL Explorer` and `Postman`:
    * the repository uses a specific path called `repo-prog-languages` and it has a description
* use `Postman` to:
  * add 4 specific programming languages to database:
    * `Java`
    * `C++`
    * `JavaScript`
    * `Go`
  * get a list of all the programming languages available in the database, with a pagination of 2 results per page
  * edit the inventor of one of the programming languages already in the database, entering your name
* **note for reviewers**: examples of postman requests can be found in `SpringRepositories2PostmanCollection.postman_collection.json`
