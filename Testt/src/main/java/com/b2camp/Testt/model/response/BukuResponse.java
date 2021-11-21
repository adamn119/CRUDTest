package com.b2camp.Testt.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BukuResponse {
    private Long id;
    private String name;
    private String pengarang;
    private String tahunTerbit;
}
