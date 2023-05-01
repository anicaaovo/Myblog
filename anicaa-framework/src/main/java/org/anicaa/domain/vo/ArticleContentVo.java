package org.anicaa.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleContentVo {
    private Long categoryId;
    private String categoryName;
    private String content;
    private Date createTime;
    private Long id;
    private Boolean isComment;
    private String title;
    private Long viewCount;

}
