import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Register from './Pages/Register';
import UserPreference from './Pages/UserPreferences';
import Listings from './Pages/Listings';
import ShowListings from './Pages/ShowListings';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path="/" exact element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" exact element={<Register/>}/>
        <Route path="/user-preference" element={<UserPreference/>}/>
        <Route path="/listing" element={<Listings/>}/>
        <Route path="/showListings" element={<ShowListings/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
