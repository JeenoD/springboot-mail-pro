package com.jeeno.mail.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * dto for attachment file
 * @author Jeeno
 * @version 0.0.1
 * @date 2021/3/19 11:05
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachFile {

    /**
     * filename
     */
    String filename;

    /**
     * byte array
     */
    byte[] data;

    /**
     * MIME TYPE
     */
    String type;
}
