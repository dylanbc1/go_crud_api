import { useState } from 'react'
import './App.css'
import TaskList from "./pages/TaskList.jsx";

function App() {
    const [count, setCount] = useState(0);

  return (
    <div id="root">
      <TaskList owner = "Dylan"></TaskList>
    </div>
  )
}

export default App
