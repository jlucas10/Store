import React, { useEffect, useState } from 'react';
import api from '../axiosConfig';
import './ProductPage.css';

const ProductPage = () => {
    const [products, setProducts] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const res = await api.get('/products'); // Adjust endpoint if needed
                setProducts(res.data);
            } catch (err) {
                setMessage('Failed to load products.');
            }
        };

        fetchProducts();
    }, []);

    return (
        <div>
            <h2>Products</h2>
            {message && <p>{message}</p>}
            <ul>
                {products.map(product => (
                    <li key={product.id}>
                        <strong>{product.name}</strong> - ${product.price}
                        <button>Add to Cart</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ProductPage;
