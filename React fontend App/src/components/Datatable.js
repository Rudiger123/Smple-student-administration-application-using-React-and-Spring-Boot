import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';

const columns = [
  { field: 'id', headerName: 'ID', width: 150 },
  { field: 'name', headerName: 'Student name', width: 200 },
  { field: 'address', headerName: 'Student Address', width: 200 },
  {
    field: 'actions',
    headerName: 'Actions',
    width: 200,
  },
  {
    field: 'fullName',
    headerName: 'Full Name',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 300,
    valueGetter: (value, row) => `${row.name || '-'} ${row.address || ''}`,
  },
];

// Replace this with your actual API endpoint or data
const apiUrl = 'http://localhost:8085/api/students';

export default function DataTable() {
  const [students, setStudents] = React.useState([]);

  React.useEffect(() => {
    fetch(apiUrl, {
        method: "GET"
    })
      .then((response) => response.json())
      .then((data) => {setStudents(data)})
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  return (
    <div style={{ height: 600, width: '100%' }}>
      <DataGrid
        rows={students}
        columns={columns}
        pageSize={5}
        checkboxSelection
        disableSelectionOnClick
      />
    </div>
  );
}
