import React from "react";
import { useState } from "react";
import { userLogin } from "../../services/AuthenticationService";
import { Navigate } from 'react-router-dom'

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [redirect, setRedirect] = useState(false);

    const submit = (e) => {
        e.preventDefault();
        userLogin({"email": email, "password": password})
            .then((response)=>{
                console.log(response);
                localStorage.setItem('USER_KEY',response.data.token);
                setRedirect(true);
            })
            .catch(err => console.log(err));
    }

    if (redirect) {
        return <Navigate to="/"/>;
    }

  return (
    <div className="form">
    <h2>Find My Home</h2>
    <div className="form-body">
        <div className="email">
            <label className="form__label" for="email">Email </label>
            <input  type="email" id="email" className="form__input" placeholder="Email"
                    onChange={e => setEmail(e.target.value)}/>
        </div>
        <div className="password">
            <label className="form__label" for="password">Password </label>
            <input className="form__input" type="password"  id="password" placeholder="Password"
                    onChange={e => setPassword(e.target.value)}/>
        </div>
    </div>
    <div class="footer">
        <button type="submit" className="btn" onClick={submit}>Login</button>
    </div>
</div>      
  );
}

export default Login;
