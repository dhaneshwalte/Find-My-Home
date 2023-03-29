import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Register from './Pages/Register';
import UserPreference from './Pages/UserPreferences';
import Match from './Pages/Match/Match';
import { MyLikes } from './Pages/MyLikes/MyLikes';
import RoommateRequests from './Pages/RoommateRequests/RoommateRequests';
import { MyGroup } from './Pages/MyGroup/MyGroup';
import GroupRequests from './Pages/GroupRequests/GroupRequests';

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
          <Route path="/roommate-requests" element={<RoommateRequests />} />
          <Route path="/my-group" element={<MyGroup />} />
          <Route path="/edit-user-preference" element={<UserPreference />} />
          <Route path="/group-requests" element={<GroupRequests />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
