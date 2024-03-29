package com.pro07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    @NotEmpty
    @Size(min = 3, max = 100)
    private Long seq;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String writer;

    private LocalDateTime redDate;

    private LocalDateTime modDate;
}
