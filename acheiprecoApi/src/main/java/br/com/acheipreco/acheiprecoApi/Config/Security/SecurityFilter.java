package br.com.acheipreco.acheiprecoApi.Config.Security;

import br.com.acheipreco.acheiprecoApi.Repository.UserRepository;
import br.com.acheipreco.acheiprecoApi.Services.TokenServices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenServices tokenServices;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null){
            var email = tokenServices.validateToken(token);
            UserDetails userDetails = userRepository.findByEmail(email);
            var authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            filterChain.doFilter(request,response);
        }
    }

    private String recoverToken(HttpServletRequest httpServletRequest){
        var authHeader = httpServletRequest.getHeader("authorization");
        if(authHeader == null){
            return null;
        }
        return authHeader.replace("Bearer","");
    }
}
