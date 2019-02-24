package lexicon.task;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/* username min/max */
	static final int MIN_USER = 2;
	static final int MAX_USER = 20;

	/* password min/max */
	static final int MIN_PASS = 8;
	static final int MAX_PASS = 30;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/", "/home", "/css/*", "/gfx/*").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/home")
		.defaultSuccessUrl("/order", true)
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		List<String> lines = getAuth();

		auth
		.inMemoryAuthentication()
		.withUser(lines.get(0)).password(lines.get(1)).roles("USER");
	}

	final String getUsernameRange() {
		return (MIN_USER + " - " + MAX_USER);
	}
	final String getPasswordRange() {
		return (MIN_PASS + " - " + MAX_PASS);
	}

	List<String> getAuth() {
		Path input = null;
		List<String> lines = null;

		try {
			input = Paths.get("./auth.conf");
			lines = Files.readAllLines(input, Charset.forName("UTF-8"));
		} catch (Exception ex) {
			handleReadError(ex.getMessage());
			/* NOTREACHED */
		}

		if (lines.isEmpty())
			handleReadError("list contains no elements");
		else if (lines.size() != 2)
			handleReadError("lines.size() not equal to 2");
		else if (lines.get(0).equals(""))
			handleReadError("line 1 empty  --  invalid username");
		else if (lines.get(1).equals(""))
			handleReadError("line 2 empty  --  invalid password");

		final String username = lines.get(0);
		final String password = lines.get(1);

		if (username.length() < MIN_USER || username.length() > MAX_USER)
			handleReadError("username out of bounds: " + getUsernameRange());
		if (password.length() < MIN_PASS || password.length() > MAX_PASS)
			handleReadError("password out of bounds: " + getPasswordRange());

		return lines;
	}

	void handleReadError(final String msg) {
		System.err.println("fatal error: error reading config file: " + msg);
		System.exit(1);
	}
}
