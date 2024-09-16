package com.example.login_auth_api.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_auth_api.domain.DonationPlace;
import com.example.login_auth_api.domain.DonationType;
import com.example.login_auth_api.domain.LocaisDoacaoTipoDoacao;
import com.example.login_auth_api.dto.DonationPlaceDTO;
import com.example.login_auth_api.repositories.DonationPlaceRepository;
import com.example.login_auth_api.repositories.DonationTypeRepository;
import com.example.login_auth_api.repositories.LocaisDoacaoTipoDoacaoRepository;
import com.example.login_auth_api.service.DonationPlaceService;

@RestController
@RequestMapping(value = "pontosolidario/donationPlace")
public class DonationPlaceController {

@Autowired
private DonationPlaceRepository donationPlacerepository;
@Autowired
private DonationPlaceService donationPlaceService;
@Autowired
private LocaisDoacaoTipoDoacaoRepository locaisDoacaoTipoDoacaoRepository;
@Autowired
private DonationTypeRepository donationTypeRepository;

    @GetMapping
    public List<DonationPlaceDTO> findAll(){
    	List<DonationPlace> lista = donationPlacerepository.findAll();
    	List<DonationPlaceDTO> locaisDoacao = new ArrayList<>();
    	for(DonationPlace  donation : lista) {
    		List<LocaisDoacaoTipoDoacao> listaTiposLocalDoacao = locaisDoacaoTipoDoacaoRepository.findAllByLocaisDoacaoId(donation.getId());
    		
    		List<DonationType> tiposLocalDoacao = new ArrayList<>();
    		
    		for(LocaisDoacaoTipoDoacao localTipoDoacao : listaTiposLocalDoacao) {
    			tiposLocalDoacao.add(donationTypeRepository.findById(localTipoDoacao.getId()).get());
    		}
    		
    		locaisDoacao.add(new DonationPlaceDTO(donation.getName(), donation.getLatitude(), donation.getLongitude(), donation.getAddress(), tiposLocalDoacao));
    	}
    	return locaisDoacao;
    	
    }

    @PostMapping("/registerDonationPlace")
    public ResponseEntity<?> registerDonationPlace(@RequestBody DonationPlaceDTO body){
            try {
                donationPlaceService.donationPlaceRegister(body);
                return (ResponseEntity<?>) ResponseEntity.ok();
            } catch (RuntimeException e) {
                e.printStackTrace();
                return (ResponseEntity<?>) ResponseEntity.badRequest();
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationPlace> findById(@PathVariable String id) {
        return donationPlacerepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonationPlace(@PathVariable String id) {
        if (donationPlacerepository.existsById(id)) {
            donationPlacerepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
