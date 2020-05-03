package com.belajar.tdd.service;

import com.belajar.tdd.entity.CheckoutEntity;
import com.belajar.tdd.repository.CheckoutRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CheckoutServiceTests {

    @Autowired
    CheckoutService checkoutService;

    @MockBean
    CheckoutRepository checkoutRepository;

    @Test
    void saveDataCheckoutDiskon5() {
        //  Data Input
        CheckoutEntity checkoutEntity = new CheckoutEntity();
        checkoutEntity.setId(1);
        checkoutEntity.setAmount(1000);
        checkoutEntity.setPromoCode("lebaran");

        //Data Expected
        CheckoutEntity checkoutEntityExcepted = new CheckoutEntity();
        checkoutEntityExcepted.setId(1);
        checkoutEntityExcepted.setAmount(1000);
        checkoutEntityExcepted.setPromoCode("lebaran");
        checkoutEntityExcepted.setTotalAmount(950);

        Mockito.when(checkoutRepository.save(Mockito.any(CheckoutEntity.class))).thenReturn(checkoutEntityExcepted);

        //      Testing unit checkoutProcess
        CheckoutEntity actual = checkoutService.checkoutProcess(checkoutEntity);

        //      Validation Process
        Assertions.assertEquals(checkoutEntityExcepted.getId(), actual.getId());
        Assertions.assertEquals(checkoutEntityExcepted.getAmount(), actual.getAmount());
        Assertions.assertEquals(checkoutEntityExcepted.getPromoCode(), actual.getPromoCode());
        Assertions.assertEquals(checkoutEntityExcepted.getDiscountAmout(), actual.getDiscountAmout());
        Assertions.assertEquals(checkoutEntityExcepted.getTotalAmount(), actual.getTotalAmount());
    }

}
