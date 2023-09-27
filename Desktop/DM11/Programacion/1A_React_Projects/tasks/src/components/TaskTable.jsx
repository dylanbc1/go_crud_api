import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import TaskRow from "./TaskRow.jsx";
import PropTypes from "prop-types";

function TaskTable({taskList, delTask, edTask}) {
    const deleteTask = (task) => {
        delTask(task.id)
    }

    const editTask = (task) => {
        edTask(task)
    }

    const renderTasks = () => {
        return taskList.map( (task) => (
            (<TaskRow key={task.id} task={task} deleteTask={deleteTask} editTask={editTask}></TaskRow>)
        ))
    }

    return <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>UserId</TableCell>
                        <TableCell align="right">Id</TableCell>
                        <TableCell align="left">Title</TableCell>
                        <TableCell align="left">Completed</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {renderTasks()}
                </TableBody>
            </Table>
        </TableContainer>
}

TaskTable.propTypes = {
    taskList: PropTypes.array,
    delTask: PropTypes.func,
    edTask: PropTypes.func
}

export default TaskTable