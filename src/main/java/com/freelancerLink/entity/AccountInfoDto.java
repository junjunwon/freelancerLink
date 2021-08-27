package com.freelancerLink.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class AccountInfoDto {
    private final String name;
    private final String address;

}
