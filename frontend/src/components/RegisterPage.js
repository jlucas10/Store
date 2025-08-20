import React, { useState } from 'react';
import api from '../axiosConfig';

const RegisterPage = () => {
    const [form, setForm] = useState({ username: '', email: '', password: '' });
    const [message, setMessage] = useState('');

    const handleChange = e => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async e => {
        e.preventDefault();
        try {
            await api.post('/auth/register', form);
            setMessage('Registration successful! You can now log in.');
        } catch (err) {
            setMessage('Registration failed.');
        }
    };

    return (
        <div>
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <input name="username" placeholder="Username" onChange={handleChange} />
                <input name="email" placeholder="Email" type="email" onChange={handleChange} />
                <input name="password" placeholder="Password" type="password" onChange={handleChange} />
                <button type="submit">Register</button>
            </form>
            <p>{message}</p>
            <p>Already have an account? <a href="/">Log in</a></p>
        </div>
    );
};

export default RegisterPage;
