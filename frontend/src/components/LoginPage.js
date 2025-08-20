import React, { useState } from 'react';
import api from '../axiosConfig';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
    const [form, setForm] = useState({ email: '', password: '' });
    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const handleChange = e => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async e => {
        e.preventDefault();
        try {
            const res = await api.post('/auth/login', form);
            localStorage.setItem('token', res.data.token);
            navigate('/products'); // or wherever you want to redirect
        } catch (err) {
            setMessage('Login failed.');
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <input name="email" placeholder="Email" type="email" onChange={handleChange} />
                <input name="password" placeholder="Password" type="password" onChange={handleChange} />
                <button type="submit">Login</button>
            </form>
            <p>{message}</p>
            <p>Don't have an account? <a href="/register">Register Here</a> </p>
        </div>
    );
};

export default LoginPage;
