# Exercise - Spring Boot - Web Socket 2
* write a Spring Boot application with the necessary dependencies that:
  * uses websockets to a message to all the clients that subscribed to the topic `broadcast`
  * exposes the endpoint for sending the message on `broadcast-message` that:
    * accepts a payload of `MessageDTO` that has 2 properties:
      * `sender`
      * `type`
      * `message`
  * exposes an endpoint (`client-message`) for the client that can send `ClientMessageDTO`:
    * a `ClientMessageDTO` has the following properties:
      * `clientName`
      * `clientAlert`
      * `clientMsg`
    * when the server receives a message from the client, it re-sends it to the broadcast
  * has a mocked frontend that:
    * connects using `SockJS`
    * prints on screen the `MessageDTO`
    * prints on screen the messages that the client sends
* the output in the browser will be similar to the following picture:

![](output.PNG)

* send a message to the subscribed client using `Postman`
* **note for reviewers**: view `WebSocket2.postman_collection.json` in the root folder for all the `Postman` calls
