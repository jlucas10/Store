// src/components/ProductCard.js
import React from 'react';
import './ProductCard.css';

const ProductCard = ({ product, onAddToCart }) => {
    const { name, price, imageUrl, description } = product;

    return (
        <div className="product-card">
            <img src={imageUrl} alt={name} className="product-image" />
            <h3>{name}</h3>
            <p>{description}</p>
            <p className="price">${price.toFixed(2)}</p>
            <button onClick={() => onAddToCart(product)}>Add to Cart</button>
        </div>
    );
};

export default ProductCard;
