import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import DataComponent from './Components/DataComponent'
import MainRoutes from './Routes/MainRoutes'
import TecnicoComponent from './Components/TecnicoComponents/TecnicoComponent'
import { Route,   BrowserRouter as Router, Routes } from 'react-router-dom'


function App() {
  const [count, setCount] = useState(0)

  return (
   
       <Router>
          <Routes>
              <Route path="/main" element={<DataComponent/>}/>
          </Routes>
          <Routes>
              <Route path="/tecnico" element={<TecnicoComponent/>}/>
          </Routes>
       </Router>
  )
}

export default App
