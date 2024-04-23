package v.inc.brainconserver.dto.responses;

import v.inc.brainconserver.services.auth.MyCustomUserDetails;
public class AuthResponse {

    private MyCustomUserDetails myCustomUserDetails;
    private String token;

    public AuthResponse(){

    }

    public AuthResponse(String token, MyCustomUserDetails myCustomUserDetails){
        this.token = token;
        this.myCustomUserDetails = myCustomUserDetails;
    }

    public int getUserId(){
        return this.myCustomUserDetails.getUserId();
    }

    public String getUsername(){
        return this.myCustomUserDetails.getUsername();
    }

    public String getFirstName(){
        return this.myCustomUserDetails.getFirstName();
    }

    public String getLastName(){
        return this.myCustomUserDetails.getLastName();
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
