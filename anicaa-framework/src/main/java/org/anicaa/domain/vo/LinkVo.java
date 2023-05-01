package org.anicaa.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {
    //网站地址
    private String address;
    private String logo;
    private Long id;
    private String description;
    private String name;
}
