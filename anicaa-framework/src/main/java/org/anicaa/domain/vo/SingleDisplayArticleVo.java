package org.anicaa.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleDisplayArticleVo {
    private String categoryName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
    private Date createTime;
    private Long id;
    private Long likeCount;
    private String summary;
    private String thumbnail;
    private String title;
    private Long viewCount;

}
