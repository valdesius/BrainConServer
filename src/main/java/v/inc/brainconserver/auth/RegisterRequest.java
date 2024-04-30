package v.inc.brainconserver.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import v.inc.brainconserver.domain.Role;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String first_name;
  private String last_name;
  private String email;
  private String password;
  private Role role;
}
