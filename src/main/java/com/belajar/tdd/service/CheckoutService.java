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
               checkoutEntity = prosesDiskon(5,checkoutEntity);
           }
           else if ("tahun_baru".equals(checkoutEntity.getPromoCode())){
               checkoutEntity = prosesDiskon(5,checkoutEntity);
           }

        return checkoutRepository.save(checkoutEntity);
    }

    private CheckoutEntity prosesDiskon(Integer diskon, CheckoutEntity checkoutEntity){
        Integer discountAmout = ((diskon*checkoutEntity.getAmount())/100);
        Integer totalAmount = checkoutEntity.getAmount() - discountAmout;
        checkoutEntity.setDiscountAmout(discountAmout);
        checkoutEntity.setTotalAmount(totalAmount);
        return checkoutEntity;
    }

}
