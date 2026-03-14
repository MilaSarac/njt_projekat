/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Mila
 */

//
@Configuration
public class SecurityConfig {
    
    @Bean
    //obezbedice da se instancira objekat ove klase
    //ova metoda ce svaki moguci http zahtev koji dodje sa klijentske strane
    //ce proci kroz SecurityFilterChain koji ce za bilo koji request 
    //da dozvoli sve .anyRequest().permitAll()
    //dozvolice da bilo koji http zahtev koji dodje bude dzovoljen bez autentifikacije, ne postoji nikakva zastita
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
                );
        return http.build();
    }
}
