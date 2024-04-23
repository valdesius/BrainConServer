package v.inc.brainconserver.helpers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import v.inc.brainconserver.services.JwtTokenService;
import v.inc.brainconserver.services.auth.MyCustomUserDetailService;
import v.inc.brainconserver.services.auth.MyCustomUserDetails;

@Component
public class ExtractUserIDFromTokenHelper {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private MyCustomUserDetailService myCustomUserDetailService;

    private MyCustomUserDetails myCustomUserDetails;

    public int getUserIdFromToken(HttpServletRequest request){
        Integer user_id = null;
        String authHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String userEmail = null;

        if(authHeader != null || authHeader.startsWith("Bearer ")){
            jwtToken = authHeader.substring(7);
            userEmail = jwtTokenService.extractUsername(jwtToken);
        }


        if(userEmail != null){
            myCustomUserDetails = (MyCustomUserDetails) myCustomUserDetailService.loadUserByUsername(userEmail);
            user_id = myCustomUserDetails.getUserId();
        }

        return user_id;
    }

}

