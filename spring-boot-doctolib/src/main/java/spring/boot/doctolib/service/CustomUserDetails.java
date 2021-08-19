package spring.boot.doctolib.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import spring.boot.doctolib.model.Admin;
import spring.boot.doctolib.model.Patient;
import spring.boot.doctolib.model.Personne;
import spring.boot.doctolib.model.Praticien;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Personne personne;

	public CustomUserDetails(Personne personne) {
		super();
		this.personne = personne;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(personne instanceof Patient) {
			return AuthorityUtils.createAuthorityList("Patient");
		} else if(personne instanceof Praticien) {
			return AuthorityUtils.createAuthorityList("Praticien");
		} else if(personne instanceof Admin) {
			return AuthorityUtils.createAuthorityList("Admin");
		} else {
			return AuthorityUtils.createAuthorityList("Guest");
		}
	}

	@Override
	public String getPassword() {
		return new BCryptPasswordEncoder().encode(personne.getPassword());
	}

	@Override
	public String getUsername() {
		return personne.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
