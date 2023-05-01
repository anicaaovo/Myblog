package org.anicaa.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {
    private String avatar;
    private String email;
    private Long id;
    private String nickName;
    private String sex;
}
