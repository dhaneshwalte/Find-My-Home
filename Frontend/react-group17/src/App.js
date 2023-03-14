import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Register from './Pages/Register';
import UserPreference from './Pages/UserPreferences';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path="/" exact element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" exact element={<Register/>}/>
        <Route path="/user-preference" element={<UserPreference/>}/>
        <Route path="/edit-user-preference" element={<UserPreference/>}/>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
