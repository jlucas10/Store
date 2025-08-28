// src/components/ProductPreview.js
import React from 'react';
import ProductCard from './ProductCard';

const sampleProduct = {
    id: 1,
    name: "EcoFlex Running Shoes",
    price: 89.99,
    imageUrl: "https://images.unsplash.com/photo-1597892657493-6847b9640bac?q=80&w=774&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    description: "Lightweight, breathable shoes designed for comfort and performance. Made from recycled materials."
};

const ProductPreview = () => {
    const handleAddToCart = (product) => {
        console.log("Added to cart:", product);
    };

    return (
        <div style={{ padding: '2rem', display: 'flex', justifyContent: 'center' }}>
            <ProductCard product={sampleProduct} onAddToCart={handleAddToCart} />
        </div>
    );
};

export default ProductPreview;
