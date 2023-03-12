import { Layout, Menu, theme } from 'antd';
import { NavLink } from 'react-router-dom';
const { Header, Content, Footer } = Layout;
const App = () => {
  const {
    token: { colorBgContainer },
  } = theme.useToken();
  return (
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
            <NavLink to="">
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

            <NavLink to="/user-preference">
                Preferences
            </NavLink>

            <NavLink to="/profilepage">
                Profile
            </NavLink>
        </Menu>
      </Header>
    </Layout>
  );
};
export default App;