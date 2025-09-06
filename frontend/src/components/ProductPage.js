// src/pages/ProductPage.js
import React, { useEffect, useState } from 'react';
import api from '../axiosConfig';
import ProductCard from '../components/ProductCard';
import './ProductPage.css';

const ProductPage = () => {
    const [products, setProducts] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const res = await api.get('/products');
                setProducts(res.data);
            } catch (err) {
                setMessage('Failed to load products.');
            }
        };

        fetchProducts();
    }, []);

    const handleAddToCart = (product) => {
        console.log('Added to cart:', product);
        // You can later wire this to your cart context or backend
    };

    return (
        <div className="product-page">
            <h2>Products</h2>
            {message && <p>{message}</p>}
            <div className="product-grid">
                {products.map(product => (
                    <ProductCard
                        key={product.id}
                        product={product}
                        onAddToCart={handleAddToCart}
                    />
                ))}
            </div>
        </div>
    );
};

export default ProductPage;
