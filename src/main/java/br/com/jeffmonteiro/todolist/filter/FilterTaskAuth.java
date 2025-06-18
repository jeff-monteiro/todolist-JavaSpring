package br.com.jeffmonteiro.todolist.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Implement your authentication logic here
        String getAuth = request.getHeader("Authorization");

        String getAuthEncoded = getAuth.substring("Basic".length()).trim();

        byte[] authDecode = Base64.getDecoder().decode(getAuthEncoded);
        String authString = new String(authDecode);
        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        System.out.println("Authorization Header ");
        System.out.println(username);
        System.out.println(password);

        // If authentication fails, you can send an error response
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

        // If authentication succeeds, continue with the filter chain
        filterChain.doFilter(request, response);
    }
}
