package com.belajar.tdd.service;

import com.belajar.tdd.entity.CheckoutEntity;
import com.belajar.tdd.repository.CheckoutRepository;
import org.junit.jupiter.api.Assertions;
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
    void saveDataCheckoutDiskonLebaran() {
        //  Data Input
        CheckoutEntity checkoutEntity = new CheckoutEntity();
        checkoutEntity.setId(1);
        checkoutEntity.setAmount(1000);
        checkoutEntity.setPromoCode("lebaran");

        //Data Expected
        CheckoutEntity checkoutEntityExpected = new CheckoutEntity();
        checkoutEntityExpected.setId(1);
        checkoutEntityExpected.setAmount(1000);
        checkoutEntityExpected.setPromoCode("lebaran");
        checkoutEntityExpected.setTotalAmount(950);


        //Mocking
        Mockito.when(checkoutRepository.save(Mockito.any(CheckoutEntity.class))).thenReturn(checkoutEntityExpected);

        //      Testing unit checkoutProcess
        CheckoutEntity actual = checkoutService.checkoutProcess(checkoutEntity);

        //      Validation Process
        Assertions.assertEquals(checkoutEntityExpected.getId(), actual.getId());
        Assertions.assertEquals(checkoutEntityExpected.getAmount(), actual.getAmount());
        Assertions.assertEquals(checkoutEntityExpected.getPromoCode(), actual.getPromoCode());
        Assertions.assertEquals(checkoutEntityExpected.getDiscountAmout(), actual.getDiscountAmout());
        Assertions.assertEquals(checkoutEntityExpected.getTotalAmount(), actual.getTotalAmount());
    }

    @Test
    void saveDataCheckoutDiskonTahunBaru() {
        //  Data Input
        CheckoutEntity checkoutEntity = new CheckoutEntity();
        checkoutEntity.setId(1);
        checkoutEntity.setAmount(1000);
        checkoutEntity.setPromoCode("tahun_baru");

        //Data Expected
        CheckoutEntity checkoutEntityExpected = new CheckoutEntity();
        checkoutEntityExpected.setId(1);
        checkoutEntityExpected.setAmount(1000);
        checkoutEntityExpected.setPromoCode("tahun_baru");
        checkoutEntityExpected.setTotalAmount(980);

        //Mocking
        Mockito.when(checkoutRepository.save(Mockito.any(CheckoutEntity.class))).thenReturn(checkoutEntityExpected);

        //      Testing unit checkoutProcess
        CheckoutEntity actual = checkoutService.checkoutProcess(checkoutEntity);

        //      Validation Process
        Assertions.assertEquals(checkoutEntityExpected.getId(), actual.getId());
        Assertions.assertEquals(checkoutEntityExpected.getAmount(), actual.getAmount());
        Assertions.assertEquals(checkoutEntityExpected.getPromoCode(), actual.getPromoCode());
        Assertions.assertEquals(checkoutEntityExpected.getDiscountAmout(), actual.getDiscountAmout());
        Assertions.assertEquals(checkoutEntityExpected.getTotalAmount(), actual.getTotalAmount());
    }
}
