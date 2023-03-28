import { Layout, Menu } from 'antd';
// import { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
// import {checkUserLogin} from '../../services/AuthenticationService';
const { Header } = Layout;
const Navbar = () => {
  console.log(window.location.pathname);

  // const {
  //   token: { colorBgContainer },
  // } = theme.useToken();
//  const [loading, setloading] = useState(true);
  // useEffect(() => {
  //   checkUserLogin()
  //   .then(response => {
  //       setloading(false);
  //   })
  //   .catch(reponse => {
  //   })
  // })
  const navbar = () => {
    const handleSignOut = () => {
      localStorage.removeItem("USER_KEY");
    }
    return(
        <Layout>
      <Header
        style={{
          position: 'sticky',
          top: 0,
          zIndex: 1,
          width: '100%',
        }}
      >
        <div
          style={{
            float: 'left',
            width: 120,
            height: 31,
            margin: '16px 24px 16px 0',

          }}
        >
        </div>
        <Menu
          theme="dark"
          mode="horizontal"
          defaultSelectedKeys={['2']}
          style={{
            gap: '50px'}}
        >
            <NavLink to="/profilepage">
                Home
            </NavLink>

            <NavLink to="/likes">
                Likes
            </NavLink>

            <NavLink to="/requests">
                Requests
            </NavLink>

            <NavLink to="/groups">
                Groups
            </NavLink>

            <NavLink to="/edit-user-preference">
                Preferences
            </NavLink>

            <NavLink to="/profilepage">
                Profile
            </NavLink>
            
            <NavLink onClick={handleSignOut} to="/login">
                Sign Out
            </NavLink>
        </Menu>
      </Header>
    </Layout>
  );
  }

  const checkRoutes = ["/","/login","/register"];
  const result = window.location.pathname;
  console.log(checkRoutes.includes(result));
  return (
    <div>
        {
            checkRoutes.includes(result) ? null : navbar()
        }
    </div>
  )
};
export default Navbar;