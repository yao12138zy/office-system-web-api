import axios from "axios";
import './App.css';

function App() {

  return (
    <div className="App">
      {
        axios.get("http://localhost:8080/user/getAll").then(function (response){
        console.log(response);
      }).catch(function (response){
          console.log(response);
      })

      }
    </div>
  );
}

export default App;

