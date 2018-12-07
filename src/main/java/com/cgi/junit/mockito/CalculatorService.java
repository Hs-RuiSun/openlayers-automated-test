package com.cgi.junit.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.junit.Calculator;

@Service
public class CalculatorService {
    @Autowired
    private CalculatorDao calculatorDao;

    public Calculator save(Calculator calculator) {
        return calculatorDao.save(calculator);
    }

    public Calculator findOne(String name, Integer quantity) {
        return calculatorDao.findOne(name, quantity);
    }

    public void order(Calculator calculator) throws InsufficientProductsException {
        int quantity = calculator.getQuantity();
        int quantityInStock = calculatorDao.getQuantityInStock();
        if (quantity > quantityInStock) {
            throw new InsufficientProductsException(quantityInStock, quantity);
        }
        calculatorDao.save(calculator);
    }

    public String getLabelMessage(String name) {
        return calculatorDao.getLabelMessage(name);
    }
}
