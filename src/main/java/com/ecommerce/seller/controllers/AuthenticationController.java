package com.ecommerce.seller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.seller.config.JwtTokenUtil;
import com.ecommerce.seller.model.ApiResponse;
import com.ecommerce.seller.model.AuthToken;
import com.ecommerce.seller.model.Seller;
import com.ecommerce.seller.model.User;
import com.ecommerce.seller.service.SellerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody User user) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        final Seller authenticateSeller = sellerService.findOne(user.getUsername());
        final String token = jwtTokenUtil.generateToken(authenticateSeller);
        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUsername(), authenticateSeller.getSellerId()));
    }

}
