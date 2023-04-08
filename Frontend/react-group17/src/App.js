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
import ProfilePage from './Pages/Profile/profile';
import Navbar from './Pages/Navbar/navbar';
import GroupMatch from './Pages/Group/group';
import GroupPref from './Pages/GroupPref/GroupPref';
import Listings from './Pages/Listings';
import ShowListings from './Pages/ShowListings';
import ShowListing from './Pages/ShowListing';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
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
          <Route path="/edit-user-preference" element={<UserPreference />} />
          <Route path="/profilepage" element={<ProfilePage />} />
          <Route path="/groups" element={<GroupMatch />} />
          <Route path="/groupuserspref" element={<GroupPref />} />
          <Route path="/listing" element={<Listings />} />
          <Route path="/show-listings" element={<ShowListings />} />
          {/* <Route path="/show-listing/:listingId" element={<ShowListing />} /> */}
          <Route path="/show-listing" element={<ShowListing />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
