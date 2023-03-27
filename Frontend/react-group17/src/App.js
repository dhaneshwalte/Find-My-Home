import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Register from './Pages/Register';
import UserPreference from './Pages/UserPreferences';
import ProfilePage from './Pages/Profile/profile';
import Match from './Pages/Match/Match'
import Navbar from './Pages/Navbar/navbar'
import GroupMatch from './Pages/Group/group';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path="/" exact element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" exact element={<Register/>}/>
        <Route path="/user-preference" element={<UserPreference/>}/>
        <Route path="/edit-user-preference" element={<UserPreference/>}/>
        <Route path="/match" element={<Match/>}/>
        <Route path="/profilepage" element={<ProfilePage/>}/>
        <Route path="/groups" element={<GroupMatch />}/>

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
