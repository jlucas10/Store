import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import ProductPage from "./components/ProductPage";
import ProductPreview from "./components/ProductPreview";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="/product" element={<ProductPage />} />
                <Route path="/preview" element={<ProductPreview />} />
            </Routes>
        </Router>
    );
};

export default App;
