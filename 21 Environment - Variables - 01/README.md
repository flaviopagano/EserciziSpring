# Exercise - Spring Boot - Environment Variables 1
* create a `Spring Boot` application using `Spring Initializr` that has the following dependencies:
  * `Lombok`
  * `Spring Boot DevTools`
  * `Spring Web`
* define an `application.yaml` config file where you set:
  * a property called `authCode` with the value `xyz458`
  * a property called `devName` with your name as a value
* using `Spring Boot` on port `4500`, return a greeting message showing the `devName` and the `authCode` using the `getProperty` method
