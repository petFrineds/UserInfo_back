package petfriends.userInfo.dto;


import lombok.*;
import petfriends.userInfo.model.UserInfo;
import petfriends.userInfo.model.UserRole;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRequestDto {
  private String userId;
  private String password;
  private String userNm;
  private String telNo;

  public UserInfo toUserInfo(PasswordEncoder passwordEncoder) {
      return UserInfo.builder()
              .userId(userId)
              .password(passwordEncoder.encode(password))
              .userRole(UserRole.ROLE_USER)
              .userNm(userNm)
              .telNo(telNo)
              // .pointAmount((double)0)
              .build();
  }

  public UsernamePasswordAuthenticationToken toAuthentication() {
      return new UsernamePasswordAuthenticationToken(userId, password);
  }
}
