package org.example.authservice.domain.entity;


import jakarta.persistence.Entity;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@Builder
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String picturePath;
    private UUID videoId;
    private UUID subscriptionId;



}
