package spring.boot.doctolib.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.boot.doctolib.model.Personne;
import spring.boot.doctolib.repository.IPersonneRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private IPersonneRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Personne> opt = utilisateurRepo.findByLogin(login);

		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get());
		} else {
			throw new UsernameNotFoundException(login + " Inconnu");
		}
	}

}
