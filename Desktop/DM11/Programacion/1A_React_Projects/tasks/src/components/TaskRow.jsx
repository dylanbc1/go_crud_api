import React, {useState} from 'react'
import TableCell from '@mui/material/TableCell';
import PropTypes from "prop-types";
import TableRow from '@mui/material/TableRow';
import {Button} from "@mui/material";

function TaskRow({task, deleteTask, editTask}) {
    // recibimos funcion como props para llamarlo desde el hijo sabiendo a cuál task se refiere
    const handleClickDelete = () => {
        deleteTask(task)
    }

    const handleClickEdit = () => {
        editTask(task)
    }

    return <TableRow
        key={task.id}
        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
        <TableCell component="th" scope="row">
            {task.userId} </TableCell>
        <TableCell align="right">{task.id}</TableCell>
        <TableCell align="left">{task.title}</TableCell>
        <TableCell align="left">{task.completed + ""}</TableCell>
        <TableCell align="left">
            <Button variant = {"contained"} color="error" onClick={handleClickDelete}>DELETE</Button>
        </TableCell>
        <TableCell align="left">
            <Button variant = {"contained"} color="info" onClick={handleClickEdit}>EDIT</Button>
        </TableCell>
    </TableRow>
}

TaskRow.propTypes = {
    task: PropTypes.object,
    deleteTask: PropTypes.func,
    editTask: PropTypes.func
}

export default TaskRow