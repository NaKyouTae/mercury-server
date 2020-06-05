package com.competition.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.competition.jpa.model.token.RefreshToken;
import com.competition.service.token.JwtService;
import com.competition.service.token.black.BlackTokenService;
import com.competition.service.token.refresh.RefreshTokenService;
import com.competition.service.user.UserService;
import com.competition.user.CustomUserDetails;

public class JwtInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private JwtService jwtService;
	@Autowired
	private JwtService jwtUtill;
	@Autowired
	private BlackTokenService blackTokenService;
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private UserService userSerivce;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {

		String Access = request.getHeader("Access-JWT");
		String Refresh = request.getHeader("Refresh-JWT");
		
		// login이 되었을 경우
		if(Access != null && Refresh != null) {
			
			
			if(jwtService.validateToken(Refresh, "Refresh")) {
				Boolean isRefresh = refreshTokenService.isRefreshToken(Refresh);
				Boolean isBlack = blackTokenService.isBlackToken(Refresh);
				
				if(!isRefresh && isBlack) return false;
			}
			
			if(!jwtService.validateToken(Access, "Access")) {
				RefreshToken reTokenInfo = refreshTokenService.seRefreshToken(Refresh);
				CustomUserDetails user = (CustomUserDetails) userSerivce.loadUserByUsername(reTokenInfo.getUserName());
				
				response.setHeader("Access-JWT", jwtUtill.createAccessToken(request, response, user, new Date(System.currentTimeMillis() + 1 * (1000 * 60 * 30))));
			}
		}
		
		return true;
	}
}