//package AppLetsLearnEnglish.SecurityConfig;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import AppLetsLearnEnglish.Service.AccountService;
//import AppLetsLearnEnglish.Service.CustomAccountServiceDetails;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class JWTAuthenticationFilter extends OncePerRequestFilter{
//	UserDetailsService userDetailsService;
//	JWTTokenHelper jwtTokenHelper;
//	public JWTAuthenticationFilter(UserDetailsService userDetailsService,JWTTokenHelper jwtTokenHelper) {
//		this.userDetailsService=userDetailsService;
//		this.jwtTokenHelper=jwtTokenHelper;
//	}
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//String authToken=jwtTokenHelper.getToken(request);
//		
//		if(null!=authToken) {
//			
//			String userName=jwtTokenHelper.getUsernameFromToken(authToken);
//			
//			if(null!=userName) {
//				
//				AccountService userDetails=(AccountService) userDetailsService.loadUserByUsername(userName);
//				
//				if(jwtTokenHelper.validateToken(authToken, (UserDetails) userDetails)) {
//					
//					UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails, null,((UserDetails) userDetails).getAuthorities());
//					authentication.setDetails(new WebAuthenticationDetails(request));
//					
//					SecurityContextHolder.getContext().setAuthentication(authentication);				
//				}	
//			}	
//		}
//		filterChain.doFilter(request, response);
//		
//	}
//	
//
//}
