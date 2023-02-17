import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path="/" exact element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" exact element={<Register/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
