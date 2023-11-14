package com.chunjae.test07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import com.chunjae.test07.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPrincipal implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new UserGrant());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    // 계정이 있는지 없는지 확인 없으면 true, 있으면 false
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 인가된 사람만 호출 가능
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 사용 권한 있음 1, 없음 0
    @Override
    public boolean isEnabled() {
        return user.getActive() == 1;
    }

    public String getId() {
        return user.getLoginId();
    }

    public String getName() {
        return user.getUserName();
    }
}
