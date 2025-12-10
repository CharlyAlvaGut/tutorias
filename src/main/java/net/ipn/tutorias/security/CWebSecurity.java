package net.ipn.tutorias.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CWebSecurity {

	/*
	 * Este método es para configurar Usuarios y roles de forma personalizada (Se
	 * debe especificar a qué tablas pertenecen nuestros usuarios y perfiles)
	 */
	@Bean
	UserDetailsManager usersCustom(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.setUsersByUsernameQuery(
			    "SELECT correo AS username, password, estatus AS enabled FROM usuarios WHERE correo = ?"
			);
		users.setAuthoritiesByUsernameQuery(
			    "SELECT a.correo AS username, b.descripcion FROM usuarios a INNER JOIN rol b ON a.idRol = b.id WHERE a.correo = ?"
			);


		return users;
	}

	/*
	 * Este método sirve para personalizar accesos a las URL's
	 * 
	 */
	@Bean
	SecurityFilterChain filtro(HttpSecurity http) throws Exception {
		// Dentro de este método, especificaremos qué URL's serán protegidas
		http.authorizeHttpRequests(authorize -> authorize
				// Los recursos estáticos no requieren autenticación
				.requestMatchers("assets/**").permitAll()

				// Las vistas publicas no requieren autorización
				.requestMatchers("/").permitAll()
				.requestMatchers("/registro").permitAll()
				.requestMatchers("/pass").permitAll()
				.anyRequest().authenticated());

		// El formulario del Login no requiere autenticación
		http.formLogin(form -> form.loginPage("/login").failureUrl("/login?error=true").permitAll());
		return http.build();

	}

	/*
	 * Método para encriptar las contraseñas con ByCript
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
