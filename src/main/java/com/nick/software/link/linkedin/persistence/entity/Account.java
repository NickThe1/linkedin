package com.nick.software.link.linkedin.persistence.entity;

import com.nick.software.link.linkedin.persistence.entity.article.Comment;
import com.nick.software.link.linkedin.persistence.entity.article.Post;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NamedEntityGraph(name = "Account.Resume", attributeNodes = {
        @NamedAttributeNode("email"),
        @NamedAttributeNode("username"),
        @NamedAttributeNode("accountDetail"),
        @NamedAttributeNode("role")
})
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    @OneToOne(fetch = FetchType.LAZY)
    private AccountDetail accountDetail;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
