package com.freelancerLink.dto;

import com.freelancerLink.web.dto.AccountInfoDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class AccountInfoDtoTest {

    @Test
    public void lombok_test(){
        String name = "junho";
        String address = "yangju";

        AccountInfoDto dto = new AccountInfoDto(name, address);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAddress()).isEqualTo(address);

    }

}
