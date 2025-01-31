package com.lcc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TokenService {
    private static Logger log = LoggerFactory.getLogger(TokenService.class);

    private Set<String> blacklistedTokens = new HashSet<>();

    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
        log.info("Token 已加入黑名单: {}", token);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
}