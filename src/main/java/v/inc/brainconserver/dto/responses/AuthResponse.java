package v.inc.brainconserver.dto.responses;

import lombok.NoArgsConstructor;
import v.inc.brainconserver.service.auth.UserDetailsInfo;
@NoArgsConstructor

public class AuthResponse {

    private UserDetailsInfo myCustomUserDetails;
    private String token;

    public AuthResponse(String token, UserDetailsInfo myCustomUserDetails) {
        this.token = token;
        this.myCustomUserDetails = myCustomUserDetails;
    }

    public int getUserId() {
        return this.myCustomUserDetails.getUserId();
    }

    public String getUsername() {
        return this.myCustomUserDetails.getUsername();
    }

    public String getFirstName() {
        return this.myCustomUserDetails.getFirstName();
    }

    public String getLastName() {
        return this.myCustomUserDetails.getLastName();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
