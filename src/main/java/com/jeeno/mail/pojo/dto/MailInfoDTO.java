package com.jeeno.mail.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * dto for mail request
 * @author Jeeno
 * @version 0.0.1
 * @date 2021/3/19 11:02
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailInfoDTO {

    /**
     * normal receivers
     */
    private Set<String> receiver;

    /**
     * duplicate receivers
     */
    private Set<String> duplicateTo;

    /**
     * secret receivers
     */
    private Set<String> secretTo;

    /**
     * title
     */
    @NotBlank(message = "title cannot be blank")
    private String title;

    /**
     * content
     */
    private String content;

    /**
     * attach files
     */
    private Set<AttachFile> attachment;

}
