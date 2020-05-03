package com.belajar.tdd.service;

import com.belajar.tdd.entity.CheckoutEntity;
import com.belajar.tdd.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    @Autowired
    CheckoutRepository checkoutRepository;

    public CheckoutEntity checkoutProcess(CheckoutEntity checkoutEntity){

           if ("lebaran".equals(checkoutEntity.getPromoCode())){
               Integer discountAmout = ((5*checkoutEntity.getAmount())/100);
               Integer totalAmount = checkoutEntity.getAmount() - discountAmout;
               checkoutEntity.setDiscountAmout(discountAmout);
               checkoutEntity.setTotalAmount(totalAmount);
           }

        return checkoutRepository.save(checkoutEntity);
    }



}
