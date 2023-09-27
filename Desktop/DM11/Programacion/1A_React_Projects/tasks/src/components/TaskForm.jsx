import React, {useEffect, useState} from 'react'
import {Box, Button, Checkbox, FormControlLabel, TextField} from '@mui/material'
import PropTypes from "prop-types";

function TaskForm({addTask, taskToEdit}){
    const [id, setId] = useState('')
    const[title, setTitle] = useState('')
    const[completed, setCompleted] = useState(false)
    const[userId, setUserId] = useState('')

    const handleClick = (e) => addTask({title, userId, completed})

    useEffect( () => {
        console.log(taskToEdit)
            setId(taskToEdit.id)
            setUserId(taskToEdit.userId)
            setCompleted(taskToEdit.completed)
            setTitle(taskToEdit.title)
    }, [taskToEdit])

    return (
            <Box
                component="form"
                sx={{
                    '& > :not(style)': { m: 1, width: '25ch' },
                }}
                noValidate
                autoComplete="off"
            >
                <TextField label="User ID" variant="standard" value = {userId}
                           onChange={(e) => {setUserId(e.target.value)}}/>
                <TextField label="Title" variant="standard" value = {title}
                           onChange={(e) => {setTitle(e.target.value)}}/>
                <FormControlLabel control= {<Checkbox checked={completed}
                                                      onChange={(e) => {setCompleted(!completed)}}/>}
                                  label={"Completed"}></FormControlLabel>
                <Button variant = {"contained"} onClick={handleClick}>SAVE</Button>
            </Box>
        )

}

TaskForm.propTypes = {
    addTask: PropTypes.func,
    taskToEdit: PropTypes.object
}

export default TaskForm