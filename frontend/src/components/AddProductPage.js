// src/components/AddProductPage.js
import React, { useState } from 'react';
import api from '../axiosConfig';

const AddProductPage = () => {
    const [form, setForm] = useState({
        name: '',
        description: '',
        price: '',
        imageUrl: '',
        stock: ''
    });
    const [message, setMessage] = useState('');

    const handleChange = e => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async e => {
        e.preventDefault();
        try {
            await api.post('/products', {
                ...form,
                price: parseFloat(form.price),
                stock: parseInt(form.stock)
            });
            setMessage('Product added successfully!');
            setForm({ name: '', description: '', price: '', imageUrl: '', stock: '' });
        } catch (err) {
            console.error('Error adding product:', err); // ✅ Add this line
            setMessage('Failed to add product.');
        }
    };

    return (
        <div style={{ padding: '2rem' }}>
            <h2>Add New Product</h2>
            <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '1rem', maxWidth: '400px' }}>
                <input name="name" placeholder="Name" value={form.name} onChange={handleChange} required />
                <textarea name="description" placeholder="Description" value={form.description} onChange={handleChange} required />
                <input name="price" type="number" step="0.01" placeholder="Price" value={form.price} onChange={handleChange} required />
                <input name="imageUrl" placeholder="Image URL" value={form.imageUrl} onChange={handleChange} required />
                <input name="stock" type="number" placeholder="Stock" value={form.stock} onChange={handleChange} required />
                <button type="submit">Add Product</button>
            </form>
            <p>{message}</p>
        </div>
    );
};

export default AddProductPage;
