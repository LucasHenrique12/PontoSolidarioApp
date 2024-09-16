package com.example.login_auth_api.dto;

import java.util.List;

import com.example.login_auth_api.domain.DonationType;

public record DonationPlaceDTO (String name, String latitude, String longitude, String address, List<DonationType> listTypes){
}
