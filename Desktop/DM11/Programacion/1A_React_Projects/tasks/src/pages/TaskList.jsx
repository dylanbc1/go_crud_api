import React, {useState} from 'react'
import tasks from '../data/todos.json'
import TaskTable from "../components/TaskTable.jsx";
import TaskForm from "../components/TaskForm.jsx";
import PropTypes from "prop-types";

function TaskList({owner}) {
   const[taskList, setTaskList] = useState(tasks)
    const[editTask, setEditTask] = useState({userId:"", id:"", title: "", completed:false})

    const deleteTask = (taskId) => {
        setTaskList(taskList.filter( (task) => task.id !== taskId ))
    }

    const addTask = (task) => {
        task.id = Math.floor(Math.random() * 100000)
        console.log(task.id +" " + task.userId)
        let taskTmp = [...taskList] //  el tasklist, le coloco
        // ... para que ese arreglo contenga tod0 lo que tiene tasklist
        // si yo llegase a color = taskList, copiaría un puntero y no
        // estaría cambiando como tal el arreglo
        taskTmp.push(task) // a la lista temporal le pusheo la nueva task
        setTaskList(taskTmp) // ahora cambio el estado del tasklist, enviandole
        // el nuevo estado taskTmp
    }

    return <div>{owner}'s TaskList
        <p>{console.log(editTask)}</p>
        <TaskForm addTask={addTask} taskToEdit={editTask}/>
        <TaskTable taskList = {taskList} delTask={deleteTask} edTask={setEditTask}></TaskTable>
        </div>
}

TaskList.propTypes = {
    owner: PropTypes.string,
    delTask: PropTypes.func
}

export default TaskList