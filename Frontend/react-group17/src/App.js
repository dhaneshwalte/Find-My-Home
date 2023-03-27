import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Register from './Pages/Register';
import UserPreference from './Pages/UserPreferences';
import Match from './Pages/Match/Match';
import { MyLikes } from './Pages/MyLikes/MyLikes';
import { MyGroup } from './Pages/MyGroup/MyGroup';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" exact element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" exact element={<Register />} />
          <Route path="/user-preference" element={<UserPreference />} />
          <Route path="/match" element={<Match />} />
          <Route path="/my-likes" element={<MyLikes />} />
          <Route path="/my-group" element={<MyGroup />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
