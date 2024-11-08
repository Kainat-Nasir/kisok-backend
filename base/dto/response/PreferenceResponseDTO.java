package com.conurets.parking_kiosk.base.dto.response;

import lombok.*;

import java.io.Serializable;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class PreferenceResponseDTO implements Serializable {
    private Long id;
    private String name;
    private String value;
    private String description;
    private String status;
}