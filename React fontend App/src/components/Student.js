import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Button, Container, Paper } from '@material-ui/core';
import DataTable from './Datatable';


export default function Student() {
  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
  const [name,setName] = React.useState('');
  const [address,setAddress] = React.useState('');

  //communication with backend application API spring boot
  const handleClick = (e)=>{
    e.preventDefault()
    const student ={name,address}
    console.log(student)
    fetch("http://localhost:8085/api/students",{
        method: "POST",
        headers:{"Content-Type":"application/json"},
        body: JSON.stringify(student)
    }).then(() => {
        console.log("new student added")
    }).catch((err) => {
        console.log("internal server error")
    });

  };

  
 
  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>  
        <Box
          component="form"
          sx={{
            '& .MuiTextField-root': { m: 1, width: '100%' },
          }}
          noValidate
          autoComplete="off"
        >
            <h1 style={{color:"blue",fontSize: 30}}>Add Student </h1>

          <div>
            <TextField
              id="student-name"
              label="Student Name"
              placeholder="Enter student name"
              multiline
              fullWidth
              value={name}
              onChange={(e) => setName(e.target.value)}
            />

            <TextField
              id="student-address"
              label="Student Address"
              placeholder="Enter student address"
              multiline
              fullWidth
              value={address}
              onChange={(e) => setAddress(e.target.value)}
            />
          </div>
          <Button variant="contained" color='primary' 
          onClick={handleClick}>
                Submit
           </Button>
        </Box> 
      </Paper>

      <DataTable/>

    </Container> 
  );
}

 