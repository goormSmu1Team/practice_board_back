package groom.goorm_board_back.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Table(name = "user_table")
@Entity
public class User implements UserDetails {
    //Spring Security의 사용자 인증 및 권한 관리를 위해 UserDetails 상속

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;

    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;

    @Column(name="password", nullable = false)
    private String password;

    @Builder // 안정성 보장을 위해 빌더 패턴
    public User(String loginId, String password , String auth) {
        //이 빌더는 회원가입때만 사용할 용도
        this.loginId = loginId;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    } // 계정 권한 확인

    @Override
    public String getUsername() {
        return loginId;
    } // 계정 고유값 반환

    @Override
    public String getPassword() {
        return password;
    } // 계정 비밀번호 반환

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }   //	계정의 만료 여부 확인

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }   // 계정 잠금 여부 확인

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } // 비밀번호 만료 확인

    @Override
    public boolean isEnabled() {
        return true;
    }//계정 사용 가능 여부 확인

}