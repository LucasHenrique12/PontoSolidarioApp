package com.example.login_auth_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="locaisDoacaoTipoDoacao")
public class LocaisDoacaoTipoDoacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String locaisDoacaoId;
    private String tipoDoacaoid;
    
	public String getLocaisDoacaoId() {
		return locaisDoacaoId;
	}

	public void setLocaisDoacaoId(String locaisDoacaoId) {
		this.locaisDoacaoId = locaisDoacaoId;
	}

	public String getTipoDoacaoid() {
		return tipoDoacaoid;
	}

	public void setTipoDoacaoid(String tipoDoacaoid) {
		this.tipoDoacaoid = tipoDoacaoid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
}
