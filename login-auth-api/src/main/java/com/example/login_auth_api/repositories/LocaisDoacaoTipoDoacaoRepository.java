package com.example.login_auth_api.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.login_auth_api.domain.LocaisDoacaoTipoDoacao;

@Repository
public interface LocaisDoacaoTipoDoacaoRepository  extends JpaRepository<LocaisDoacaoTipoDoacao,String> {
	List<LocaisDoacaoTipoDoacao> findAllByLocaisDoacaoId(String localDoacaoId);
}
