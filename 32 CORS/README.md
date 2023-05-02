# Exercise - Spring Boot - CORS
* React client application
  * follow [this guide](https://create-react-app.dev/docs/getting-started) to setup a local React environment
  * then replace the code in `App.js` with the following code:
```
const fetchApi = async () => {
  console.log("You have clicked the button!");
  try{
    const response = await fetch("http://localhost:8080/custom");
    const text = await response.text();
    console.log("Response: ", text)
  }catch(e){
    console.error(e);
  }
}

function App() {
  return (
    <div className="App">
      <button id="clickMe" onClick={fetchApi}>8080</button>
    </div>
  );
}
export default App;
```
* Spring server application
  * write a Spring Boot application with the necessary dependencies that:
    * allows the connection to an endpoint `custom` (that returns a welcome message) to the calls coming from the `React` local server
* test the connection to the endpoint using the `React` application (you need to run its local server)
