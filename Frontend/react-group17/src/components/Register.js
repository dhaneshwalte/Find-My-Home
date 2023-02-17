import React, {useState} from 'react';
import { userRegister } from '../services/AuthenticationService';
import { Navigate } from 'react-router-dom'
import './Register.css';

const Register = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [redirect, setRedirect] = useState(false);

    const submit = (e) => {
        e.preventDefault();

        const userData = {
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "password": password
        };
        console.log(userData);
        userRegister(userData).then(
            (response)=>{
                console.log(response);
                localStorage.setItem('USER_KEY',response.data.token);
                setRedirect(true);
            }
        )
        .catch(err=>console.log(err));

    }

    if (redirect) {
        return <Navigate to="/login"/>;
    }
    return(
        <div className="form">
            <h2>Find My Home</h2>
            <div className="form-body">
                <div className="username">
                    <label className="form__label" for="firstName">First Name </label>
                    <input className="form__input" type="text" id="firstName" placeholder="First Name"
                            onChange={e => setFirstName(e.target.value)}/>
                </div>
                <div className="lastname">
                    <label className="form__label" for="lastName">Last Name </label>
                    <input  type="text" name="" id="lastName"  className="form__input"placeholder="LastName"
                            onChange={e => setLastName(e.target.value)}/>
                </div>
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
                <div className="confirm-password">
                    <label className="form__label" for="confirmPassword">Confirm Password </label>
                    <input className="form__input" type="password" id="confirmPassword" placeholder="Confirm Password"/>
                </div>
            </div>
            <div class="footer">
                <button type="submit" className="btn" onClick={submit}>Register</button>
            </div>
        </div>      
      )
};

export default Register;