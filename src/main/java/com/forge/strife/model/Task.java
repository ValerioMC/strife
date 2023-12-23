package com.forge.strife.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.forge.strife.common.BaseEntityJsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(BaseEntityJsonView.Partial.class)
    private String requirement;

    @JsonView(BaseEntityJsonView.Partial.class)
    private String description;

    @JsonView(BaseEntityJsonView.Partial.class)
    private String component;

    @JsonView(BaseEntityJsonView.Partial.class)
    private Integer weight;
}
