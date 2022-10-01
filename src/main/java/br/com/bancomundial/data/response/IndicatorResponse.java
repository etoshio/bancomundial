package br.com.bancomundial.data.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndicatorResponse {
    private BaseResponse indicator;
    private BaseResponse country;
    private String countryiso3code;
    private String date;
    private Double value;
    private String unit;
    private String obs_status;
    private Integer decimal;
}
