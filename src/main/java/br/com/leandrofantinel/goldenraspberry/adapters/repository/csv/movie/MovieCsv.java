package br.com.leandrofantinel.goldenraspberry.adapters.repository.csv.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCsv {
    private String year;
    private String title;
    private String studios;
    private String producers;
    private String winner="NO";
}
