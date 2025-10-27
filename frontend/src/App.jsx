import axios from "axios";
import { useEffect, useState } from "react"


function App() {

  const [animals, setAnimals] = useState("");
  const [inputAnimalName, setInputAnimalName] = useState("");
  const [inputAnimalKingdom, setInputAnimalKingdom] = useState("");
  const [inputAnimalID, setInputAnimalID] = useState("");
  const [updateInputAnimalID, setUpdateInputAnimalID] = useState("");
  const [updateInputAnimalName, setUpdateInputAnimalName] = useState("");
  const [updateInputAnimalKingdom, setUpdateInputAnimalKingdom] = useState("");
  const [retrievedAnimalList,setRetrievedAnimalList] = useState("");

  const getAllAnimals = async () => {
    const response = await axios.get("http://localhost:8080/");
    if(!(response.status === 200)){
      throw new Error("Failed to add an get animals");
    }
    setAnimals(JSON.stringify(response.data));
    setRetrievedAnimalList((response.data));
  }
  
  const addAnimalHandler = async () => {
    const response = await axios.post("http://localhost:8080/", {
      "animalName": inputAnimalName,
      "animalKingdom": inputAnimalKingdom  
    });
    getAllAnimals();
    if(!(response.status === 200)){
      throw new Error("Failed to add an animal");
    }
  }

  const updateAnimalHandler = async () => {
    const response = await axios.put("http://localhost:8080/"+updateInputAnimalID, {
      "animalName": updateInputAnimalName,
      "animalKingdom": updateInputAnimalKingdom 
    });
    getAllAnimals();
  }

  const deleteAnimalHandler = async () => {
    const response = await axios.delete('http://localhost:8080/'+inputAnimalID);
    getAllAnimals();
  }


  useEffect(() => {
    getAllAnimals();
  },[]);

  function inputAnimalNameChange(e){
    setInputAnimalName(e);
  }

  function inputAnimalKingdomChange(e){
    setInputAnimalKingdom(e);
  }

  function inputAnimalIDChange(e){
    setInputAnimalID(e);
  }

  function updateInputAnimalNameChange(e){
    setUpdateInputAnimalName(e);
  }

  function updateInputAnimalKingdomChange(e){
    setUpdateInputAnimalKingdom(e);
  }

  function updateInputAnimalIDChange(e){
    setUpdateInputAnimalID(e);
  }

  

  return (
    <>
    <div>
    <label>
      <span>Enter animal's name:</span>
      <input type="text" onChange={(e) => inputAnimalNameChange(e.target.value)} value={inputAnimalName}/><br />
      <span>Enter animal's kingdom:</span>
      <input type="text" onChange={(e) => inputAnimalKingdomChange(e.target.value)} value={inputAnimalKingdom} /><br />
      <button onClick={addAnimalHandler}>Enter</button>
    </label>
    </div>
    <hr />
    <label><button onClick={deleteAnimalHandler}>Enter ID to delete:</button>
    <input type="number" value={inputAnimalID} onChange={(e) => inputAnimalIDChange(e.target.value)} />
    </label>
    <hr />
    <div>
    <label>
      <button onClick={updateAnimalHandler}>Enter details to update:</button>
    <input type="number" value={updateInputAnimalID} onChange={(e) => updateInputAnimalIDChange(e.target.value)}/>
    <input type="text" value={updateInputAnimalName} onChange={(e) => updateInputAnimalNameChange(e.target.value)}/>
    <input type="text" value={updateInputAnimalKingdom} onChange={(e) => updateInputAnimalKingdomChange(e.target.value)}/>
    </label>
    </div>
    <hr />
    <div>
      <h3>List of all animals in the zoo:{animals}</h3>
      {/* <table border="1">
        <thead>
          <tr>
            <th>Animal ID</th>
            <th>Animal Name</th>
            <th>Animal Kingdom</th>
          </tr>
        </thead>
        <tbody>
          
        </tbody>
      </table> */}
    </div>
    </>
  )
}

export default App
