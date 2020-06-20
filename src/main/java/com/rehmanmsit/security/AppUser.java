package com.rehmanmsit.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Rehman
 *
 */

@Getter
@Setter
public class AppUser extends User {
	
	private static final long serialVersionUID = 1L;
	private final Map<String, Object> fields;

	public AppUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, Map<String, Object> fields) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.fields = fields;
	}

}
